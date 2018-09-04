package com.inspur.dataFactory.job.pojo.reverseProxyPojo;

import java.util.Date;

public class Website {
    private String websiteId;

    private String websiteName;

    private String websiteType;

    private String firstDomain;

    private String secondDomain;

    private Short websiteStatus;

    private Date createTime;

    private Date modifyTime;

    private String founderId;

    private String modifierId;

    private String shareId;

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId == null ? null : websiteId.trim();
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName == null ? null : websiteName.trim();
    }

    public String getWebsiteType() {
        return websiteType;
    }

    public void setWebsiteType(String websiteType) {
        this.websiteType = websiteType == null ? null : websiteType.trim();
    }

    public String getFirstDomain() {
        return firstDomain;
    }

    public void setFirstDomain(String firstDomain) {
        this.firstDomain = firstDomain == null ? null : firstDomain.trim();
    }

    public String getSecondDomain() {
        return secondDomain;
    }

    public void setSecondDomain(String secondDomain) {
        this.secondDomain = secondDomain == null ? null : secondDomain.trim();
    }

    public Short getWebsiteStatus() {
        return websiteStatus;
    }

    public void setWebsiteStatus(Short websiteStatus) {
        this.websiteStatus = websiteStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getFounderId() {
        return founderId;
    }

    public void setFounderId(String founderId) {
        this.founderId = founderId == null ? null : founderId.trim();
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId == null ? null : modifierId.trim();
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }
}