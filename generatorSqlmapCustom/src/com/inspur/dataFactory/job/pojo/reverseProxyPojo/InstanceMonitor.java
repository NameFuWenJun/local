package com.inspur.dataFactory.job.pojo.reverseProxyPojo;

public class InstanceMonitor {
    private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId == null ? null : instanceId.trim();
    }
}