package com.ruoyi.project.system.ArchivesImageInfo.mapper;

import java.util.List;
import com.ruoyi.project.system.ArchivesImageInfo.domain.ArchivesImageInfo;

/**
 * 档案图像存储索引信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-08-24
 */
public interface ArchivesImageInfoMapper 
{
    /**
     * 查询档案图像存储索引信息
     * 
     * @param id 档案图像存储索引信息主键
     * @return 档案图像存储索引信息
     */
    public ArchivesImageInfo selectArchivesImageInfoById(Long id);

    /**
     * 查询档案图像存储索引信息列表
     * 
     * @param archivesImageInfo 档案图像存储索引信息
     * @return 档案图像存储索引信息集合
     */
    public List<ArchivesImageInfo> selectArchivesImageInfoList(ArchivesImageInfo archivesImageInfo);

    /**
     * 查询档案图像存储索引信息列表
     *
     * @param archivesImageInfo 档案图像存储索引信息
     * @return 档案图像存储索引信息集合
     */
    public List<ArchivesImageInfo> selectArchivesImageInfoListByDict(ArchivesImageInfo archivesImageInfo);

    /**
     * 新增档案图像存储索引信息
     * 
     * @param archivesImageInfo 档案图像存储索引信息
     * @return 结果
     */
    public int insertArchivesImageInfo(ArchivesImageInfo archivesImageInfo);

    /**
     * 修改档案图像存储索引信息
     * 
     * @param archivesImageInfo 档案图像存储索引信息
     * @return 结果
     */
    public int updateArchivesImageInfo(ArchivesImageInfo archivesImageInfo);

    /**
     * 删除档案图像存储索引信息
     * 
     * @param id 档案图像存储索引信息主键
     * @return 结果
     */
    public int deleteArchivesImageInfoById(Long id);

    /**
     * 批量删除档案图像存储索引信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArchivesImageInfoByIds(String[] ids);
}
