package com.ruoyi.project.system.archivesUserInfo.domain;

import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 人员基本信息管理对象 archives_user_info
 * 
 * @author ruoyi
 * @date 2021-08-18
 */
public class ArchivesUserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人员主键 */
    private Long id;

    /** 人员姓名 */
    @Excel(name = "人员姓名")
    private String personName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birthday;

    /** 照片路径 */
    @Excel(name = "照片路径")
    private String imgUrl;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 出生地 */
    @Excel(name = "出生地")
    private String birthplace;

    /** 入党时间 */
    @Excel(name = "入党时间")
    private String joinPartyTime;

    /** 参加工作时间 */
    @Excel(name = "参加工作时间")
    private String workTime;

    /** 健康状况 */
    @Excel(name = "健康状况")
    private String health;

    /** 专业技术职务 */
    @Excel(name = "专业技术职务")
    private String technicalPosition;

    /** 熟悉专业有何特长 */
    @Excel(name = "熟悉专业有何特长")
    private String specialty;

    /** 全日制教育  大学 */
    @Excel(name = "全日制教育  大学")
    private String fullTimeEducation;

    /** 全日制学校 */
    @Excel(name = "全日制学校")
    private String fullTimeSchool;

    /** 全日制教育  学位 */
    @Excel(name = "全日制教育  学位")
    private String fullTimeDegree;

    /** 全日制学历 */
    @Excel(name = "全日制学历")
    private String fullTimeEduBack;

    /** 全日制教育 毕业院校系及专业 */
    @Excel(name = "全日制教育 毕业院校系及专业")
    private String fullTimeMajor;

    /** 在职教育 */
    @Excel(name = "在职教育")
    private String inServiceEducation;

    /** 在职教育  学位 */
    @Excel(name = "在职教育  学位")
    private String inServiceDegree;

    /** 在职教育  毕业院校系及专业 */
    @Excel(name = "在职教育  毕业院校系及专业")
    private String inServiceMajor;

    /** 在职学历 */
    @Excel(name = "在职学历")
    private String inServiceEduBack;

    /** 在职教育类别 */
    @Excel(name = "在职教育类别")
    private String inEducationCategory;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String workUnit;

    /** 现任职务 */
    @Excel(name = "现任职务")
    private String duty;

    /** 拟任职务 */
    @Excel(name = "拟任职务")
    private String proposedDuty;

    /** 拟免职务 */
    @Excel(name = "拟免职务")
    private String proposedRemoval;

    /** 简历 */
    @Excel(name = "简历")
    private String resume;

    /** 奖惩情况 */
    @Excel(name = "奖惩情况")
    private String bonusPenalty;

    /** 年度考核结果 */
    @Excel(name = "年度考核结果")
    private String assessmentResults;

    private String startTime1;
    private String endTime1;
    private String resume1;
    private String startTime2;
    private String endTime2;
    private String resume2;
    private String startTime3;
    private String endTime3;
    private String resume3;
    private String startTime4;
    private String endTime4;
    private String resume4;
    private String startTime5;
    private String endTime5;
    private String resume5;
    private String startTime6;
    private String endTime6;
    private String resume6;
    private String startTime7;
    private String endTime7;
    private String resume7;
    private String startTime8;
    private String endTime8;
    private String resume8;
    private String startTime9;
    private String endTime9;
    private String resume9;

    private String relatives;
    private String relativesCall1;
    private String relativesCall2;
    private String relativesCall3;
    private String relativesCall4;
    private String relativesCall5;
    private String relativesCall6;
    private String relativesCall7;
    private String relativesCall8;
    private String relativesCall9;

    private String relativesName1;
    private String relativesName2;
    private String relativesName3;
    private String relativesName4;
    private String relativesName5;
    private String relativesName6;
    private String relativesName7;
    private String relativesName8;
    private String relativesName9;

    private String relativesBirth1;
    private String relativesBirth2;
    private String relativesBirth3;
    private String relativesBirth4;
    private String relativesBirth5;
    private String relativesBirth6;
    private String relativesBirth7;
    private String relativesBirth8;
    private String relativesBirth9;

    private String relativesPolitical1;
    private String relativesPolitical2;
    private String relativesPolitical3;
    private String relativesPolitical4;
    private String relativesPolitical5;
    private String relativesPolitical6;
    private String relativesPolitical7;
    private String relativesPolitical8;
    private String relativesPolitical9;

    private String relativesWork1;
    private String relativesWork2;
    private String relativesWork3;
    private String relativesWork4;
    private String relativesWork5;
    private String relativesWork6;
    private String relativesWork7;
    private String relativesWork8;
    private String relativesWork9;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 管理类别 */
    @Excel(name = "管理类别")
    private String manageCategory;

    /** 人员类别 */
    @Excel(name = "人员类别")
    private String personCategory;

    /** 编制类型 */
    @Excel(name = "编制类型")
    private String preparationType;

    /** 职位类别 */
    @Excel(name = "职位类别")
    private String positionCategory;

    /** 现职务层次 */
    @Excel(name = "现职务层次")
    private String jobLevel;

    /** 任现职务层次时间 */
    @Excel(name = "任现职务层次时间")
    private String jobLevelTime;

    /** 现职级 */
    @Excel(name = "现职级")
    private String currentLevel;

    /** 任现职级时间 */
    @Excel(name = "任现职级时间")
    private String currentLevelTime;

    /** 任相当层次职务职级时间 */
    @Excel(name = "任相当层次职务职级时间")
    private String quiteTime;

    /** 公务员登记时间 */
    @Excel(name = "公务员登记时间")
    private String registerTime;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalOutlook;

    /** 毕业时间 */
    @Excel(name = "毕业时间")
    private String graduationTime;

    /** 部门ID 内设机构*/
    private Long deptId;

    /** 部门父ID */
    private Long parentId;

    private List<ArchivesUserInfoRelative> relativeList;

    private List<ArchivesUserInfoResume> resumeList;

    private List<ArchivesUserInfoPenalty> penaltyList;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private String highEducation;

    /** 级别待遇 */
    @Excel(name = "级别待遇")
    private String levelTreatment;

    /** 首次任职务职级时间 */
    @Excel(name = "首次任职务职级时间")
    private String firstJobTime;

    /** 首次任职务职级年数 */
    @Excel(name = "首次任职务职级年数")
    private String firstJobYear;

    /** 评优受奖时间 */
    @Excel(name = "评优受奖时间")
    private String awardTime;

    /** 部门非领导 */
    @Excel(name = "部门非领导")
    private String deptLeader;

    /** 推迟退休 */
    @Excel(name = "推迟退休")
    private String delayRetire;

    /** 原单位 */
    @Excel(name = "原单位")
    private String originalUnit;

    /** 落编时间 */
    @Excel(name = "落编时间")
    private String offSetTime;

    /** 退役军人 */
    @Excel(name = "退役军人")
    private String veterans;

    /** 落编原因 */
    @Excel(name = "落编原因")
    private String offSetCause;

    /** 公务员登记 */
    @Excel(name = "公务员登记")
    private String registerStatus;

    /** 电子编制证号 */
    @Excel(name = "电子编制证号")
    private String electronicNo;

    /** 工资总额 */
    @Excel(name = "工资总额")
    private String totalWages;

    /** 调入我省前所在省份 */
    @Excel(name = "调入我省前所在省份")
    private String beforeProvince;

    /** 调入我省前工作单位 */
    @Excel(name = "调入我省前工作单位")
    private String beforeJobPlace;

    /** 注销原因 */
    @Excel(name = "注销原因")
    private String cause;

    /** 任免理由 */
    @Excel(name = "任免理由")
    private String reasons;

    /** 任免理由 */
    @Excel(name = "档案编号")
    private String fileNo;

    /** 任免理由 */
    @Excel(name = "档案存放位置")
    private String position;

    private String uuid;

    private Dept dept;

    public List<ArchivesUserInfoPenalty> getPenaltyList() {
        return penaltyList;
    }

    public void setPenaltyList(List<ArchivesUserInfoPenalty> penaltyList) {
        this.penaltyList = penaltyList;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPersonName(String personName)
    {
        this.personName = personName;
    }

    public String getPersonName()
    {
        return personName;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getBirthday()
    {
        return birthday;
    }
    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public String getNation()
    {
        return nation;
    }
    public void setNativePlace(String nativePlace)
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace()
    {
        return nativePlace;
    }
    public void setBirthplace(String birthplace)
    {
        this.birthplace = birthplace;
    }

    public String getBirthplace()
    {
        return birthplace;
    }
    public void setJoinPartyTime(String joinPartyTime)
    {
        this.joinPartyTime = joinPartyTime;
    }

    public String getJoinPartyTime()
    {
        return joinPartyTime;
    }
    public void setWorkTime(String workTime)
    {
        this.workTime = workTime;
    }

    public String getWorkTime()
    {
        return workTime;
    }
    public void setHealth(String health)
    {
        this.health = health;
    }

    public String getHealth()
    {
        return health;
    }
    public void setTechnicalPosition(String technicalPosition)
    {
        this.technicalPosition = technicalPosition;
    }

    public String getTechnicalPosition()
    {
        return technicalPosition;
    }
    public void setSpecialty(String specialty)
    {
        this.specialty = specialty;
    }

    public String getSpecialty()
    {
        return specialty;
    }
    public void setFullTimeEducation(String fullTimeEducation)
    {
        this.fullTimeEducation = fullTimeEducation;
    }

    public String getFullTimeEducation()
    {
        return fullTimeEducation;
    }
    public void setFullTimeSchool(String fullTimeSchool)
    {
        this.fullTimeSchool = fullTimeSchool;
    }

    public String getFullTimeSchool()
    {
        return fullTimeSchool;
    }
    public void setFullTimeDegree(String fullTimeDegree)
    {
        this.fullTimeDegree = fullTimeDegree;
    }

    public String getFullTimeDegree()
    {
        return fullTimeDegree;
    }
    public void setFullTimeEduBack(String fullTimeEduBack)
    {
        this.fullTimeEduBack = fullTimeEduBack;
    }

    public String getFullTimeEduBack()
    {
        return fullTimeEduBack;
    }
    public void setFullTimeMajor(String fullTimeMajor)
    {
        this.fullTimeMajor = fullTimeMajor;
    }

    public String getFullTimeMajor()
    {
        return fullTimeMajor;
    }
    public void setInServiceEducation(String inServiceEducation)
    {
        this.inServiceEducation = inServiceEducation;
    }

    public String getInServiceEducation()
    {
        return inServiceEducation;
    }
    public void setInServiceDegree(String inServiceDegree)
    {
        this.inServiceDegree = inServiceDegree;
    }

    public String getInServiceDegree()
    {
        return inServiceDegree;
    }
    public void setInServiceMajor(String inServiceMajor)
    {
        this.inServiceMajor = inServiceMajor;
    }

    public String getInServiceMajor()
    {
        return inServiceMajor;
    }
    public void setInServiceEduBack(String inServiceEduBack)
    {
        this.inServiceEduBack = inServiceEduBack;
    }

    public String getInServiceEduBack()
    {
        return inServiceEduBack;
    }
    public void setInEducationCategory(String inEducationCategory)
    {
        this.inEducationCategory = inEducationCategory;
    }

    public String getInEducationCategory()
    {
        return inEducationCategory;
    }
    public void setWorkUnit(String workUnit)
    {
        this.workUnit = workUnit;
    }

    public String getWorkUnit()
    {
        return workUnit;
    }
    public void setDuty(String duty)
    {
        this.duty = duty;
    }

    public String getDuty()
    {
        return duty;
    }
    public void setResume(String resume)
    {
        this.resume = resume;
    }

    public String getResume()
    {
        return resume;
    }
    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getIdCard()
    {
        return idCard;
    }
    public void setManageCategory(String manageCategory)
    {
        this.manageCategory = manageCategory;
    }

    public String getManageCategory()
    {
        return manageCategory;
    }
    public void setPersonCategory(String personCategory)
    {
        this.personCategory = personCategory;
    }

    public String getPersonCategory()
    {
        return personCategory;
    }
    public void setPreparationType(String preparationType)
    {
        this.preparationType = preparationType;
    }

    public String getPreparationType()
    {
        return preparationType;
    }
    public void setPositionCategory(String positionCategory)
    {
        this.positionCategory = positionCategory;
    }

    public String getPositionCategory()
    {
        return positionCategory;
    }
    public void setJobLevel(String jobLevel)
    {
        this.jobLevel = jobLevel;
    }

    public String getJobLevel()
    {
        return jobLevel;
    }
    public void setJobLevelTime(String jobLevelTime)
    {
        this.jobLevelTime = jobLevelTime;
    }

    public String getJobLevelTime()
    {
        return jobLevelTime;
    }
    public void setCurrentLevel(String currentLevel)
    {
        this.currentLevel = currentLevel;
    }

    public String getCurrentLevel()
    {
        return currentLevel;
    }
    public void setCurrentLevelTime(String currentLevelTime)
    {
        this.currentLevelTime = currentLevelTime;
    }

    public String getCurrentLevelTime()
    {
        return currentLevelTime;
    }
    public void setQuiteTime(String quiteTime)
    {
        this.quiteTime = quiteTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQuiteTime()
    {
        return quiteTime;
    }
    public void setRegisterTime(String registerTime)
    {
        this.registerTime = registerTime;
    }

    public String getRegisterTime()
    {
        return registerTime;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setPoliticalOutlook(String politicalOutlook)
    {
        this.politicalOutlook = politicalOutlook;
    }

    public String getPoliticalOutlook()
    {
        return politicalOutlook;
    }
    public void setGraduationTime(String graduationTime)
    {
        this.graduationTime = graduationTime;
    }

    public String getGraduationTime()
    {
        return graduationTime;
    }

    public void setHighEducation(String highEducation)
    {
        this.highEducation = highEducation;
    }

    public String getHighEducation()
    {
        return highEducation;
    }
    public void setLevelTreatment(String levelTreatment)
    {
        this.levelTreatment = levelTreatment;
    }

    public String getLevelTreatment()
    {
        return levelTreatment;
    }
    public void setFirstJobTime(String firstJobTime)
    {
        this.firstJobTime = firstJobTime;
    }

    public String getFirstJobTime()
    {
        return firstJobTime;
    }
    public void setFirstJobYear(String firstJobYear)
    {
        this.firstJobYear = firstJobYear;
    }

    public String getFirstJobYear()
    {
        return firstJobYear;
    }
    public void setAwardTime(String awardTime)
    {
        this.awardTime = awardTime;
    }

    public String getAwardTime()
    {
        return awardTime;
    }
    public void setDeptLeader(String deptLeader)
    {
        this.deptLeader = deptLeader;
    }

    public String getDeptLeader()
    {
        return deptLeader;
    }
    public void setDelayRetire(String delayRetire)
    {
        this.delayRetire = delayRetire;
    }

    public String getDelayRetire()
    {
        return delayRetire;
    }
    public void setOriginalUnit(String originalUnit)
    {
        this.originalUnit = originalUnit;
    }

    public String getOriginalUnit()
    {
        return originalUnit;
    }
    public void setOffSetTime(String offSetTime)
    {
        this.offSetTime = offSetTime;
    }

    public String getOffSetTime()
    {
        return offSetTime;
    }
    public void setVeterans(String veterans)
    {
        this.veterans = veterans;
    }

    public String getVeterans()
    {
        return veterans;
    }
    public void setOffSetCause(String offSetCause)
    {
        this.offSetCause = offSetCause;
    }

    public String getOffSetCause()
    {
        return offSetCause;
    }
    public void setRegisterStatus(String registerStatus)
    {
        this.registerStatus = registerStatus;
    }

    public String getRegisterStatus()
    {
        return registerStatus;
    }
    public void setElectronicNo(String electronicNo)
    {
        this.electronicNo = electronicNo;
    }

    public String getElectronicNo()
    {
        return electronicNo;
    }
    public void setTotalWages(String totalWages)
    {
        this.totalWages = totalWages;
    }

    public String getTotalWages()
    {
        return totalWages;
    }
    public void setBeforeProvince(String beforeProvince)
    {
        this.beforeProvince = beforeProvince;
    }

    public String getBeforeProvince()
    {
        return beforeProvince;
    }
    public void setBeforeJobPlace(String beforeJobPlace)
    {
        this.beforeJobPlace = beforeJobPlace;
    }

    public String getBeforeJobPlace()
    {
        return beforeJobPlace;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProposedDuty() {
        return proposedDuty;
    }

    public void setProposedDuty(String proposedDuty) {
        this.proposedDuty = proposedDuty;
    }

    public String getProposedRemoval() {
        return proposedRemoval;
    }

    public void setProposedRemoval(String proposedRemoval) {
        this.proposedRemoval = proposedRemoval;
    }

    public String getBonusPenalty() {
        return bonusPenalty;
    }

    public void setBonusPenalty(String bonusPenalty) {
        this.bonusPenalty = bonusPenalty;
    }

    public String getAssessmentResults() {
        return assessmentResults;
    }

    public void setAssessmentResults(String assessmentResults) {
        this.assessmentResults = assessmentResults;
    }

    public String getRelativesCall1() {
        return relativesCall1;
    }

    public void setRelativesCall1(String relativesCall1) {
        this.relativesCall1 = relativesCall1;
    }

    public String getRelativesCall2() {
        return relativesCall2;
    }

    public void setRelativesCall2(String relativesCall2) {
        this.relativesCall2 = relativesCall2;
    }

    public String getRelativesCall3() {
        return relativesCall3;
    }

    public void setRelativesCall3(String relativesCall3) {
        this.relativesCall3 = relativesCall3;
    }

    public String getRelativesCall4() {
        return relativesCall4;
    }

    public void setRelativesCall4(String relativesCall4) {
        this.relativesCall4 = relativesCall4;
    }

    public String getRelativesCall5() {
        return relativesCall5;
    }

    public void setRelativesCall5(String relativesCall5) {
        this.relativesCall5 = relativesCall5;
    }

    public String getRelativesCall6() {
        return relativesCall6;
    }

    public void setRelativesCall6(String relativesCall6) {
        this.relativesCall6 = relativesCall6;
    }

    public String getRelativesCall7() {
        return relativesCall7;
    }

    public void setRelativesCall7(String relativesCall7) {
        this.relativesCall7 = relativesCall7;
    }

    public String getRelativesCall8() {
        return relativesCall8;
    }

    public void setRelativesCall8(String relativesCall8) {
        this.relativesCall8 = relativesCall8;
    }

    public String getRelativesCall9() {
        return relativesCall9;
    }

    public void setRelativesCall9(String relativesCall9) {
        this.relativesCall9 = relativesCall9;
    }

    public String getRelativesName1() {
        return relativesName1;
    }

    public void setRelativesName1(String relativesName1) {
        this.relativesName1 = relativesName1;
    }

    public String getRelativesName2() {
        return relativesName2;
    }

    public void setRelativesName2(String relativesName2) {
        this.relativesName2 = relativesName2;
    }

    public String getRelativesName3() {
        return relativesName3;
    }

    public void setRelativesName3(String relativesName3) {
        this.relativesName3 = relativesName3;
    }

    public String getRelativesName4() {
        return relativesName4;
    }

    public void setRelativesName4(String relativesName4) {
        this.relativesName4 = relativesName4;
    }

    public String getRelativesName5() {
        return relativesName5;
    }

    public void setRelativesName5(String relativesName5) {
        this.relativesName5 = relativesName5;
    }

    public String getRelativesName6() {
        return relativesName6;
    }

    public void setRelativesName6(String relativesName6) {
        this.relativesName6 = relativesName6;
    }

    public String getRelativesName7() {
        return relativesName7;
    }

    public void setRelativesName7(String relativesName7) {
        this.relativesName7 = relativesName7;
    }

    public String getRelativesName8() {
        return relativesName8;
    }

    public void setRelativesName8(String relativesName8) {
        this.relativesName8 = relativesName8;
    }

    public String getRelativesName9() {
        return relativesName9;
    }

    public void setRelativesName9(String relativesName9) {
        this.relativesName9 = relativesName9;
    }

    public String getRelativesBirth1() {
        return relativesBirth1;
    }

    public void setRelativesBirth1(String relativesBirth1) {
        this.relativesBirth1 = relativesBirth1;
    }

    public String getRelativesBirth2() {
        return relativesBirth2;
    }

    public void setRelativesBirth2(String relativesBirth2) {
        this.relativesBirth2 = relativesBirth2;
    }

    public String getRelativesBirth3() {
        return relativesBirth3;
    }

    public void setRelativesBirth3(String relativesBirth3) {
        this.relativesBirth3 = relativesBirth3;
    }

    public String getRelativesBirth4() {
        return relativesBirth4;
    }

    public void setRelativesBirth4(String relativesBirth4) {
        this.relativesBirth4 = relativesBirth4;
    }

    public String getRelativesBirth5() {
        return relativesBirth5;
    }

    public void setRelativesBirth5(String relativesBirth5) {
        this.relativesBirth5 = relativesBirth5;
    }

    public String getRelativesBirth6() {
        return relativesBirth6;
    }

    public void setRelativesBirth6(String relativesBirth6) {
        this.relativesBirth6 = relativesBirth6;
    }

    public String getRelativesBirth7() {
        return relativesBirth7;
    }

    public void setRelativesBirth7(String relativesBirth7) {
        this.relativesBirth7 = relativesBirth7;
    }

    public String getRelativesBirth8() {
        return relativesBirth8;
    }

    public void setRelativesBirth8(String relativesBirth8) {
        this.relativesBirth8 = relativesBirth8;
    }

    public String getRelativesBirth9() {
        return relativesBirth9;
    }

    public void setRelativesBirth9(String relativesBirth9) {
        this.relativesBirth9 = relativesBirth9;
    }

    public String getRelativesPolitical1() {
        return relativesPolitical1;
    }

    public void setRelativesPolitical1(String relativesPolitical1) {
        this.relativesPolitical1 = relativesPolitical1;
    }

    public String getRelativesPolitical2() {
        return relativesPolitical2;
    }

    public void setRelativesPolitical2(String relativesPolitical2) {
        this.relativesPolitical2 = relativesPolitical2;
    }

    public String getRelativesPolitical3() {
        return relativesPolitical3;
    }

    public void setRelativesPolitical3(String relativesPolitical3) {
        this.relativesPolitical3 = relativesPolitical3;
    }

    public String getRelativesPolitical4() {
        return relativesPolitical4;
    }

    public void setRelativesPolitical4(String relativesPolitical4) {
        this.relativesPolitical4 = relativesPolitical4;
    }

    public String getRelativesPolitical5() {
        return relativesPolitical5;
    }

    public void setRelativesPolitical5(String relativesPolitical5) {
        this.relativesPolitical5 = relativesPolitical5;
    }

    public String getRelativesPolitical6() {
        return relativesPolitical6;
    }

    public void setRelativesPolitical6(String relativesPolitical6) {
        this.relativesPolitical6 = relativesPolitical6;
    }

    public String getRelativesPolitical7() {
        return relativesPolitical7;
    }

    public void setRelativesPolitical7(String relativesPolitical7) {
        this.relativesPolitical7 = relativesPolitical7;
    }

    public String getRelativesPolitical8() {
        return relativesPolitical8;
    }

    public void setRelativesPolitical8(String relativesPolitical8) {
        this.relativesPolitical8 = relativesPolitical8;
    }

    public String getRelativesPolitical9() {
        return relativesPolitical9;
    }

    public void setRelativesPolitical9(String relativesPolitical9) {
        this.relativesPolitical9 = relativesPolitical9;
    }

    public String getRelativesWork1() {
        return relativesWork1;
    }

    public void setRelativesWork1(String relativesWork1) {
        this.relativesWork1 = relativesWork1;
    }

    public String getRelativesWork2() {
        return relativesWork2;
    }

    public void setRelativesWork2(String relativesWork2) {
        this.relativesWork2 = relativesWork2;
    }

    public String getRelativesWork3() {
        return relativesWork3;
    }

    public void setRelativesWork3(String relativesWork3) {
        this.relativesWork3 = relativesWork3;
    }

    public String getRelativesWork4() {
        return relativesWork4;
    }

    public void setRelativesWork4(String relativesWork4) {
        this.relativesWork4 = relativesWork4;
    }

    public String getRelativesWork5() {
        return relativesWork5;
    }

    public void setRelativesWork5(String relativesWork5) {
        this.relativesWork5 = relativesWork5;
    }

    public String getRelativesWork6() {
        return relativesWork6;
    }

    public void setRelativesWork6(String relativesWork6) {
        this.relativesWork6 = relativesWork6;
    }

    public String getRelativesWork7() {
        return relativesWork7;
    }

    public void setRelativesWork7(String relativesWork7) {
        this.relativesWork7 = relativesWork7;
    }

    public String getRelativesWork8() {
        return relativesWork8;
    }

    public void setRelativesWork8(String relativesWork8) {
        this.relativesWork8 = relativesWork8;
    }

    public String getRelativesWork9() {
        return relativesWork9;
    }

    public void setRelativesWork9(String relativesWork9) {
        this.relativesWork9 = relativesWork9;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    public List<ArchivesUserInfoRelative> getRelativeList() {
        return relativeList;
    }

    public void setRelativeList(List<ArchivesUserInfoRelative> relativeList) {
        this.relativeList = relativeList;
    }

    public List<ArchivesUserInfoResume> getResumeList() {
        return resumeList;
    }

    public void setResumeList(List<ArchivesUserInfoResume> resumeList) {
        this.resumeList = resumeList;
    }

    public String getStartTime1() {
        return startTime1;
    }

    public void setStartTime1(String startTime1) {
        this.startTime1 = startTime1;
    }

    public String getEndTime1() {
        return endTime1;
    }

    public void setEndTime1(String endTime1) {
        this.endTime1 = endTime1;
    }

    public String getResume1() {
        return resume1;
    }

    public void setResume1(String resume1) {
        this.resume1 = resume1;
    }

    public String getStartTime2() {
        return startTime2;
    }

    public void setStartTime2(String startTime2) {
        this.startTime2 = startTime2;
    }

    public String getEndTime2() {
        return endTime2;
    }

    public void setEndTime2(String endTime2) {
        this.endTime2 = endTime2;
    }

    public String getResume2() {
        return resume2;
    }

    public void setResume2(String resume2) {
        this.resume2 = resume2;
    }

    public String getStartTime3() {
        return startTime3;
    }

    public void setStartTime3(String startTime3) {
        this.startTime3 = startTime3;
    }

    public String getEndTime3() {
        return endTime3;
    }

    public void setEndTime3(String endTime3) {
        this.endTime3 = endTime3;
    }

    public String getResume3() {
        return resume3;
    }

    public void setResume3(String resume3) {
        this.resume3 = resume3;
    }

    public String getStartTime4() {
        return startTime4;
    }

    public void setStartTime4(String startTime4) {
        this.startTime4 = startTime4;
    }

    public String getEndTime4() {
        return endTime4;
    }

    public void setEndTime4(String endTime4) {
        this.endTime4 = endTime4;
    }

    public String getResume4() {
        return resume4;
    }

    public void setResume4(String resume4) {
        this.resume4 = resume4;
    }

    public String getStartTime5() {
        return startTime5;
    }

    public void setStartTime5(String startTime5) {
        this.startTime5 = startTime5;
    }

    public String getEndTime5() {
        return endTime5;
    }

    public void setEndTime5(String endTime5) {
        this.endTime5 = endTime5;
    }

    public String getResume5() {
        return resume5;
    }

    public void setResume5(String resume5) {
        this.resume5 = resume5;
    }

    public String getStartTime6() {
        return startTime6;
    }

    public void setStartTime6(String startTime6) {
        this.startTime6 = startTime6;
    }

    public String getEndTime6() {
        return endTime6;
    }

    public void setEndTime6(String endTime6) {
        this.endTime6 = endTime6;
    }

    public String getResume6() {
        return resume6;
    }

    public void setResume6(String resume6) {
        this.resume6 = resume6;
    }

    public String getStartTime7() {
        return startTime7;
    }

    public void setStartTime7(String startTime7) {
        this.startTime7 = startTime7;
    }

    public String getEndTime7() {
        return endTime7;
    }

    public void setEndTime7(String endTime7) {
        this.endTime7 = endTime7;
    }

    public String getResume7() {
        return resume7;
    }

    public void setResume7(String resume7) {
        this.resume7 = resume7;
    }

    public String getStartTime8() {
        return startTime8;
    }

    public void setStartTime8(String startTime8) {
        this.startTime8 = startTime8;
    }

    public String getEndTime8() {
        return endTime8;
    }

    public void setEndTime8(String endTime8) {
        this.endTime8 = endTime8;
    }

    public String getResume8() {
        return resume8;
    }

    public void setResume8(String resume8) {
        this.resume8 = resume8;
    }

    public String getStartTime9() {
        return startTime9;
    }

    public void setStartTime9(String startTime9) {
        this.startTime9 = startTime9;
    }

    public String getEndTime9() {
        return endTime9;
    }

    public void setEndTime9(String endTime9) {
        this.endTime9 = endTime9;
    }

    public String getResume9() {
        return resume9;
    }

    public void setResume9(String resume9) {
        this.resume9 = resume9;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("personName", getPersonName())
            .append("sex", getSex())
            .append("birthday", getBirthday())
            .append("nation", getNation())
            .append("nativePlace", getNativePlace())
            .append("birthplace", getBirthplace())
            .append("joinPartyTime", getJoinPartyTime())
            .append("workTime", getWorkTime())
            .append("health", getHealth())
            .append("technicalPosition", getTechnicalPosition())
            .append("specialty", getSpecialty())
            .append("fullTimeEducation", getFullTimeEducation())
            .append("fullTimeSchool", getFullTimeSchool())
            .append("fullTimeDegree", getFullTimeDegree())
            .append("fullTimeEduBack", getFullTimeEduBack())
            .append("fullTimeMajor", getFullTimeMajor())
            .append("inServiceEducation", getInServiceEducation())
            .append("inServiceDegree", getInServiceDegree())
            .append("inServiceMajor", getInServiceMajor())
            .append("inServiceEduBack", getInServiceEduBack())
            .append("inEducationCategory", getInEducationCategory())
            .append("workUnit", getWorkUnit())
            .append("duty", getDuty())
            .append("resume", getResume())
            .append("idCard", getIdCard())
            .append("manageCategory", getManageCategory())
            .append("personCategory", getPersonCategory())
            .append("preparationType", getPreparationType())
            .append("positionCategory", getPositionCategory())
            .append("jobLevel", getJobLevel())
            .append("jobLevelTime", getJobLevelTime())
            .append("currentLevel", getCurrentLevel())
            .append("currentLevelTime", getCurrentLevelTime())
            .append("quiteTime", getQuiteTime())
            .append("registerTime", getRegisterTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("politicalOutlook", getPoliticalOutlook())
            .append("graduationTime", getGraduationTime())
            .append("highEducation", getHighEducation())
            .append("levelTreatment", getLevelTreatment())
            .append("firstJobTime", getFirstJobTime())
            .append("firstJobYear", getFirstJobYear())
            .append("awardTime", getAwardTime())
            .append("deptLeader", getDeptLeader())
            .append("delayRetire", getDelayRetire())
            .append("originalUnit", getOriginalUnit())
            .append("offSetTime", getOffSetTime())
            .append("veterans", getVeterans())
            .append("offSetCause", getOffSetCause())
            .append("registerStatus", getRegisterStatus())
            .append("electronicNo", getElectronicNo())
            .append("totalWages", getTotalWages())
            .append("uuid", getUuid())
            .append("beforeProvince", getBeforeProvince())
            .append("beforeJobPlace", getBeforeJobPlace())
                .append("relativeList", getRelativeList())
                .append("resumeList", getResumeList())
                .append("penaltyList", getPenaltyList())
            .toString();
    }
}
