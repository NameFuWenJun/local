package com.itheima.mybatis.pojo;

import java.util.Date;

public class ParseRule {
    private String ruleId;

    private String linkId;

    private String ruleName;

    private Short urlType;

    private Short extractMode;

    private String peripheralRegex;

    private String regex;

    private String regexGroupId;

    private String xpath;

    private Short enabled;

    private Short urlWithLoop;

    private String loopStart;

    private String loopEnd;

    private String loopVar;

    private Integer loopStep;

    private String loopFormat;

    private Short loopVarType;

    private String loopSample;

    private String testUrl;

    private Date createTime;

    private Date modifyTime;

    private String founderId;

    private String modifierId;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId == null ? null : linkId.trim();
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public Short getUrlType() {
        return urlType;
    }

    public void setUrlType(Short urlType) {
        this.urlType = urlType;
    }

    public Short getExtractMode() {
        return extractMode;
    }

    public void setExtractMode(Short extractMode) {
        this.extractMode = extractMode;
    }

    public String getPeripheralRegex() {
        return peripheralRegex;
    }

    public void setPeripheralRegex(String peripheralRegex) {
        this.peripheralRegex = peripheralRegex == null ? null : peripheralRegex.trim();
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex == null ? null : regex.trim();
    }

    public String getRegexGroupId() {
        return regexGroupId;
    }

    public void setRegexGroupId(String regexGroupId) {
        this.regexGroupId = regexGroupId == null ? null : regexGroupId.trim();
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath == null ? null : xpath.trim();
    }

    public Short getEnabled() {
        return enabled;
    }

    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }

    public Short getUrlWithLoop() {
        return urlWithLoop;
    }

    public void setUrlWithLoop(Short urlWithLoop) {
        this.urlWithLoop = urlWithLoop;
    }

    public String getLoopStart() {
        return loopStart;
    }

    public void setLoopStart(String loopStart) {
        this.loopStart = loopStart == null ? null : loopStart.trim();
    }

    public String getLoopEnd() {
        return loopEnd;
    }

    public void setLoopEnd(String loopEnd) {
        this.loopEnd = loopEnd == null ? null : loopEnd.trim();
    }

    public String getLoopVar() {
        return loopVar;
    }

    public void setLoopVar(String loopVar) {
        this.loopVar = loopVar == null ? null : loopVar.trim();
    }

    public Integer getLoopStep() {
        return loopStep;
    }

    public void setLoopStep(Integer loopStep) {
        this.loopStep = loopStep;
    }

    public String getLoopFormat() {
        return loopFormat;
    }

    public void setLoopFormat(String loopFormat) {
        this.loopFormat = loopFormat == null ? null : loopFormat.trim();
    }

    public Short getLoopVarType() {
        return loopVarType;
    }

    public void setLoopVarType(Short loopVarType) {
        this.loopVarType = loopVarType;
    }

    public String getLoopSample() {
        return loopSample;
    }

    public void setLoopSample(String loopSample) {
        this.loopSample = loopSample == null ? null : loopSample.trim();
    }

    public String getTestUrl() {
        return testUrl;
    }

    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl == null ? null : testUrl.trim();
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
}