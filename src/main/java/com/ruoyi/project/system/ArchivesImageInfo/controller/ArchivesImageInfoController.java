package com.ruoyi.project.system.ArchivesImageInfo.controller;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.security.ShiroUtils;
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
import com.ruoyi.project.system.ArchivesImageInfo.domain.ArchivesImageInfo;
import com.ruoyi.project.system.ArchivesImageInfo.service.IArchivesImageInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 档案图像存储索引信息Controller
 * 
 * @author ruoyi
 * @date 2021-08-24
 */
@Controller
@RequestMapping("/system/ArchivesImageInfo")
public class ArchivesImageInfoController extends BaseController
{
    private String prefix = "system/ArchivesImageInfo";

    @Autowired
    private IArchivesImageInfoService archivesImageInfoService;

//    @RequiresPermissions("system:ArchivesImageInfo:view")
    @GetMapping()
    public String ArchivesImageInfo()
    {
        return prefix + "/ArchivesImageInfo";
    }

    /**
     * 查询档案图像存储索引信息列表
     */
//    @RequiresPermissions("system:ArchivesImageInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ArchivesImageInfo archivesImageInfo)
    {
        startPage();
        List<ArchivesImageInfo> list = archivesImageInfoService.selectArchivesImageInfoList(archivesImageInfo);
        return getDataTable(list);
    }

    /**
     * 查询档案图像存储索引信息列表
     */
//    @RequiresPermissions("system:ArchivesImageInfo:list")
    @GetMapping("/getList")
    @ResponseBody
    public AjaxResult getList(Long dictcode, Long userInfoId)
    {
        ArchivesImageInfo query = new ArchivesImageInfo();
        query.setUserInfoId(userInfoId);
        return AjaxResult.success(archivesImageInfoService.selectArchivesImageInfoListByDict(query));
    }

    /**
     * 查询档案图像存储索引信息列表
     */
    @GetMapping("/getSn")
    @ResponseBody
    public AjaxResult getSn(Long dictcode)
    {
        List<Map<String, String>> resultMap = new ArrayList<>();
        Map<String, String> sn = new HashMap<>();
        Map<String, String> userId = new HashMap<>();
        sn.put("sn", UUID.randomUUID().toString());
        userId.put("userId", String.valueOf(ShiroUtils.getUserId()));
        resultMap.add(sn);
        resultMap.add(userId);
        return AjaxResult.success(resultMap);
    }

    /**
     * 导出档案图像存储索引信息列表
     */
//    @RequiresPermissions("system:ArchivesImageInfo:export")
    @Log(title = "档案图像存储索引信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ArchivesImageInfo archivesImageInfo)
    {
        List<ArchivesImageInfo> list = archivesImageInfoService.selectArchivesImageInfoList(archivesImageInfo);
        ExcelUtil<ArchivesImageInfo> util = new ExcelUtil<ArchivesImageInfo>(ArchivesImageInfo.class);
        return util.exportExcel(list, "档案图像存储索引信息数据");
    }

    /**
     * 新增档案图像存储索引信息
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap)
    {
        Long dictCode = Long.valueOf(id.substring(0, id.indexOf(",")));
        Long userInfoId = Long.valueOf(id.substring(id.indexOf(",") + 1, id.length()));
        ArchivesImageInfo archivesImageInfo = new ArchivesImageInfo();
        archivesImageInfo.setDictCode(dictCode);
        archivesImageInfo.setUserInfoId(userInfoId);
        mmap.put("addInfo", archivesImageInfo);
        return prefix + "/add";
    }

//    /**
//     * 新增保存档案图像存储索引信息
//     */
//    @RequiresPermissions("system:ArchivesImageInfo:add")
//    @Log(title = "档案图像存储索引信息", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(ArchivesImageInfo archivesImageInfo, HttpServletRequest request)
//    {
//        return toAjax(archivesImageInfoService.insertArchivesImageInfo(archivesImageInfo, request));
//    }

    /**
     * 修改档案图像存储索引信息-
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ArchivesImageInfo archivesImageInfo = archivesImageInfoService.selectArchivesImageInfoById(id);
        mmap.put("archivesImageInfo", archivesImageInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存档案图像存储索引信息
     */
//    @RequiresPermissions("system:ArchivesImageInfo:edit")
    @Log(title = "档案图像存储索引信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ArchivesImageInfo archivesImageInfo, HttpServletRequest request)
    {
        return toAjax(archivesImageInfoService.updateArchivesImageInfo(archivesImageInfo));
    }

    /**
     * 删除档案图像存储索引信息
     */
//    @RequiresPermissions("system:ArchivesImageInfo:remove")
    @Log(title = "档案图像存储索引信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(archivesImageInfoService.deleteArchivesImageInfoByIds(ids));
    }

    @PostMapping("/getPath/{userInfoId}")
    public String getPath(@PathVariable("userInfoId") Long userInfoId){
        String pathStr = "D:\\mzdata";

        return pathStr;
    }


    /**
     * 查询档案图像存储索引信息列表
     */
    @GetMapping("/checkReturn")
    @ResponseBody
    public AjaxResult checkReturn(String sn)
    {
        String result = "";
        try {
            result = missionsSeqPool.getMissions(sn);
        }catch (Exception e) {
            //
        }
        if (ObjectUtils.isNotEmpty(result)) {
            return AjaxResult.success(result);
        } else {
            return AjaxResult.error();
        }
    }

    /**
     * 查询档案图像存储索引信息列表
     */
    @PostMapping("/searchBy")
    @ResponseBody
    public AjaxResult searchBy(ArchivesImageInfo archivesImageInfo)
    {
        List<ArchivesImageInfo> result = archivesImageInfoService.selectArchivesImageInfoListByDict(archivesImageInfo);
        return AjaxResult.success(result);
    }
}
