package com.ruoyi.project.system.archivesUserInfo.mapper;

import java.util.List;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoRelative;

/**
 * 档案人员家庭成员Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
public interface ArchivesUserInfoRelativeMapper 
{
    /**
     * 查询档案人员家庭成员
     * 
     * @param relativeId 档案人员家庭成员主键
     * @return 档案人员家庭成员
     */
    public ArchivesUserInfoRelative selectArchivesUserInfoRelativeByRelativeId(Long relativeId);

    /**
     * 查询档案人员家庭成员列表
     * 
     * @param archivesUserInfoRelative 档案人员家庭成员
     * @return 档案人员家庭成员集合
     */
    public List<ArchivesUserInfoRelative> selectArchivesUserInfoRelativeList(ArchivesUserInfoRelative archivesUserInfoRelative);

    /**
     * 新增档案人员家庭成员
     * 
     * @param archivesUserInfoRelative 档案人员家庭成员
     * @return 结果
     */
    public int insertArchivesUserInfoRelative(ArchivesUserInfoRelative archivesUserInfoRelative);

    /**
     * 修改档案人员家庭成员
     * 
     * @param archivesUserInfoRelative 档案人员家庭成员
     * @return 结果
     */
    public int updateArchivesUserInfoRelative(ArchivesUserInfoRelative archivesUserInfoRelative);

    /**
     * 删除档案人员家庭成员
     * 
     * @param relativeId 档案人员家庭成员主键
     * @return 结果
     */
    public int deleteArchivesUserInfoRelativeByRelativeId(Long relativeId);

    /**
     * 批量删除档案人员家庭成员
     * 
     * @param relativeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArchivesUserInfoRelativeByRelativeIds(String[] relativeIds);
}
