package com.inspur.dataFactory.job.pojo.reverseProxyPojo;

import java.util.Date;

public class DataHandle {
    private Short handleType;

    private Date startTime;

    private Date endTime;

    private String starterId;

    public Short getHandleType() {
        return handleType;
    }

    public void setHandleType(Short handleType) {
        this.handleType = handleType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStarterId() {
        return starterId;
    }

    public void setStarterId(String starterId) {
        this.starterId = starterId == null ? null : starterId.trim();
    }
}