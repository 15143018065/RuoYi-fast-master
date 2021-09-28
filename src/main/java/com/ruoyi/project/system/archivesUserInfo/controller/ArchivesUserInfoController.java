package com.ruoyi.project.system.archivesUserInfo.controller;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.project.system.archinvesInfo.controller.missionsSeqPool;
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
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfo;
import com.ruoyi.project.system.archivesUserInfo.service.IArchivesUserInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 人员基本信息管理Controller
 * 
 * @author ruoyi
 * @date 2021-08-18
 */
@Controller
@RequestMapping("/system/archivesUserInfo")
public class ArchivesUserInfoController extends BaseController
{
    private String prefix = "system/archivesUserInfo";

    @Autowired
    private IArchivesUserInfoService archivesUserInfoService;

    @RequiresPermissions("system:archivesUserInfo:view")
    @GetMapping()
    public String archivesUserInfo()
    {
        return prefix + "/archivesUserInfo";
    }

    /**
     * 查询人员基本信息管理列表
     */
    @RequiresPermissions("system:archivesUserInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ArchivesUserInfo archivesUserInfo)
    {
        startPage();
        List<ArchivesUserInfo> list = archivesUserInfoService.selectArchivesUserInfoList(archivesUserInfo);
        return getDataTable(list);
    }

    /**
     * 导出人员基本信息管理列表
     */
    @RequiresPermissions("system:archivesUserInfo:export")
    @Log(title = "人员基本信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ArchivesUserInfo archivesUserInfo)
    {
        List<ArchivesUserInfo> list = archivesUserInfoService.selectArchivesUserInfoList(archivesUserInfo);
        ExcelUtil<ArchivesUserInfo> util = new ExcelUtil<ArchivesUserInfo>(ArchivesUserInfo.class);
        return util.exportExcel(list, "人员基本信息管理数据");
    }

    /**
     * 新增人员基本信息管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人员基本信息管理
     */
    @RequiresPermissions("system:archivesUserInfo:add")
    @Log(title = "人员基本信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ArchivesUserInfo archivesUserInfo)
    {
        return toAjax(archivesUserInfoService.insertArchivesUserInfo(archivesUserInfo));
    }

    /**
     * 修改人员基本信息管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ArchivesUserInfo archivesUserInfo = archivesUserInfoService.selectArchivesUserInfoById(id);
        mmap.put("archivesUserInfo", archivesUserInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员基本信息管理
     */
    @RequiresPermissions("system:archivesUserInfo:edit")
    @Log(title = "人员基本信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ArchivesUserInfo archivesUserInfo)
    {
        return toAjax(archivesUserInfoService.updateArchivesUserInfo(archivesUserInfo));
    }

    /**
     * 删除人员基本信息管理
     */
    @RequiresPermissions("system:archivesUserInfo:remove")
    @Log(title = "人员基本信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(archivesUserInfoService.deleteArchivesUserInfoByIds(ids));
    }


    /**
     * 查询个人档案管理信息
     */
    @RequiresPermissions("system:archivesUserInfo:list")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("userInfoId", archivesUserInfoService.selectArchivesUserInfoById(id));
        return "system/ArchivesImageInfo/ArchivesImageInfo";
    }

    @GetMapping("/cancel/{id}")
    public String cancel(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("archivesUserInfo", archivesUserInfoService.selectArchivesUserInfoById(id));
        return prefix + "/cancel";
    }

    @GetMapping("/getPath/{userInfoId}")
    public String getPath(@PathVariable("userInfoId") Long userInfoId){
        String pathStr = "aaaa";

        return pathStr;
    }

    @GetMapping("/getSubList")
    @ResponseBody
    public AjaxResult getSubList(Long id){
        return AjaxResult.success(archivesUserInfoService.getSubListByUserInfoId(id));
    }

    @GetMapping("/getSn")
    @ResponseBody
    public AjaxResult getSn(){
        String sn = UUID.randomUUID().toString();
        return AjaxResult.success(sn);
    }

    @GetMapping("/checkReturn")
    @ResponseBody
    public AjaxResult checkReturn(String sn)
    {
        String result = "";
        try {
            HashMap map = JSON.parseObject(missionsSeqPool.getMissions(sn), HashMap.class);
            if (map.containsKey("picdata")) {
                result = String.valueOf(map.get("picdata"));
            }
            //result = missionsSeqPool.getMissions(sn);
        }catch (Exception e) {
            //
        }
        if (ObjectUtils.isNotEmpty(result)) {
            missionsSeqPool.ClearMissions(sn);
            return AjaxResult.success(result);
        } else {
            return AjaxResult.error();
        }
    }
}
