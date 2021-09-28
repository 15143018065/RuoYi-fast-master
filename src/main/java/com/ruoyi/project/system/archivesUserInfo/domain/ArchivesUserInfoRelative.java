package com.ruoyi.project.system.archivesUserInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 档案人员家庭成员对象 archives_user_info_relative
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
public class ArchivesUserInfoRelative extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 家庭成员主键 */
    private Long relativeId;

    /** 人员主键 */
    @Excel(name = "人员主键")
    private Long userInfoId;

    /** 人员唯一标识 */
    @Excel(name = "人员唯一标识")
    private String uuid;

    /** 成员称谓 */
    @Excel(name = "成员称谓")
    private String relativeCall;

    /** 成员姓名 */
    @Excel(name = "成员姓名")
    private String relativeName;

    /** 成员出生日期 */
    @Excel(name = "成员出生日期")
    private String relativeBirth;

    /** 成员政治面貌 */
    @Excel(name = "成员政治面貌")
    private String relativePolitical;

    /** 成员工作单位及职务 */
    @Excel(name = "成员工作单位及职务")
    private String relativeWork;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setRelativeId(Long relativeId)
    {
        this.relativeId = relativeId;
    }

    public Long getRelativeId()
    {
        return relativeId;
    }
    public void setUserInfoId(Long userInfoId)
    {
        this.userInfoId = userInfoId;
    }

    public Long getUserInfoId()
    {
        return userInfoId;
    }
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setRelativeCall(String relativeCall)
    {
        this.relativeCall = relativeCall;
    }

    public String getRelativeCall()
    {
        return relativeCall;
    }
    public void setRelativeName(String relativeName)
    {
        this.relativeName = relativeName;
    }

    public String getRelativeName()
    {
        return relativeName;
    }
    public void setRelativeBirth(String relativeBirth)
    {
        this.relativeBirth = relativeBirth;
    }

    public String getRelativeBirth()
    {
        return relativeBirth;
    }
    public void setRelativePolitical(String relativePolitical)
    {
        this.relativePolitical = relativePolitical;
    }

    public String getRelativePolitical()
    {
        return relativePolitical;
    }
    public void setRelativeWork(String relativeWork)
    {
        this.relativeWork = relativeWork;
    }

    public String getRelativeWork()
    {
        return relativeWork;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("relativeId", getRelativeId())
            .append("userInfoId", getUserInfoId())
            .append("uuid", getUuid())
            .append("relativeCall", getRelativeCall())
            .append("relativeName", getRelativeName())
            .append("relativeBirth", getRelativeBirth())
            .append("relativePolitical", getRelativePolitical())
            .append("relativeWork", getRelativeWork())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
