package com.ruoyi.project.system.ArchivesImageInfo.service.impl;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.archinvesInfo.domain.UpPicData;
import com.ruoyi.project.system.archivesUserInfo.domain.ArchivesUserInfo;
import com.ruoyi.project.system.archivesUserInfo.mapper.ArchivesUserInfoMapper;
import com.ruoyi.project.system.archivesUserInfo.service.impl.ArchivesUserInfoServiceImpl;
import com.ruoyi.project.system.dict.service.DictDataServiceImpl;
import com.ruoyi.project.system.material.domain.Material;
import com.ruoyi.project.system.material.service.impl.MaterialServiceImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.ArchivesImageInfo.mapper.ArchivesImageInfoMapper;
import com.ruoyi.project.system.ArchivesImageInfo.domain.ArchivesImageInfo;
import com.ruoyi.project.system.ArchivesImageInfo.service.IArchivesImageInfoService;
import com.ruoyi.common.utils.text.Convert;

import javax.servlet.http.HttpServletRequest;

/**
 * 档案图像存储索引信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-24
 */
@Service
public class ArchivesImageInfoServiceImpl implements IArchivesImageInfoService 
{
    @Autowired
    private ArchivesImageInfoMapper archivesImageInfoMapper;

    @Autowired
    private ArchivesUserInfoServiceImpl archivesUserInfoServiceImpl;

    @Autowired
    private MaterialServiceImpl materialServiceImpl;

    /**
     * 查询档案图像存储索引信息
     * 
     * @param id 档案图像存储索引信息主键
     * @return 档案图像存储索引信息
     */
    @Override
    public ArchivesImageInfo selectArchivesImageInfoById(Long id)
    {
        return archivesImageInfoMapper.selectArchivesImageInfoById(id);
    }

    /**
     * 查询档案图像存储索引信息列表
     * 
     * @param archivesImageInfo 档案图像存储索引信息
     * @return 档案图像存储索引信息
     */
    @Override
    public List<ArchivesImageInfo> selectArchivesImageInfoList(ArchivesImageInfo archivesImageInfo)
    {
        return archivesImageInfoMapper.selectArchivesImageInfoList(archivesImageInfo);
    }

    /**
     * 查询档案图像存储索引信息列表
     *
     * @param archivesImageInfo 档案图像存储索引信息
     * @return 档案图像存储索引信息
     */
    @Override
    public List<ArchivesImageInfo> selectArchivesImageInfoListByDict(ArchivesImageInfo archivesImageInfo)
    {
        return archivesImageInfoMapper.selectArchivesImageInfoListByDict(archivesImageInfo);
    }

    /**
     * 新增档案图像存储索引信息
     *
     * @param baseFile 档案图像存储索引信息
     * @return 结果
     */
    @Override
    public String saveTempFile(String baseFile){
        File file = base64ToFile(baseFile);
        String fileName = file.getName();
        String toUrl = "C:/upload/temp" + File.separator + fileName;
        File dest = new File(toUrl);
        File fileParent = dest.getParentFile();
        if  (!fileParent.exists()) {
            fileParent .mkdirs();
        }
        try {
            copyFileToPerm(file, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/upload/temp" + File.separator + fileName;
    }

    /**
     * 新增档案图像存储索引信息
     *
     * @param ud 档案图像存储索引信息
     * @return 结果
     */
    @Override
    public int insertArchivesImageInfo(UpPicData ud)
    {
        ArchivesImageInfo archivesImageInfo = new ArchivesImageInfo();
        archivesImageInfo.setDictCode(Long.valueOf(ud.getLbid()));
        archivesImageInfo.setUserInfoId(Long.valueOf(ud.getRyid()));
        archivesImageInfo.setSort(Integer.parseInt(ud.getTpxh()));
        archivesImageInfo.setRemark(ud.getTpbz());
        File file = base64ToFile(ud.getYszp());
        File optimizeFile = base64ToFile(ud.getYhzp());
        ArchivesUserInfo archivesUserInfo = archivesUserInfoServiceImpl.selectArchivesUserInfoById(Long.valueOf(ud.getRyid()));
        ArchivesImageInfo query = new ArchivesImageInfo();
        query.setDictCode(Long.valueOf(ud.getLbid()));
        query.setUserInfoId(Long.valueOf(ud.getRyid()));
        List<ArchivesImageInfo> archivesImageInfoList = selectArchivesImageInfoList(query);
        String num = "";
        if (archivesImageInfoList.size() < 9) {
            num  = "00" + String.valueOf(archivesImageInfoList.size() + 1);
        } else if (archivesImageInfoList.size() > 9 && archivesImageInfoList.size() < 99) {
            num  = "0" + String.valueOf(archivesImageInfoList.size() + 1);
        } else {
            num  = String.valueOf(archivesImageInfoList.size() + 1);
        }
//        String folderName = archivesUserInfo.getPersonName() + archivesUserInfo.getIdCard();
        String folderName = archivesUserInfo.getUuid();
        String fileName = materialServiceImpl.selectMaterialByMaterialId(Long.valueOf(ud.getLbid())).getClassNum() + "-" +
                num + ".jpeg";
//        String contentPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
//        String toUrl = request.getSession().getServletContext().getRealPath(url) + File.separator + fileName;
//        String url = "/uploadImg";
//        String toUrl = "target/classes/static" + url + File.separator + fileName;
        String url = folderName + "/ImageData/OriginalImageData";
        String optimizeUrl = folderName + "/ImageData/OptimizeImageData";
        String toUrl = "C:/upload/" + url + File.separator + fileName;
        String toOptimizeUrl = "C:/upload/" + optimizeUrl + File.separator + fileName;
        File dest = new File(toUrl);
        File optimizeDest = new File(toOptimizeUrl);
        File fileParent = dest.getParentFile();
        if  (!fileParent.exists()) {
            fileParent .mkdirs();
        }
        File optimizeFileParent = optimizeDest.getParentFile();
        if  (!optimizeFileParent.exists()) {
            optimizeFileParent .mkdirs();
        }
        try {
            copyFileToPerm(file, dest);
            copyFileToPerm(optimizeFile, optimizeDest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        archivesImageInfo.setOriginalFilename("/upload/" + url + File.separator + fileName);
        archivesImageInfo.setOptimizeFilename("/upload/" + optimizeUrl + File.separator + fileName);
        if (ObjectUtils.isEmpty(archivesImageInfo.getSort())) {
            archivesImageInfo.setSort(archivesImageInfoList.stream()
                    .map(ArchivesImageInfo::getSort).collect(Collectors.toList())
                    .stream().max(Comparator.naturalOrder()).orElse(0) + 1);
        }
        archivesImageInfo.setCreateTime(DateUtils.getNowDate());
        //archivesImageInfo.setCreateBy(ShiroUtils.getLoginName());
        return archivesImageInfoMapper.insertArchivesImageInfo(archivesImageInfo);
    }

    /**
     * 修改档案图像存储索引信息
     * 
     * @param archivesImageInfo 档案图像存储索引信息
     * @return 结果
     */
    @Override
    public int updateArchivesImageInfo(ArchivesImageInfo archivesImageInfo)
    {
        int result = 0;
        archivesImageInfo.setUpdateTime(DateUtils.getNowDate());
        ArchivesImageInfo oldArchivesImageInfo = selectArchivesImageInfoById(archivesImageInfo.getId());
        ArchivesImageInfo query = new ArchivesImageInfo();
        query.setDictCode(archivesImageInfo.getDictCode());
        query.setUserInfoId(archivesImageInfo.getUserInfoId());
        List<ArchivesImageInfo> archivesImageInfoList = selectArchivesImageInfoList(query);
        if (archivesImageInfo.getOriginalFilename().equals(oldArchivesImageInfo.getOriginalFilename())) {
            if (ObjectUtils.isEmpty(archivesImageInfo.getSort())) {
                archivesImageInfo.setSort(archivesImageInfoList.stream()
                        .map(ArchivesImageInfo::getSort).collect(Collectors.toList())
                        .stream().max(Comparator.naturalOrder()).orElse(0) + 1);
            }
            result = archivesImageInfoMapper.updateArchivesImageInfo(archivesImageInfo);
        } else {
            String toUrl = "C:" + oldArchivesImageInfo.getOriginalFilename();
            String toOptimizeUrl = "C:" + oldArchivesImageInfo.getOptimizeFilename();
            File file = base64ToFile(archivesImageInfo.getOriginalFilename());
            File optimizeFile = base64ToFile(archivesImageInfo.getOptimizeFilename());
            File oldFile = new File(toUrl);
            File oldOptimizeFile = new File(toOptimizeUrl);
            if (oldFile.exists()) {
                if (oldFile.delete()) {
                    try {
                        copyFileToPerm(file, oldFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    copyFileToPerm(file, oldFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oldOptimizeFile.exists()) {
                if (oldOptimizeFile.delete()) {
                    try {
                        copyFileToPerm(optimizeFile, oldOptimizeFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    copyFileToPerm(optimizeFile, oldOptimizeFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            archivesImageInfo.setOptimizeFilename(oldArchivesImageInfo.getOptimizeFilename());
            archivesImageInfo.setOriginalFilename(oldArchivesImageInfo.getOriginalFilename());
            if (ObjectUtils.isEmpty(archivesImageInfo.getSort())) {
                archivesImageInfo.setSort(archivesImageInfoList.stream()
                        .map(ArchivesImageInfo::getSort).collect(Collectors.toList())
                        .stream().max(Comparator.naturalOrder()).orElse(0) + 1);
            }
            result = archivesImageInfoMapper.updateArchivesImageInfo(archivesImageInfo);
        }
        return result;
    }

    /**
     * 批量删除档案图像存储索引信息
     * 
     * @param ids 需要删除的档案图像存储索引信息主键
     * @return 结果
     */
    @Override
    public int deleteArchivesImageInfoByIds(String ids)
    {
        Long id = Long.valueOf(Convert.toStrArray(ids)[0]);
        ArchivesImageInfo archivesImageInfo = archivesImageInfoMapper.selectArchivesImageInfoById(id);
        if (StringUtils.isNotEmpty(archivesImageInfo.getOriginalFilename())) {
            File originalFile = new File("C:" + archivesImageInfo.getOriginalFilename());
            originalFile.delete();
        }
        if (StringUtils.isNotEmpty(archivesImageInfo.getOptimizeFilename())) {
            File optimizeFile = new File("C:" + archivesImageInfo.getOptimizeFilename());
            optimizeFile.delete();
        }
        return archivesImageInfoMapper.deleteArchivesImageInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除档案图像存储索引信息信息
     * 
     * @param id 档案图像存储索引信息主键
     * @return 结果
     */
    @Override
    public int deleteArchivesImageInfoById(Long id)
    {
        ArchivesImageInfo archivesImageInfo = archivesImageInfoMapper.selectArchivesImageInfoById(id);
        if (StringUtils.isNotEmpty(archivesImageInfo.getOriginalFilename())) {
            File originalFile = new File("C:" + archivesImageInfo.getOriginalFilename());
            originalFile.delete();
        }
        if (StringUtils.isNotEmpty(archivesImageInfo.getOptimizeFilename())) {
            File optimizeFile = new File("C:" + archivesImageInfo.getOptimizeFilename());
            optimizeFile.delete();
        }
        return archivesImageInfoMapper.deleteArchivesImageInfoById(id);
    }

    public static File base64ToFile(String base64) {
        if(base64==null||"".equals(base64)) {
            return null;
        }
        byte[] buff= Base64.decode(base64);
        File file=null;
        FileOutputStream fout=null;
        try {
            file = File.createTempFile("temp", ".jpeg");
            fout=new FileOutputStream(file);
            fout.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fout!=null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    public static void copyFileToPerm(File sourceFile, File targetFile)
            throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 10];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }

}
