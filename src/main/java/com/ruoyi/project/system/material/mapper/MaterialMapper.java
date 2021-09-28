package com.ruoyi.project.system.material.mapper;

import java.util.List;
import com.ruoyi.project.system.material.domain.Material;

/**
 * 档案材料分类Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public interface MaterialMapper 
{
    /**
     * 查询档案材料分类
     * 
     * @param materialId 档案材料分类主键
     * @return 档案材料分类
     */
    public Material selectMaterialByMaterialId(Long materialId);

    /**
     * 查询档案材料分类列表
     * 
     * @param material 档案材料分类
     * @return 档案材料分类集合
     */
    public List<Material> selectMaterialList(Material material);

    /**
     * 查询档案材料分类列表
     *
     * @return 档案材料分类集合
     */
    public List<Material> selectMaterialListImg(Material material);

    /**
     * 新增档案材料分类
     * 
     * @param material 档案材料分类
     * @return 结果
     */
    public int insertMaterial(Material material);

    /**
     * 修改档案材料分类
     * 
     * @param material 档案材料分类
     * @return 结果
     */
    public int updateMaterial(Material material);

    /**
     * 删除档案材料分类
     * 
     * @param materialId 档案材料分类主键
     * @return 结果
     */
    public int deleteMaterialByMaterialId(Long materialId);

    /**
     * 批量删除档案材料分类
     * 
     * @param materialIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMaterialByMaterialIds(String[] materialIds);
}
