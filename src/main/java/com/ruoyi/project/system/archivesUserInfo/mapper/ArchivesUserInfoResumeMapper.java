package com.ruoyi.project.system.archivesUserInfo.mapper;

import java.util.List;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoResume;

/**
 * 档案人员简历Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
public interface ArchivesUserInfoResumeMapper 
{
    /**
     * 查询档案人员简历
     * 
     * @param resumeId 档案人员简历主键
     * @return 档案人员简历
     */
    public ArchivesUserInfoResume selectArchivesUserInfoResumeByResumeId(Long resumeId);

    /**
     * 查询档案人员简历列表
     * 
     * @param archivesUserInfoResume 档案人员简历
     * @return 档案人员简历集合
     */
    public List<ArchivesUserInfoResume> selectArchivesUserInfoResumeList(ArchivesUserInfoResume archivesUserInfoResume);

    /**
     * 新增档案人员简历
     * 
     * @param archivesUserInfoResume 档案人员简历
     * @return 结果
     */
    public int insertArchivesUserInfoResume(ArchivesUserInfoResume archivesUserInfoResume);

    /**
     * 修改档案人员简历
     * 
     * @param archivesUserInfoResume 档案人员简历
     * @return 结果
     */
    public int updateArchivesUserInfoResume(ArchivesUserInfoResume archivesUserInfoResume);

    /**
     * 删除档案人员简历
     * 
     * @param resumeId 档案人员简历主键
     * @return 结果
     */
    public int deleteArchivesUserInfoResumeByResumeId(Long resumeId);

    /**
     * 批量删除档案人员简历
     * 
     * @param resumeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArchivesUserInfoResumeByResumeIds(String[] resumeIds);
}
