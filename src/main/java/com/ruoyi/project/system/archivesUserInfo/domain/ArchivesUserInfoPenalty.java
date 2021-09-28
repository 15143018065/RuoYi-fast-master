package com.ruoyi.project.system.archivesUserInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 档案人员奖惩情况对象 archives_user_info_penalty
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public class ArchivesUserInfoPenalty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 奖惩情况主键 */
    private Long penaltyId;

    /** 人员主键 */
    @Excel(name = "人员主键")
    private Long userInfoId;

    /** 人员唯一标识 */
    @Excel(name = "人员唯一标识")
    private String uuid;

    /** 奖惩内容 */
    @Excel(name = "奖惩内容")
    private String penalty;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setPenaltyId(Long penaltyId)
    {
        this.penaltyId = penaltyId;
    }

    public Long getPenaltyId()
    {
        return penaltyId;
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
    public void setPenalty(String penalty)
    {
        this.penalty = penalty;
    }

    public String getPenalty()
    {
        return penalty;
    }
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getStartTime()
    {
        return startTime;
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
            .append("penaltyId", getPenaltyId())
            .append("userInfoId", getUserInfoId())
            .append("uuid", getUuid())
            .append("penalty", getPenalty())
            .append("startTime", getStartTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
