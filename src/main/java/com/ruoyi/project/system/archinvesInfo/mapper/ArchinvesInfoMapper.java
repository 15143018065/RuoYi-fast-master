package com.ruoyi.project.system.archinvesInfo.mapper;

import java.util.List;
import com.ruoyi.project.system.archinvesInfo.domain.ArchinvesInfo;

/**
 * 档案目录信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-08-19
 */
public interface ArchinvesInfoMapper 
{
    /**
     * 查询档案目录信息
     * 
     * @param id 档案目录信息主键
     * @return 档案目录信息
     */
    public ArchinvesInfo selectArchinvesInfoById(Long id);

    /**
     * 查询档案目录信息列表
     * 
     * @param archinvesInfo 档案目录信息
     * @return 档案目录信息集合
     */
    public List<ArchinvesInfo> selectArchinvesInfoList(ArchinvesInfo archinvesInfo);

    /**
     * 新增档案目录信息
     * 
     * @param archinvesInfo 档案目录信息
     * @return 结果
     */
    public int insertArchinvesInfo(ArchinvesInfo archinvesInfo);

    /**
     * 修改档案目录信息
     * 
     * @param archinvesInfo 档案目录信息
     * @return 结果
     */
    public int updateArchinvesInfo(ArchinvesInfo archinvesInfo);

    /**
     * 删除档案目录信息
     * 
     * @param id 档案目录信息主键
     * @return 结果
     */
    public int deleteArchinvesInfoById(Long id);

    /**
     * 批量删除档案目录信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArchinvesInfoByIds(String[] ids);
}
