package com.inspur.dataFactory.job.pojo.reverseProxyPojo;

public class LinkMonitor {
    private String linkId;

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId == null ? null : linkId.trim();
    }
}