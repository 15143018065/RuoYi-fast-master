package com.ruoyi.project.system.archinvesInfo.controller;

//public class MissionsController {
//}

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.ArchivesImageInfo.mapper.ArchivesImageInfoMapper;
import com.ruoyi.project.system.ArchivesImageInfo.service.impl.ArchivesImageInfoServiceImpl;
import com.ruoyi.project.system.archinvesInfo.domain.MissionsSeqBean;
import com.ruoyi.project.system.archinvesInfo.domain.UpPicData;
import com.ruoyi.project.system.archivesUserInfo.service.impl.ArchivesUserInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * swagger 用户测试方法
 *
 * @author ruoyi
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/sys/missions")
public class MissionsController extends BaseController
{
    @Autowired
    private ArchivesUserInfoServiceImpl archivesUserInfoServiceImpl;

    @Autowired
    private ArchivesImageInfoServiceImpl archivesImageInfoServiceImpl;

    @ApiOperation("获取任务处理情况")
    @ApiImplicitParam(name = "sn")
    @GetMapping("/{sn}")
    public AjaxResult getMissions(@PathVariable String sn)
    {
        return AjaxResult.success(missionsSeqPool.getMissions(sn));
    }

    @ApiOperation("删除任务")
    @ApiImplicitParam(name = "sn")
    @GetMapping("/del/{sn}")
    public AjaxResult dlMissions(@PathVariable String sn)
    {
        return AjaxResult.success(missionsSeqPool.ClearMissions(sn));
    }

    @ApiOperation("新增打印")
    @ApiImplicitParam(name = "sn")
    @GetMapping("/primeData/{id}")
    public AjaxResult primeData(@PathVariable Long id)
    {
        return AjaxResult.success(archivesUserInfoServiceImpl.selectArchivesUserInfoByIdForPrime(id));
    }

    @ApiOperation("上报数据")
    @PostMapping("/putData")
    public AjaxResult putData(@RequestBody UpPicData ud)
    {
        String ret="保存成功" ;
        if (StringUtils.isNull(ud) || StringUtils.isNull(ud.getSn()))
        {
            return error("任务ID不能为空");
        }
        if (ud.getRyid().equals("0")) {
            missionsSeqPool.putMissions(ud.getSn(), ud.getSn(),
                    archivesImageInfoServiceImpl.saveTempFile(ud.getYszp()));
            return AjaxResult.success(ret);
        }
        archivesImageInfoServiceImpl.insertArchivesImageInfo(ud);
        return AjaxResult.success(ret);
    }

    @ApiOperation("上报任务")
    @PostMapping("/putMissions")
    public AjaxResult putmissions(@RequestBody MissionsSeqBean mb)
    {
        if (StringUtils.isNull(mb) || StringUtils.isNull(mb.getSn()))
        {
            return error("任务ID不能为空");
        }
        return AjaxResult.success(missionsSeqPool.putMissions(mb.getFl(), mb.getSn(),mb.getData()));
    }
}
