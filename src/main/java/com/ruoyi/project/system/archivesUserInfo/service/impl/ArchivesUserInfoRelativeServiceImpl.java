package com.ruoyi.project.system.archivesUserInfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.archivesUserInfo.mapper.ArchivesUserInfoRelativeMapper;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoRelative;
import com.ruoyi.project.system.archivesUserInfo.service.IArchivesUserInfoRelativeService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 档案人员家庭成员Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
@Service
public class ArchivesUserInfoRelativeServiceImpl implements IArchivesUserInfoRelativeService 
{
    @Autowired
    private ArchivesUserInfoRelativeMapper archivesUserInfoRelativeMapper;

    /**
     * 查询档案人员家庭成员
     * 
     * @param relativeId 档案人员家庭成员主键
     * @return 档案人员家庭成员
     */
    @Override
    public ArchivesUserInfoRelative selectArchivesUserInfoRelativeByRelativeId(Long relativeId)
    {
        return archivesUserInfoRelativeMapper.selectArchivesUserInfoRelativeByRelativeId(relativeId);
    }

    /**
     * 查询档案人员家庭成员列表
     * 
     * @param archivesUserInfoRelative 档案人员家庭成员
     * @return 档案人员家庭成员
     */
    @Override
    public List<ArchivesUserInfoRelative> selectArchivesUserInfoRelativeList(ArchivesUserInfoRelative archivesUserInfoRelative)
    {
        return archivesUserInfoRelativeMapper.selectArchivesUserInfoRelativeList(archivesUserInfoRelative);
    }

    /**
     * 新增档案人员家庭成员
     * 
     * @param archivesUserInfoRelative 档案人员家庭成员
     * @return 结果
     */
    @Override
    public int insertArchivesUserInfoRelative(ArchivesUserInfoRelative archivesUserInfoRelative)
    {
        archivesUserInfoRelative.setCreateTime(DateUtils.getNowDate());
        return archivesUserInfoRelativeMapper.insertArchivesUserInfoRelative(archivesUserInfoRelative);
    }

    /**
     * 修改档案人员家庭成员
     * 
     * @param archivesUserInfoRelative 档案人员家庭成员
     * @return 结果
     */
    @Override
    public int updateArchivesUserInfoRelative(ArchivesUserInfoRelative archivesUserInfoRelative)
    {
        archivesUserInfoRelative.setUpdateTime(DateUtils.getNowDate());
        return archivesUserInfoRelativeMapper.updateArchivesUserInfoRelative(archivesUserInfoRelative);
    }

    /**
     * 批量删除档案人员家庭成员
     * 
     * @param relativeIds 需要删除的档案人员家庭成员主键
     * @return 结果
     */
    @Override
    public int deleteArchivesUserInfoRelativeByRelativeIds(String relativeIds)
    {
        return archivesUserInfoRelativeMapper.deleteArchivesUserInfoRelativeByRelativeIds(Convert.toStrArray(relativeIds));
    }

    /**
     * 删除档案人员家庭成员信息
     * 
     * @param relativeId 档案人员家庭成员主键
     * @return 结果
     */
    @Override
    public int deleteArchivesUserInfoRelativeByRelativeId(Long relativeId)
    {
        return archivesUserInfoRelativeMapper.deleteArchivesUserInfoRelativeByRelativeId(relativeId);
    }
}
