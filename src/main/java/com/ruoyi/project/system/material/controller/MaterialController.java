package com.ruoyi.project.system.material.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.ArchivesImageInfo.domain.ArchivesImageInfo;
import com.ruoyi.project.system.ArchivesImageInfo.service.IArchivesImageInfoService;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfo;
import com.ruoyi.project.system.archivesUserInfo.service.IArchivesUserInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.material.domain.Material;
import com.ruoyi.project.system.material.service.IMaterialService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.Ztree;

/**
 * 档案材料分类Controller
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
@Controller
@RequestMapping("/system/material")
public class MaterialController extends BaseController
{
    private String prefix = "system/material";

    @Autowired
    private IMaterialService materialService;

    @Autowired
    private IArchivesUserInfoService archivesUserInfoService;

    @Autowired
    private IArchivesImageInfoService archivesImageInfoService;

    @RequiresPermissions("system:material:view")
    @GetMapping()
    public String material()
    {
        return prefix + "/material";
    }

    /**
     * 查询档案材料分类树列表
     */
    @RequiresPermissions("system:material:list")
    @PostMapping("/list")
    @ResponseBody
    public List<Material> list(Material material)
    {
        List<Material> list = materialService.selectMaterialList(material);
        return list;
    }

    /**
     * 导出档案材料分类列表
     */
    @RequiresPermissions("system:material:export")
    @Log(title = "档案材料分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Material material)
    {
        List<Material> list = materialService.selectMaterialList(material);
        ExcelUtil<Material> util = new ExcelUtil<Material>(Material.class);
        return util.exportExcel(list, "档案材料分类数据");
    }

    /**
     * 新增档案材料分类
     */
    @GetMapping(value = { "/add/{materialId}/{id}", "/add/{materialId}/", "/add/" })
    public String add(@PathVariable(value = "materialId", required = false) Long materialId,
                      @PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(materialId))
        {
            mmap.put("material", materialService.selectMaterialByMaterialId(materialId));
        } else {
            mmap.put("material", new Material());
        }
        if (ObjectUtils.isNotEmpty(id)) {
            mmap.put("userInfoId", archivesUserInfoService.selectArchivesUserInfoById(id));
        } else {
            mmap.put("userInfoId", new ArchivesUserInfo());
        }
        return prefix + "/add";
    }

    /**
     * 新增保存档案材料分类
     */
    @RequiresPermissions("system:material:add")
    @Log(title = "档案材料分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Material material)
    {
        return toAjax(materialService.insertMaterial(material));
    }

    /**
     * 修改档案材料分类
     */
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") Long materialId, ModelMap mmap)
    {
        Material material = materialService.selectMaterialByMaterialId(materialId);
        mmap.put("material", material);
        return prefix + "/edit";
    }

    /**
     * 修改保存档案材料分类
     */
    @RequiresPermissions("system:material:edit")
    @Log(title = "档案材料分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Material material)
    {
        return toAjax(materialService.updateMaterial(material));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:material:remove")
    @Log(title = "档案材料分类", businessType = BusinessType.DELETE)
    @GetMapping(value = {"/remove/{materialId}", "/remove/{materialId}/{userInfoId}"})
    @ResponseBody
    public AjaxResult remove(@PathVariable("materialId") Long materialId, @PathVariable("userInfoId") Long userInfoId)
    {
        if (materialService.selectMaterialByMaterialId(materialId).getBasicFlg().equals("1")) {
            return error("基础分类禁止删除");
        }
        ArchivesImageInfo query = new ArchivesImageInfo();
        query.setDictCode(materialId);
        if (CollectionUtils.isNotEmpty(archivesImageInfoService.selectArchivesImageInfoList(query))) {
            return error("该材料分类下存在档案，请删除档案后再进行分类删除操作");
        }
        if (ObjectUtils.isNotEmpty(userInfoId)) {
            Material materialQuery = new Material();
            materialQuery.setParentId(materialId);
            materialQuery.setUserInfoId(String.valueOf(userInfoId));
            if (CollectionUtils.isNotEmpty(materialService.selectMaterialList(materialQuery))) {
                return error("该材料分类下存在子分类，请删除子分类后再进行分类删除操作");
            }
        }
        return toAjax(materialService.deleteMaterialByMaterialId(materialId));
    }

    /**
     * 选择档案材料分类树
     */
    @GetMapping(value = { "/selectMaterialTree/{materialId}/{userInfoId}", "/selectMaterialTree/{materialId}", "/selectMaterialTree/" })
    public String selectMaterialTree(@PathVariable(value = "materialId", required = false) Long materialId,
                                     @PathVariable(value = "userInfoId", required = false) Long userInfoId, ModelMap mmap)
    {
        if (ObjectUtils.isNotEmpty(userInfoId)) {
            mmap.put("userInfoId", String.valueOf(userInfoId));
        } else {
            mmap.put("userInfoId", String.valueOf(0));
        }
        if (StringUtils.isNotNull(materialId))
        {
            mmap.put("material", materialService.selectMaterialByMaterialId(materialId));
        } else {
            mmap.put("material", new Material());
        }
        return prefix + "/tree";
    }

    /**
     * 加载档案材料分类树列表
     */
    @GetMapping("/treeData/{userInfoId}")
    @ResponseBody
    public List<Ztree> treeData(@PathVariable(value = "userInfoId") Long userInfoId)
    {
        Material material = new Material();
        material.setUserInfoId(String.valueOf(userInfoId));
        List<Ztree> ztrees = materialService.selectMaterialTree(material);
        return ztrees;
    }

    /**
     * 加载档案材料分类树列表
     */
    @GetMapping("/treeDataImg/{code}/{id}")
    @ResponseBody
    public AjaxResult treeDataImg(@PathVariable("code") Long code, @PathVariable("id") String id)
    {
        Map<String, Object> ztrees = new HashMap();
        if (!code.equals(0L)) {
            ztrees = materialService.selectMaterialTreeImg(code, id);
        } else {
            ztrees = materialService.selectMaterialTreeImg(null, id);
        }
        return AjaxResult.success(ztrees);
    }
}
