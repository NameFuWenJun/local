package com.inspur.dataFactory.job.pojo.reverseProxyPojo;

public class TaskLink extends TaskLinkKey {
    private String parentLinkId;

    private String parentRuleId;

    private Short startCondition;

    private Integer maxError;

    public String getParentLinkId() {
        return parentLinkId;
    }

    public void setParentLinkId(String parentLinkId) {
        this.parentLinkId = parentLinkId == null ? null : parentLinkId.trim();
    }

    public String getParentRuleId() {
        return parentRuleId;
    }

    public void setParentRuleId(String parentRuleId) {
        this.parentRuleId = parentRuleId == null ? null : parentRuleId.trim();
    }

    public Short getStartCondition() {
        return startCondition;
    }

    public void setStartCondition(Short startCondition) {
        this.startCondition = startCondition;
    }

    public Integer getMaxError() {
        return maxError;
    }

    public void setMaxError(Integer maxError) {
        this.maxError = maxError;
    }
}