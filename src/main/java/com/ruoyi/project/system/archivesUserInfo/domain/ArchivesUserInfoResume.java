package com.ruoyi.project.system.archivesUserInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 档案人员简历对象 archives_user_info_resume
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
public class ArchivesUserInfoResume extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 简历主键 */
    private Long resumeId;

    /** 人员主键 */
    @Excel(name = "人员主键")
    private Long userInfoId;

    /** 人员唯一标识 */
    @Excel(name = "人员唯一标识")
    private String uuid;

    /** 简历内容 */
    @Excel(name = "简历内容")
    private String remuse;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    public void setResumeId(Long resumeId)
    {
        this.resumeId = resumeId;
    }

    public Long getResumeId()
    {
        return resumeId;
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
    public void setRemuse(String remuse)
    {
        this.remuse = remuse;
    }

    public String getRemuse()
    {
        return remuse;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resumeId", getResumeId())
            .append("userInfoId", getUserInfoId())
            .append("uuid", getUuid())
            .append("remuse", getRemuse())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
