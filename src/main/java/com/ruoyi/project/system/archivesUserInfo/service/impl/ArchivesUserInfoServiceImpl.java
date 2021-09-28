package com.ruoyi.project.system.archivesUserInfo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.ArchivesImageInfo.domain.ArchivesImageInfo;
import com.ruoyi.project.system.ArchivesImageInfo.mapper.ArchivesImageInfoMapper;
import com.ruoyi.project.system.ArchivesImageInfo.service.impl.ArchivesImageInfoServiceImpl;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoPenalty;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoRelative;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfoResume;
import com.ruoyi.project.system.dict.domain.DictData;
import com.ruoyi.project.system.dict.service.DictDataServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.archivesUserInfo.mapper.ArchivesUserInfoMapper;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfo;
import com.ruoyi.project.system.archivesUserInfo.service.IArchivesUserInfoService;
import com.ruoyi.common.utils.text.Convert;
import org.springframework.util.ObjectUtils;
import sun.misc.BASE64Encoder;

/**
 * 人员基本信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-18
 */
@Service
public class ArchivesUserInfoServiceImpl implements IArchivesUserInfoService 
{
    @Autowired
    private ArchivesUserInfoMapper archivesUserInfoMapper;

    @Autowired
    private ArchivesImageInfoMapper archivesImageInfoMapper;

    @Autowired
    private ArchivesUserInfoRelativeServiceImpl archivesUserInfoRelativeServiceImpl;

    @Autowired
    private DictDataServiceImpl dictDataServiceImpl;

    @Autowired
    private ArchivesUserInfoResumeServiceImpl archivesUserInfoResumeServiceImpl;

    @Autowired
    private ArchivesImageInfoServiceImpl archivesImageInfoServiceImpl;

    @Autowired
    private ArchivesUserInfoPenaltyServiceImpl archivesUserInfoPenaltyServiceImpl;

    /**
     * 查询人员基本信息管理打印向
     *
     * @param id 人员基本信息管理主键
     * @return 人员基本信息管理
     */
    @Override
    public ArchivesUserInfo selectArchivesUserInfoByIdForPrime(Long id)
    {
        ArchivesUserInfo archivesUserInfo = archivesUserInfoMapper.selectArchivesUserInfoById(id);
        DictData queryDictData = new DictData();
        queryDictData.setStatus("0");
        List<DictData> dictDataList = dictDataServiceImpl.selectDictDataList(queryDictData);
        ArchivesUserInfoRelative query = new ArchivesUserInfoRelative();
        query.setStatus("0");
        query.setUserInfoId(id);
        ArchivesUserInfoResume queryResume = new ArchivesUserInfoResume();
        queryResume.setStatus("0");
        queryResume.setUserInfoId(id);
        List<ArchivesUserInfoRelative> archivesUserInfoRelativeList = archivesUserInfoRelativeServiceImpl
                .selectArchivesUserInfoRelativeList(query);
        for(DictData d: dictDataList.stream().filter(d -> d.getDictType().equals("political_outlook")).collect(Collectors.toList())) {
            archivesUserInfoRelativeList.forEach(a -> {
                if (a.getRelativePolitical().equals(d.getDictValue())) {
                    a.setRelativePolitical(d.getDictLabel());
                }
            });
        }
        archivesUserInfo.setSex(dictDataList.stream().filter(d -> d.getDictType().equals("sys_user_sex")
                && d.getDictValue().equals(archivesUserInfo.getSex())).findFirst().get().getDictLabel());
        archivesUserInfo.setNation(dictDataList.stream().filter(d -> d.getDictType().equals("sys_nation")
                && d.getDictValue().equals(archivesUserInfo.getNation())).findFirst().get().getDictLabel());
        try {
            archivesUserInfo.setImgUrl(encodeBase64File("C:" + archivesUserInfo.getCause()));
        } catch(Exception e) {
            //
        }
        List<ArchivesUserInfoResume> archivesUserInfoResumeList = archivesUserInfoResumeServiceImpl
                .selectArchivesUserInfoResumeList(queryResume);
        archivesUserInfo.setRelativeList(archivesUserInfoRelativeList);
        archivesUserInfo.setResumeList(archivesUserInfoResumeList);
        deleteNullData(archivesUserInfo);
        return archivesUserInfo;
    }

    /**
     * 查询人员基本信息子表信息
     *
     * @param id 人员基本信息管理主键
     * @return 人员基本信息管理
     */
    @Override
    public ArchivesUserInfo getSubListByUserInfoId(Long id){
        ArchivesUserInfo archivesUserInfo = new ArchivesUserInfo();
        ArchivesUserInfoRelative query = new ArchivesUserInfoRelative();
        query.setStatus("0");
        query.setUserInfoId(id);
        ArchivesUserInfoResume queryResume = new ArchivesUserInfoResume();
        queryResume.setStatus("0");
        queryResume.setUserInfoId(id);
        ArchivesUserInfoPenalty queryPenalty = new ArchivesUserInfoPenalty();
        queryPenalty.setStatus("0");
        queryPenalty.setUserInfoId(id);
        List<ArchivesUserInfoRelative> archivesUserInfoRelativeList = archivesUserInfoRelativeServiceImpl
                .selectArchivesUserInfoRelativeList(query);
        List<ArchivesUserInfoResume> archivesUserInfoResumeList = archivesUserInfoResumeServiceImpl
                .selectArchivesUserInfoResumeList(queryResume);
        List<ArchivesUserInfoPenalty> archivesUserInfoPenaltyList = archivesUserInfoPenaltyServiceImpl
                .selectArchivesUserInfoPenaltyList(queryPenalty);
        archivesUserInfo.setRelativeList(archivesUserInfoRelativeList);
        archivesUserInfo.setResumeList(archivesUserInfoResumeList);
        archivesUserInfo.setPenaltyList(archivesUserInfoPenaltyList);
        return archivesUserInfo;
    }

    /**
     * 查询人员基本信息管理
     * 
     * @param id 人员基本信息管理主键
     * @return 人员基本信息管理
     */
    @Override
    public ArchivesUserInfo selectArchivesUserInfoById(Long id)
    {
        ArchivesUserInfo archivesUserInfo = archivesUserInfoMapper.selectArchivesUserInfoById(id);
        DictData queryDictData = new DictData();
        queryDictData.setDictType("political_outlook");
        List<DictData> dictDataList = dictDataServiceImpl.selectDictDataList(queryDictData);
        ArchivesUserInfoRelative query = new ArchivesUserInfoRelative();
        query.setStatus("0");
        query.setUserInfoId(id);
        ArchivesUserInfoResume queryResume = new ArchivesUserInfoResume();
        queryResume.setStatus("0");
        queryResume.setUserInfoId(id);
        ArchivesUserInfoPenalty queryPenalty = new ArchivesUserInfoPenalty();
        queryPenalty.setStatus("0");
        queryPenalty.setUserInfoId(id);
        List<ArchivesUserInfoRelative> archivesUserInfoRelativeList = archivesUserInfoRelativeServiceImpl
                .selectArchivesUserInfoRelativeList(query);
        archivesUserInfo.setRelativeList(archivesUserInfoRelativeList);
        List<ArchivesUserInfoResume> archivesUserInfoResumeList = archivesUserInfoResumeServiceImpl
                .selectArchivesUserInfoResumeList(queryResume);
        List<ArchivesUserInfoPenalty> archivesUserInfoPenaltyList = archivesUserInfoPenaltyServiceImpl
                .selectArchivesUserInfoPenaltyList(queryPenalty);
        StringBuilder builder = new StringBuilder();
        StringBuilder resumeBuilder = new StringBuilder();
        StringBuilder penaltyBuilder = new StringBuilder();
        String enter = "\n";
        archivesUserInfoResumeList.forEach(a -> {
            resumeBuilder.append(a.getStartTime()).append("至").append(a.getEndTime())
                    .append("  ").append(a.getRemuse()).append(enter);
        });
        archivesUserInfoRelativeList.forEach(a -> {
            builder.append("称谓：").append(a.getRelativeCall()).append("，姓名：")
                    .append(a.getRelativeName()).append("，出生日期：")
                    .append(a.getRelativeBirth()).append("，政治面貌：")
                    .append(dictDataList.stream().filter(d -> a.getRelativePolitical()
                            .equals(d.getDictValue())).findFirst().get().getDictLabel()).append("，工作单位及职务：")
                    .append(a.getRelativeWork()).append(enter);
        });
        archivesUserInfoPenaltyList.forEach(a -> {
            penaltyBuilder.append(a.getStartTime()).append("  ").append(a.getPenalty()).append(enter);
        });
        archivesUserInfo.setResume(resumeBuilder.toString());
        archivesUserInfo.setRelatives(builder.toString());
        archivesUserInfo.setBonusPenalty(penaltyBuilder.toString());
        return archivesUserInfo;
    }

    /**
     * 查询人员基本信息管理列表
     * 
     * @param archivesUserInfo 人员基本信息管理
     * @return 人员基本信息管理
     */
    @Override
    public List<ArchivesUserInfo> selectArchivesUserInfoList(ArchivesUserInfo archivesUserInfo)
    {
        return archivesUserInfoMapper.selectArchivesUserInfoList(archivesUserInfo).stream().peek(a -> {
            if (StringUtils.isEmpty(a.getCause())) {
                a.setCause("/img/profile.jpg");
            }
        }).collect(Collectors.toList());
    }

    /**
     * 新增人员基本信息管理
     * 
     * @param archivesUserInfo 人员基本信息管理
     * @return 结果
     */
    @Override
    public int insertArchivesUserInfo(ArchivesUserInfo archivesUserInfo)
    {
        archivesUserInfo.setUuid(UUID.randomUUID().toString());
        archivesUserInfo.setStatus("0");
        archivesUserInfo.setCreateTime(DateUtils.getNowDate());
        archivesUserInfo.setCreateBy(ShiroUtils.getLoginName());
        return archivesUserInfoMapper.insertArchivesUserInfo(archivesUserInfo);
    }

    /**
     * 修改人员基本信息管理
     * 
     * @param archivesUserInfo 人员基本信息管理
     * @return 结果
     */
    @Override
    public int updateArchivesUserInfo(ArchivesUserInfo archivesUserInfo)
    {
        ArchivesUserInfoResume queryResume = new ArchivesUserInfoResume();
        queryResume.setUserInfoId(archivesUserInfo.getId());
        archivesUserInfoResumeServiceImpl.selectArchivesUserInfoResumeList(queryResume)
                .forEach(a -> archivesUserInfoResumeServiceImpl.deleteArchivesUserInfoResumeByResumeId(a.getResumeId()));

        ArchivesUserInfoRelative query = new ArchivesUserInfoRelative();
        query.setUserInfoId(archivesUserInfo.getId());
        archivesUserInfoRelativeServiceImpl.selectArchivesUserInfoRelativeList(query)
                .forEach(a -> archivesUserInfoRelativeServiceImpl.deleteArchivesUserInfoRelativeByRelativeId(a.getRelativeId()));

        ArchivesUserInfoPenalty queryPenalty = new ArchivesUserInfoPenalty();
        queryPenalty.setUserInfoId(archivesUserInfo.getId());
        archivesUserInfoPenaltyServiceImpl.selectArchivesUserInfoPenaltyList(queryPenalty)
                .forEach(a -> archivesUserInfoPenaltyServiceImpl.deleteArchivesUserInfoPenaltyByPenaltyId(a.getPenaltyId()));

        if (CollectionUtils.isNotEmpty(archivesUserInfo.getRelativeList())) {
            archivesUserInfo.getRelativeList().forEach(a -> {
                a.setUserInfoId(archivesUserInfo.getId());
                a.setUuid(archivesUserInfo.getUuid());
                a.setStatus("0");
                a.setCreateTime(DateUtils.getNowDate());
                a.setCreateBy(ShiroUtils.getLoginName());
                archivesUserInfoRelativeServiceImpl.insertArchivesUserInfoRelative(a);
            });
        }

        if (CollectionUtils.isNotEmpty(archivesUserInfo.getResumeList())) {
            archivesUserInfo.getResumeList().forEach(a -> {
                a.setUserInfoId(archivesUserInfo.getId());
                a.setUuid(archivesUserInfo.getUuid());
                a.setStatus("0");
                a.setCreateTime(DateUtils.getNowDate());
                a.setCreateBy(ShiroUtils.getLoginName());
                archivesUserInfoResumeServiceImpl.insertArchivesUserInfoResume(a);
            });
        }

        if (CollectionUtils.isNotEmpty(archivesUserInfo.getPenaltyList())) {
            archivesUserInfo.getPenaltyList().forEach(a -> {
                a.setUserInfoId(archivesUserInfo.getId());
                a.setUuid(archivesUserInfo.getUuid());
                a.setStatus("0");
                a.setCreateTime(DateUtils.getNowDate());
                a.setCreateBy(ShiroUtils.getLoginName());
                archivesUserInfoPenaltyServiceImpl.insertArchivesUserInfoPenalty(a);
            });
        }
        archivesUserInfo.setUpdateTime(DateUtils.getNowDate());
        archivesUserInfo.setUpdateBy(ShiroUtils.getLoginName());
        return archivesUserInfoMapper.updateArchivesUserInfo(archivesUserInfo);
    }

    /**
     * 批量删除人员基本信息管理
     * 
     * @param ids 需要删除的人员基本信息管理主键
     * @return 结果
     */
    @Override
    public int deleteArchivesUserInfoByIds(String ids)
    {
        String[] idList = Convert.toStrArray(ids);
        for (String id: idList) {
            deleteSubtabulationByUserInfoId(Long.valueOf(id));
        }
        return archivesUserInfoMapper.deleteArchivesUserInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员基本信息管理信息
     * 
     * @param id 人员基本信息管理主键
     * @return 结果
     */
    @Override
    public int deleteArchivesUserInfoById(Long id)
    {
        deleteSubtabulationByUserInfoId(id);
        return archivesUserInfoMapper.deleteArchivesUserInfoById(id);
    }

    private void deleteSubtabulationByUserInfoId(Long id) {
        ArchivesUserInfoResume query = new ArchivesUserInfoResume();
        query.setUserInfoId(id);
        archivesUserInfoResumeServiceImpl.selectArchivesUserInfoResumeList(query).forEach(a ->
                archivesUserInfoResumeServiceImpl.deleteArchivesUserInfoResumeByResumeId(a.getResumeId()));

        ArchivesUserInfoRelative queryRelative = new ArchivesUserInfoRelative();
        queryRelative.setUserInfoId(id);
        archivesUserInfoRelativeServiceImpl.selectArchivesUserInfoRelativeList(queryRelative).forEach(a ->
                archivesUserInfoRelativeServiceImpl.deleteArchivesUserInfoRelativeByRelativeId(a.getRelativeId()));

        ArchivesUserInfoPenalty queryPenalty = new ArchivesUserInfoPenalty();
        queryPenalty.setUserInfoId(id);
        archivesUserInfoPenaltyServiceImpl.selectArchivesUserInfoPenaltyList(queryPenalty).forEach(a ->
                archivesUserInfoPenaltyServiceImpl.deleteArchivesUserInfoPenaltyByPenaltyId(a.getPenaltyId()));

        ArchivesImageInfo queryImg = new ArchivesImageInfo();
        queryImg.setUserInfoId(id);
        List<ArchivesImageInfo> archivesImageInfoList = archivesImageInfoServiceImpl.selectArchivesImageInfoList(queryImg);
        archivesImageInfoList.forEach(a -> {
            if (StringUtils.isNotEmpty(a.getOriginalFilename())) {
                File originalFile = new File("C:" + a.getOriginalFilename());
                originalFile.delete();
            }
            if (StringUtils.isNotEmpty(a.getOptimizeFilename())) {
                File optimizeFile = new File("C:" + a.getOptimizeFilename());
                optimizeFile.delete();
            }
            archivesImageInfoMapper.deleteArchivesImageInfoById(a.getId());
        });
    }

    private static String encodeBase64File(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Str = encoder.encode(data);
        return base64Str;
    }

    public ArchivesUserInfo deleteNullData(ArchivesUserInfo cmsContentDTO){
        //反射获取类
        Class c = ArchivesUserInfo.class;
        //获取DTO对象的所有定义的属性信息Filed
        Field[] fileds = c.getDeclaredFields();
            for(int j=0;j<fileds.length;j++){
                Field f = fileds[j];
                try {
                    //对象中的属性是private的需要设置accessible才可用
                    f.setAccessible(true);
                    //遍历每个属性值
                    if(ObjectUtils.isEmpty(f.get(cmsContentDTO))){
                        //拼接set方法
                        String methodName = "set" + f.getName().substring(0,1).toUpperCase()+f.getName().substring(1,f.getName().length());
                        //获取方法
                        Method method = c.getDeclaredMethod(methodName, f.getType().getCanonicalName().getClass());
                        //直接给属性赋值null会报空指针
                        String nullName = "";
                        //调用方法
                        method.invoke(cmsContentDTO,nullName);
                    }
                } catch (IllegalAccessException e) {
                    //e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    //e.printStackTrace();
                } catch (InvocationTargetException e) {
                    //e.printStackTrace();
                }
            }
        return cmsContentDTO;
    }
}
