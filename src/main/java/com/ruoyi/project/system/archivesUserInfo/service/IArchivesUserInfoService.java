package com.ruoyi.project.system.archivesUserInfo.service;

import java.util.List;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfo;

/**
 * 人员基本信息管理Service接口
 * 
 * @author ruoyi
 * @date 2021-08-18
 */
public interface IArchivesUserInfoService 
{
    /**
     * 查询人员基本信息管理
     * 
     * @param id 人员基本信息管理主键
     * @return 人员基本信息管理
     */
    public ArchivesUserInfo selectArchivesUserInfoById(Long id);

    public ArchivesUserInfo selectArchivesUserInfoByIdForPrime(Long id);

    public ArchivesUserInfo getSubListByUserInfoId(Long id);

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
     * 批量删除人员基本信息管理
     * 
     * @param ids 需要删除的人员基本信息管理主键集合
     * @return 结果
     */
    public int deleteArchivesUserInfoByIds(String ids);

    /**
     * 删除人员基本信息管理信息
     * 
     * @param id 人员基本信息管理主键
     * @return 结果
     */
    public int deleteArchivesUserInfoById(Long id);
}
