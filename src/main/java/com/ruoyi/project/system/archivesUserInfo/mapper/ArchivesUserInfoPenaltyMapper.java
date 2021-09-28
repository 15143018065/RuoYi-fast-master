package com.ruoyi.project.system.archivesUserInfo.mapper;

import java.util.List;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoPenalty;

/**
 * 档案人员奖惩情况Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public interface ArchivesUserInfoPenaltyMapper 
{
    /**
     * 查询档案人员奖惩情况
     * 
     * @param penaltyId 档案人员奖惩情况主键
     * @return 档案人员奖惩情况
     */
    public ArchivesUserInfoPenalty selectArchivesUserInfoPenaltyByPenaltyId(Long penaltyId);

    /**
     * 查询档案人员奖惩情况列表
     * 
     * @param archivesUserInfoPenalty 档案人员奖惩情况
     * @return 档案人员奖惩情况集合
     */
    public List<ArchivesUserInfoPenalty> selectArchivesUserInfoPenaltyList(ArchivesUserInfoPenalty archivesUserInfoPenalty);

    /**
     * 新增档案人员奖惩情况
     * 
     * @param archivesUserInfoPenalty 档案人员奖惩情况
     * @return 结果
     */
    public int insertArchivesUserInfoPenalty(ArchivesUserInfoPenalty archivesUserInfoPenalty);

    /**
     * 修改档案人员奖惩情况
     * 
     * @param archivesUserInfoPenalty 档案人员奖惩情况
     * @return 结果
     */
    public int updateArchivesUserInfoPenalty(ArchivesUserInfoPenalty archivesUserInfoPenalty);

    /**
     * 删除档案人员奖惩情况
     * 
     * @param penaltyId 档案人员奖惩情况主键
     * @return 结果
     */
    public int deleteArchivesUserInfoPenaltyByPenaltyId(Long penaltyId);

    /**
     * 批量删除档案人员奖惩情况
     * 
     * @param penaltyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArchivesUserInfoPenaltyByPenaltyIds(String[] penaltyIds);
}
