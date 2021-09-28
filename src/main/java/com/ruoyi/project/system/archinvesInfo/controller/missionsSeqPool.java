package com.ruoyi.project.system.archinvesInfo.controller;


import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.archinvesInfo.domain.MissionsSeqBean;
//import org.json.JSONStringer;

import java.util.Hashtable;

/**
 * Created by Administrator on 2017/11/30.
 */
public class missionsSeqPool {
    private static Hashtable missionsSeqPools=new Hashtable(2000, 0.75F);
    public static String  getMissions(String sn)
    {
        MissionsSeqBean missionsseqBean = (MissionsSeqBean) missionsSeqPools.get(sn);
        if(missionsseqBean == null)
        {
            return "";
        }
        else
        {
            return  missionsseqBean.getJsons();
        }
    }

    public synchronized static boolean putMissions(String fl,String sn,String data)
    {
        JSONObject json = new JSONObject();
        MissionsSeqBean missionsseqBean = new MissionsSeqBean();
        missionsseqBean.setFl(fl);
        missionsseqBean.setSn(sn);
        missionsseqBean.setData(data);
        String jsons="";
        try {
            json.put("sn", sn);
            json.put("type", fl);
            json.put("picdata", data);
            jsons=json.toString();
        }
        catch (Exception e)
        {
            //
        }
        missionsseqBean.setJsons(jsons);
        missionsSeqPools.put(sn,missionsseqBean);
        return true;
    }

    public synchronized static boolean ClearMissions(String sn)
    {
        missionsSeqPools.remove(sn) ;
        return true;
    }
}
