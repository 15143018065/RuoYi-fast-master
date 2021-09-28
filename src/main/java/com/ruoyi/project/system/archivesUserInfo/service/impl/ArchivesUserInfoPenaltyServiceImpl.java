package com.ruoyi.project.system.archivesUserInfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.archivesUserInfo.mapper.ArchivesUserInfoPenaltyMapper;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoPenalty;
import com.ruoyi.project.system.archivesUserInfo.service.IArchivesUserInfoPenaltyService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 档案人员奖惩情况Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Service
public class ArchivesUserInfoPenaltyServiceImpl implements IArchivesUserInfoPenaltyService 
{
    @Autowired
    private ArchivesUserInfoPenaltyMapper archivesUserInfoPenaltyMapper;

    /**
     * 查询档案人员奖惩情况
     * 
     * @param penaltyId 档案人员奖惩情况主键
     * @return 档案人员奖惩情况
     */
    @Override
    public ArchivesUserInfoPenalty selectArchivesUserInfoPenaltyByPenaltyId(Long penaltyId)
    {
        return archivesUserInfoPenaltyMapper.selectArchivesUserInfoPenaltyByPenaltyId(penaltyId);
    }

    /**
     * 查询档案人员奖惩情况列表
     * 
     * @param archivesUserInfoPenalty 档案人员奖惩情况
     * @return 档案人员奖惩情况
     */
    @Override
    public List<ArchivesUserInfoPenalty> selectArchivesUserInfoPenaltyList(ArchivesUserInfoPenalty archivesUserInfoPenalty)
    {
        return archivesUserInfoPenaltyMapper.selectArchivesUserInfoPenaltyList(archivesUserInfoPenalty);
    }

    /**
     * 新增档案人员奖惩情况
     * 
     * @param archivesUserInfoPenalty 档案人员奖惩情况
     * @return 结果
     */
    @Override
    public int insertArchivesUserInfoPenalty(ArchivesUserInfoPenalty archivesUserInfoPenalty)
    {
        archivesUserInfoPenalty.setCreateTime(DateUtils.getNowDate());
        return archivesUserInfoPenaltyMapper.insertArchivesUserInfoPenalty(archivesUserInfoPenalty);
    }

    /**
     * 修改档案人员奖惩情况
     * 
     * @param archivesUserInfoPenalty 档案人员奖惩情况
     * @return 结果
     */
    @Override
    public int updateArchivesUserInfoPenalty(ArchivesUserInfoPenalty archivesUserInfoPenalty)
    {
        archivesUserInfoPenalty.setUpdateTime(DateUtils.getNowDate());
        return archivesUserInfoPenaltyMapper.updateArchivesUserInfoPenalty(archivesUserInfoPenalty);
    }

    /**
     * 批量删除档案人员奖惩情况
     * 
     * @param penaltyIds 需要删除的档案人员奖惩情况主键
     * @return 结果
     */
    @Override
    public int deleteArchivesUserInfoPenaltyByPenaltyIds(String penaltyIds)
    {
        return archivesUserInfoPenaltyMapper.deleteArchivesUserInfoPenaltyByPenaltyIds(Convert.toStrArray(penaltyIds));
    }

    /**
     * 删除档案人员奖惩情况信息
     * 
     * @param penaltyId 档案人员奖惩情况主键
     * @return 结果
     */
    @Override
    public int deleteArchivesUserInfoPenaltyByPenaltyId(Long penaltyId)
    {
        return archivesUserInfoPenaltyMapper.deleteArchivesUserInfoPenaltyByPenaltyId(penaltyId);
    }
}
