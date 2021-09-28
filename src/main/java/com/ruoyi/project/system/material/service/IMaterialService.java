package com.ruoyi.project.system.material.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.material.domain.Material;
import com.ruoyi.framework.web.domain.Ztree;

/**
 * 档案材料分类Service接口
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public interface IMaterialService 
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
     * 批量删除档案材料分类
     * 
     * @param materialIds 需要删除的档案材料分类主键集合
     * @return 结果
     */
    public int deleteMaterialByMaterialIds(String materialIds);

    /**
     * 删除档案材料分类信息
     * 
     * @param materialId 档案材料分类主键
     * @return 结果
     */
    public int deleteMaterialByMaterialId(Long materialId);

    /**
     * 查询档案材料分类树列表
     * 
     * @return 所有档案材料分类信息
     */
    public List<Ztree> selectMaterialTree(Material material);

    /**
     * 查询档案材料分类树列表
     *
     * @return 所有档案材料分类信息
     */
    public Map<String,Object> selectMaterialTreeImg(Long code, String id);
}
