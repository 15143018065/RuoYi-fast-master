package com.ruoyi.project.system.archivesUserInfo.mapper;

import java.util.List;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfo;

/**
 * 人员基本信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-08-18
 */
public interface ArchivesUserInfoMapper 
{
    /**
     * 查询人员基本信息管理
     * 
     * @param id 人员基本信息管理主键
     * @return 人员基本信息管理
     */
    public ArchivesUserInfo selectArchivesUserInfoById(Long id);

    /**
     * 查询人员基本信息管理列表
     * 
     * @param archivesUserInfo 人员基本信息管理
     * @return 人员基本信息管理集合
     */
    public List<ArchivesUserInfo> selectArchivesUserInfoList(ArchivesUserInfo archivesUserInfo);

    /**
     * 新增人员基本信息管理
     * 
     * @param archivesUserInfo 人员基本信息管理
     * @return 结果
     */
    public int insertArchivesUserInfo(ArchivesUserInfo archivesUserInfo);

    /**
     * 修改人员基本信息管理
     * 
     * @param archivesUserInfo 人员基本信息管理
     * @return 结果
     */
    public int updateArchivesUserInfo(ArchivesUserInfo archivesUserInfo);

    /**
     * 删除人员基本信息管理
     * 
     * @param id 人员基本信息管理主键
     * @return 结果
     */
    public int deleteArchivesUserInfoById(Long id);

    /**
     * 批量删除人员基本信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArchivesUserInfoByIds(String[] ids);
}
