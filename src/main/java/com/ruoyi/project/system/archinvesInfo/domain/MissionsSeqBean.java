package com.ruoyi.project.system.archinvesInfo.domain;
import java.util.List;
import java.util.ArrayList;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
public class MissionsSeqBean extends BaseEntity{
    private static final long serialVersionUID = 1L;
    private String fl;
    private String sn;
    private String data;
    private String jsons;
    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



    public String getJsons() {
        return jsons;
    }

    public void setJsons(String jsons) {
        this.jsons = jsons;
    }
    @Override
    public String toString() {
            return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("fl", getFl())
                .append("sn", getSn())
                .append("data", getData())
                .append("jsons", getJsons())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
