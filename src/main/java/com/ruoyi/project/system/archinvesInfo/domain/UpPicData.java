package com.ruoyi.project.system.archinvesInfo.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UpPicData extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private String sn;
    private String yhid;
    private String ryid;
    private String lbid;
    private String tpxh;
    private String tpbz;
    private String yhzp;
    private String yszp;


    private String jsondata;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid;
    }

    public String getRyid() {
        return ryid;
    }

    public void setRyid(String ryid) {
        this.ryid = ryid;
    }

    public String getLbid() {
        return lbid;
    }

    public void setLbid(String lbid) {
        this.lbid = lbid;
    }

    public String getTpxh() {
        return tpxh;
    }

    public void setTpxh(String tpxh) {
        this.tpxh = tpxh;
    }

    public String getTpbz() {
        return tpbz;
    }

    public void setTpbz(String tpbz) {
        this.tpbz = tpbz;
    }

    public String getYhzp() {
        return yhzp;
    }

    public void setYhzp(String yhzp) {
        this.yhzp = yhzp;
    }

    public String getYszp() {
        return yszp;
    }

    public void setYszp(String yszp) {
        this.yszp = yszp;
    }

    public String getJsondata() {
        return jsondata;
    }

    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }

    @Override
    public String toString() {
            return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("sn", getSn())
                    .append("data", getYszp())
                    .append("data", getYhzp())
                .append("data", getJsondata())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
