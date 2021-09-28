package com.ruoyi.project.system.material.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import com.sun.xml.internal.txw2.output.XmlSerializer;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.material.mapper.MaterialMapper;
import com.ruoyi.project.system.material.domain.Material;
import com.ruoyi.project.system.material.service.IMaterialService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 档案材料分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
@Service
public class MaterialServiceImpl implements IMaterialService 
{
    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 查询档案材料分类
     * 
     * @param materialId 档案材料分类主键
     * @return 档案材料分类
     */
    @Override
    public Material selectMaterialByMaterialId(Long materialId)
    {
        return materialMapper.selectMaterialByMaterialId(materialId);
    }

    /**
     * 查询档案材料分类列表
     * 
     * @param material 档案材料分类
     * @return 档案材料分类
     */
    @Override
    public List<Material> selectMaterialList(Material material)
    {
        return materialMapper.selectMaterialList(material);
    }

    /**
     * 新增档案材料分类
     * 
     * @param material 档案材料分类
     * @return 结果
     */
    @Override
    public int insertMaterial(Material material)
    {
        if (ObjectUtils.isEmpty(material.getCreateTime())) {
            material.setCreateTime(DateUtils.getNowDate());
        }
        return materialMapper.insertMaterial(material);
    }

    /**
     * 修改档案材料分类
     * 
     * @param material 档案材料分类
     * @return 结果
     */
    @Override
    public int updateMaterial(Material material)
    {
        material.setUpdateTime(DateUtils.getNowDate());
        return materialMapper.updateMaterial(material);
    }

    /**
     * 批量删除档案材料分类
     * 
     * @param materialIds 需要删除的档案材料分类主键
     * @return 结果
     */
    @Override
    public int deleteMaterialByMaterialIds(String materialIds)
    {
        return materialMapper.deleteMaterialByMaterialIds(Convert.toStrArray(materialIds));
    }

    /**
     * 删除档案材料分类信息
     * 
     * @param materialId 档案材料分类主键
     * @return 结果
     */
    @Override
    public int deleteMaterialByMaterialId(Long materialId)
    {
        return materialMapper.deleteMaterialByMaterialId(materialId);
    }

    /**
     * 查询档案材料分类树列表
     * 
     * @return 所有档案材料分类信息
     */
    @Override
    public List<Ztree> selectMaterialTree(Material material)
    {
        List<Material> materialList = materialMapper.selectMaterialList(material);
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Material m : materialList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(m.getMaterialId());
            ztree.setpId(m.getParentId());
            ztree.setName(m.getMaterialName());
            ztree.setTitle(m.getMaterialName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    /**
     * 查询档案材料分类树列表
     *
     * @return 所有档案材料分类信息
     */
    @Override
    public Map<String,Object> selectMaterialTreeImg(Long code, String id)
    {
        Material query = new Material();
        query.setMaterialId(code);
        query.setMaterialName(id);
        List<Material> materialList = materialMapper.selectMaterialListImg(query);
        for (Material m: materialList) {
            setMaterialName(m, materialList);
        }
        //materialList.forEach(m -> m.setMaterialName(m.getMaterialName() + "(" + m.getCreateBy() + "页)"));

        System.out.println(materialList);
        StringBuilder node = new StringBuilder();
        String str = "\n";
        node.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(str).append("<rows>").append(str);

        for (Material m: materialList.stream().filter(v -> v.getParentId().equals(0L)).collect(Collectors.toList())) {
            setXml(node, m);
            StringBuilder child = new StringBuilder();
            recursionChild(child, m.getMaterialId(), materialList);
            node.append(child).append(str);
            node.append("</row>").append(str);
        }

        node.append("</rows>");
        System.out.println(node.toString());
        Map<String,Object> result = new HashMap<>();
        result.put("xml", node.toString());



        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Material material : materialList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(material.getMaterialId());
            ztree.setpId(material.getParentId());
            ztree.setName(material.getMaterialName());
            ztree.setTitle(material.getMaterialName());
            ztrees.add(ztree);
        }
        result.put("dataClass", ztrees);
//        return ztrees;
        return result;
    }

    private void setMaterialName(Material m, List<Material> materialList) {
        if (CollectionUtils.isNotEmpty(materialList)) {
            if (ObjectUtils.isNotEmpty(m)) {
                // 当前父类下所有子类
                List<Material> newMaterialList = new ArrayList<>();
                getAllChild(m.getMaterialId(), materialList, newMaterialList);
                m.setCreateBy(String.valueOf(Integer.parseInt(m.getCreateBy()) + newMaterialList.stream()
                        .map(n -> Integer.parseInt(n.getCreateBy())).collect(Collectors.toList()).stream()
                        .reduce(Integer::sum).orElse(0)));
            }
        }
    }

    private void getAllChild(Long parentId, List<Material> materialList, List<Material> newMaterialList) {
        List<Material> materials = materialList.stream().filter(v -> v.getParentId()
                .equals(parentId)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(materials)) {
            newMaterialList.addAll(materials);
            materials.forEach(a -> {
                getAllChild(a.getMaterialId(), materialList, newMaterialList);
            });
        }
    }

    private void recursionChild(StringBuilder child, Long parentId, List<Material> materialList){
        List<Material> childList = materialList.stream().filter(m -> m.getParentId().equals(parentId))
                .collect(Collectors.toList());
        String str = "\n";
        if (CollectionUtils.isNotEmpty(childList)) {
            for (Material m: childList) {
                setXml(child, m);
                recursionChild(child, m.getMaterialId(), materialList);
                child.append("</row>").append(str);
            }
        }
    }

    private void setXml(StringBuilder sb, Material m) {
        String str = "\n";
        Calendar c = Calendar.getInstance();
        c.setTime(m.getCreateTime());
        sb.append("<row id=\"" + m.getMaterialId() + "\">").append(str);
        sb.append("<cell image=\"books.gif\">" + m.getMaterialName() + "</cell>").append(str);
        sb.append("<cell>" + m.getCreateBy() + "</cell>").append(str);
        sb.append("<cell>" + c.get(Calendar.YEAR) + "</cell>").append(str);
        sb.append("<cell>" + c.get(Calendar.MONTH) + "</cell>").append(str);
        sb.append("<cell>" + c.get(Calendar.DATE) + "</cell>").append(str);
        sb.append("<cell>" + m.getRemark() + "</cell>").append(str);
    }
}
