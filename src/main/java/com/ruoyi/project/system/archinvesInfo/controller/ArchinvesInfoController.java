package com.ruoyi.project.system.archinvesInfo.controller;

import java.util.List;
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
import com.ruoyi.project.system.archinvesInfo.domain.ArchinvesInfo;
import com.ruoyi.project.system.archinvesInfo.service.IArchinvesInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 档案目录信息Controller
 * 
 * @author ruoyi
 * @date 2021-08-19
 */
@Controller
@RequestMapping("/system/archinvesInfo")
public class ArchinvesInfoController extends BaseController
{
    private String prefix = "system/archinvesInfo";

    @Autowired
    private IArchinvesInfoService archinvesInfoService;

    @RequiresPermissions("system:archinvesInfo:view")
    @GetMapping()
    public String archinvesInfo()
    {
        return prefix + "/archinvesInfo";
    }

    /**
     * 查询档案目录信息列表
     */
    @RequiresPermissions("system:archinvesInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ArchinvesInfo archinvesInfo)
    {
        startPage();
        List<ArchinvesInfo> list = archinvesInfoService.selectArchinvesInfoList(archinvesInfo);
        return getDataTable(list);
    }

    /**
     * 导出档案目录信息列表
     */
    @RequiresPermissions("system:archinvesInfo:export")
    @Log(title = "档案目录信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ArchinvesInfo archinvesInfo)
    {
        List<ArchinvesInfo> list = archinvesInfoService.selectArchinvesInfoList(archinvesInfo);
        ExcelUtil<ArchinvesInfo> util = new ExcelUtil<ArchinvesInfo>(ArchinvesInfo.class);
        return util.exportExcel(list, "档案目录信息数据");
    }

    /**
     * 新增档案目录信息
     */
    @GetMapping("/add/{userInfoId}")
    public String add(@PathVariable("userInfoId") Long userInfoId,ModelMap mmap)
    {
        mmap.put("userInfoId",userInfoId);
        return prefix + "/add";
    }

    /**
     * 新增保存档案目录信息
     */
    @RequiresPermissions("system:archinvesInfo:add")
    @Log(title = "档案目录信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ArchinvesInfo archinvesInfo)
    {
        return toAjax(archinvesInfoService.insertArchinvesInfo(archinvesInfo));
    }

    /**
     * 修改档案目录信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ArchinvesInfo archinvesInfo = archinvesInfoService.selectArchinvesInfoById(id);
        mmap.put("archinvesInfo", archinvesInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存档案目录信息
     */
    @RequiresPermissions("system:archinvesInfo:edit")
    @Log(title = "档案目录信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ArchinvesInfo archinvesInfo)
    {
        return toAjax(archinvesInfoService.updateArchinvesInfo(archinvesInfo));
    }

    /**
     * 删除档案目录信息
     */
    @RequiresPermissions("system:archinvesInfo:remove")
    @Log(title = "档案目录信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(archinvesInfoService.deleteArchinvesInfoByIds(ids));
    }
}
