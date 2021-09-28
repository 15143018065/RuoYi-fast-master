package com.ruoyi.project.system.archinvesInfo.domain;

import com.ruoyi.project.system.ArchivesImageInfo.domain.ArchivesImageInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 档案目录信息对象 archinves_info
 * 
 * @author ruoyi
 * @date 2021-08-19
 */
public class ArchinvesInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 目录主键 */
    private Long id;

    /** 人员标识 */
    @Excel(name = "人员标识")
    private Long userInfoId;

    /** 类号 */
    @Excel(name = "类号")
    private String typeNumber;

    /** 序号 */
    @Excel(name = "序号")
    private Integer orderNumber;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String materialName;

    /** 材料形成时间 */
    @Excel(name = "材料形成时间")
    private String materialCreateTime;

    /** 页数 */
    @Excel(name = "页数")
    private Integer pageNumber;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 注销原因 */
    @Excel(name = "注销原因")
    private String cause;

    private List<ArchivesImageInfo> imageInfos;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserInfoId(Long userInfoId)
    {
        this.userInfoId = userInfoId;
    }

    public Long getUserInfoId()
    {
        return userInfoId;
    }
    public void setTypeNumber(String typeNumber)
    {
        this.typeNumber = typeNumber;
    }

    public String getTypeNumber()
    {
        return typeNumber;
    }
    public void setOrderNumber(Integer orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumber()
    {
        return orderNumber;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setMaterialCreateTime(String materialCreateTime)
    {
        this.materialCreateTime = materialCreateTime;
    }

    public String getMaterialCreateTime()
    {
        return materialCreateTime;
    }
    public void setPageNumber(Integer pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    public Integer getPageNumber()
    {
        return pageNumber;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setCause(String cause)
    {
        this.cause = cause;
    }

    public String getCause()
    {
        return cause;
    }

    public List<ArchivesImageInfo> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(List<ArchivesImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userInfoId", getUserInfoId())
            .append("typeNumber", getTypeNumber())
            .append("orderNumber", getOrderNumber())
            .append("materialName", getMaterialName())
            .append("materialCreateTime", getMaterialCreateTime())
            .append("pageNumber", getPageNumber())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("cause", getCause())
            .toString();
    }
}
