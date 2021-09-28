package com.ruoyi.project.system.material.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

/**
 * 档案材料分类对象 sys_material
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public class Material extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 档案材料分类id */
    private Long materialId;

    /** 档案材料分类名称 */
    @Excel(name = "档案材料分类名称")
    private String materialName;

    /** 档案材料分类状态（0正常 1停用） */
    @Excel(name = "档案材料分类状态", readConverterExp = "0=正常,1=停用")
    private String status;

    private String classNum;

    private String userInfoId;

    private String copies;

    /** 档案材料分类类型（0动态 1基础） */
    private String basicFlg;

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getCopies() {
        return copies;
    }

    public void setCopies(String copies) {
        this.copies = copies;
    }

    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setBasicFlg(String basicFlg)
    {
        this.basicFlg = basicFlg;
    }

    public String getBasicFlg()
    {
        return basicFlg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("parentId", getParentId())
            .append("materialName", getMaterialName())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("basicFlg", getBasicFlg())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
