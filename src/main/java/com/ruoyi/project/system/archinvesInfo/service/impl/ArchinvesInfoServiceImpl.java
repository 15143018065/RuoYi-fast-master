package com.ruoyi.project.system.archinvesInfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.archinvesInfo.mapper.ArchinvesInfoMapper;
import com.ruoyi.project.system.archinvesInfo.domain.ArchinvesInfo;
import com.ruoyi.project.system.archinvesInfo.service.IArchinvesInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 档案目录信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-19
 */
@Service
public class ArchinvesInfoServiceImpl implements IArchinvesInfoService 
{
    @Autowired
    private ArchinvesInfoMapper archinvesInfoMapper;

    /**
     * 查询档案目录信息
     * 
     * @param id 档案目录信息主键
     * @return 档案目录信息
     */
    @Override
    public ArchinvesInfo selectArchinvesInfoById(Long id)
    {
        return archinvesInfoMapper.selectArchinvesInfoById(id);
    }

    /**
     * 查询档案目录信息列表
     * 
     * @param archinvesInfo 档案目录信息
     * @return 档案目录信息
     */
    @Override
    public List<ArchinvesInfo> selectArchinvesInfoList(ArchinvesInfo archinvesInfo)
    {
        return archinvesInfoMapper.selectArchinvesInfoList(archinvesInfo);
    }

    /**
     * 新增档案目录信息
     * 
     * @param archinvesInfo 档案目录信息
     * @return 结果
     */
    @Override
    public int insertArchinvesInfo(ArchinvesInfo archinvesInfo)
    {
        archinvesInfo.setCreateTime(DateUtils.getNowDate());
        return archinvesInfoMapper.insertArchinvesInfo(archinvesInfo);
    }

    /**
     * 修改档案目录信息
     * 
     * @param archinvesInfo 档案目录信息
     * @return 结果
     */
    @Override
    public int updateArchinvesInfo(ArchinvesInfo archinvesInfo)
    {
        archinvesInfo.setUpdateTime(DateUtils.getNowDate());
        return archinvesInfoMapper.updateArchinvesInfo(archinvesInfo);
    }

    /**
     * 批量删除档案目录信息
     * 
     * @param ids 需要删除的档案目录信息主键
     * @return 结果
     */
    @Override
    public int deleteArchinvesInfoByIds(String ids)
    {
        return archinvesInfoMapper.deleteArchinvesInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除档案目录信息信息
     * 
     * @param id 档案目录信息主键
     * @return 结果
     */
    @Override
    public int deleteArchinvesInfoById(Long id)
    {
        return archinvesInfoMapper.deleteArchinvesInfoById(id);
    }
}
