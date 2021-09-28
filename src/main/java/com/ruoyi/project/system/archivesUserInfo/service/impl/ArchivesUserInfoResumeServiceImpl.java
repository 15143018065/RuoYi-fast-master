package com.ruoyi.project.system.archivesUserInfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.archivesUserInfo.mapper.ArchivesUserInfoResumeMapper;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoResume;
import com.ruoyi.project.system.archivesUserInfo.service.IArchivesUserInfoResumeService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 档案人员简历Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
@Service
public class ArchivesUserInfoResumeServiceImpl implements IArchivesUserInfoResumeService 
{
    @Autowired
    private ArchivesUserInfoResumeMapper archivesUserInfoResumeMapper;

    /**
     * 查询档案人员简历
     * 
     * @param resumeId 档案人员简历主键
     * @return 档案人员简历
     */
    @Override
    public ArchivesUserInfoResume selectArchivesUserInfoResumeByResumeId(Long resumeId)
    {
        return archivesUserInfoResumeMapper.selectArchivesUserInfoResumeByResumeId(resumeId);
    }

    /**
     * 查询档案人员简历列表
     * 
     * @param archivesUserInfoResume 档案人员简历
     * @return 档案人员简历
     */
    @Override
    public List<ArchivesUserInfoResume> selectArchivesUserInfoResumeList(ArchivesUserInfoResume archivesUserInfoResume)
    {
        return archivesUserInfoResumeMapper.selectArchivesUserInfoResumeList(archivesUserInfoResume);
    }

    /**
     * 新增档案人员简历
     * 
     * @param archivesUserInfoResume 档案人员简历
     * @return 结果
     */
    @Override
    public int insertArchivesUserInfoResume(ArchivesUserInfoResume archivesUserInfoResume)
    {
        archivesUserInfoResume.setCreateTime(DateUtils.getNowDate());
        return archivesUserInfoResumeMapper.insertArchivesUserInfoResume(archivesUserInfoResume);
    }

    /**
     * 修改档案人员简历
     * 
     * @param archivesUserInfoResume 档案人员简历
     * @return 结果
     */
    @Override
    public int updateArchivesUserInfoResume(ArchivesUserInfoResume archivesUserInfoResume)
    {
        archivesUserInfoResume.setUpdateTime(DateUtils.getNowDate());
        return archivesUserInfoResumeMapper.updateArchivesUserInfoResume(archivesUserInfoResume);
    }

    /**
     * 批量删除档案人员简历
     * 
     * @param resumeIds 需要删除的档案人员简历主键
     * @return 结果
     */
    @Override
    public int deleteArchivesUserInfoResumeByResumeIds(String resumeIds)
    {
        return archivesUserInfoResumeMapper.deleteArchivesUserInfoResumeByResumeIds(Convert.toStrArray(resumeIds));
    }

    /**
     * 删除档案人员简历信息
     * 
     * @param resumeId 档案人员简历主键
     * @return 结果
     */
    @Override
    public int deleteArchivesUserInfoResumeByResumeId(Long resumeId)
    {
        return archivesUserInfoResumeMapper.deleteArchivesUserInfoResumeByResumeId(resumeId);
    }
}
