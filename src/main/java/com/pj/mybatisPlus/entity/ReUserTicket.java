package com.pj.mybatisPlus.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户体验券(ReUserTicket)实体类
 *
 * @author makejava
 * @since 2021-05-02 10:16:33
 */
public class ReUserTicket implements Serializable {
    private static final long serialVersionUID = 108888278170763255L;
    
    private Integer id;
    /**
    * 微信OpenId
    */
    private String wechatOpenId;
    /**
    * 客户名称
    */
    private String userName;
    /**
    * 客户电话
    */
    private String phone;
    /**
    * 体验劵状态（0：未发放，1：发放未领取；2：领取未使用，3：已核销，4：过期，5：作废 ）
    */
    private Integer state;
    /**
    * 用户类型
    */
    private String status;
    /**
    * 置业顾问申请，资源表id
    */
    private Integer experienceId;
    /**
    * 后台发放，发放id
    */
    private Integer distributionId;
    /**
    * 资源id
    */
    private Integer resourceId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 置业顾问
    */
    private String zygw;
    /**
    * 是否删除 0否1是
    */
    private Integer isDelete;
    /**
    * 二维码code
    */
    private String code;
    
    private Integer createrId;
    
    private String createrName;
    /**
    * 数据区域：南宁  北海
    */
    private String rootDataArea;
    /**
    * 发放时间
    */
    private Date issueTime;
    /**
    * 领取时间
    */
    private Date collectionTime;
    /**
    * 核销时间
    */
    private Date destroyTime;
    /**
    * 过期时间
    */
    private Date expiredTime;
    /**
    * 用户唯一识别码，微信OpenId的密文
    */
    private String sysGuid;
    /**
    * 使用开始时间
    */
    private Date startTime;
    /**
    * 使用结束时间
    */
    private Date entTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }

    public Integer getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Integer distributionId) {
        this.distributionId = distributionId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getZygw() {
        return zygw;
    }

    public void setZygw(String zygw) {
        this.zygw = zygw;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getRootDataArea() {
        return rootDataArea;
    }

    public void setRootDataArea(String rootDataArea) {
        this.rootDataArea = rootDataArea;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public Date getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(Date destroyTime) {
        this.destroyTime = destroyTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getSysGuid() {
        return sysGuid;
    }

    public void setSysGuid(String sysGuid) {
        this.sysGuid = sysGuid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEntTime() {
        return entTime;
    }

    public void setEntTime(Date entTime) {
        this.entTime = entTime;
    }

}