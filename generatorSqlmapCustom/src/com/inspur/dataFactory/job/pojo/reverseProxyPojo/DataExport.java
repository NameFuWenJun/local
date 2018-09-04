package com.inspur.dataFactory.job.pojo.reverseProxyPojo;

import java.util.Date;

public class DataExport {
    private String instanceId;

    private String ruleId;

    private Short exportType;

    private String tableName;

    private Short append;

    private Date startTime;

    private Date endTime;

    private String starterId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId == null ? null : instanceId.trim();
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public Short getExportType() {
        return exportType;
    }

    public void setExportType(Short exportType) {
        this.exportType = exportType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Short getAppend() {
        return append;
    }

    public void setAppend(Short append) {
        this.append = append;
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