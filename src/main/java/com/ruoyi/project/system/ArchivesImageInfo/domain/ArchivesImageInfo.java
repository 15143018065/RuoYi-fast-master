package com.ruoyi.project.system.ArchivesImageInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 档案图像存储索引信息对象 archives_image_info
 * 
 * @author ruoyi
 * @date 2021-08-24
 */
public class ArchivesImageInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 目录标识 */
    private Long id;

    /** 人员主键 */
    @Excel(name = "人员主键")
    private Long userInfoId;

    /** 字典编码 */
    @Excel(name = "字典编码")
    private Long dictCode;

    /** 原始文件名 */
    @Excel(name = "原始文件名")
    private String originalFilename;

    /** 优化文件名 */
    @Excel(name = "优化文件名")
    private String optimizeFilename;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 注销原因 */
    @Excel(name = "注销原因")
    private String cause;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOriginalFilename(String originalFilename)
    {
        this.originalFilename = originalFilename;
    }

    public String getOriginalFilename()
    {
        return originalFilename;
    }
    public void setOptimizeFilename(String optimizeFilename)
    {
        this.optimizeFilename = optimizeFilename;
    }

    public String getOptimizeFilename()
    {
        return optimizeFilename;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCause()
    {
        return cause;
    }

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Long getDictCode() {
        return dictCode;
    }

    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userInfoId", getUserInfoId())
            .append("dictCode", getDictCode())
            .append("originalFilename", getOriginalFilename())
            .append("optimizeFilename", getOptimizeFilename())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("cause", getCause())
            .toString();
    }
}
