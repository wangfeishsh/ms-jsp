package com.bao.model;

import lombok.Data;

/**
 * Created by user on 16/8/22.
 */
public class CommonApplyResult {

    private String transNo;//交易号
    private String orderNo;//  支付订单号
    private String token;//令牌
    private String bankCardShortNo ;// 短卡号
    private String bindId;//  宝付绑定Id
    private String smsCode;//短信校验码

    private String html; //网银界面

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBankCardShortNo() {
        return bankCardShortNo;
    }

    public void setBankCardShortNo(String bankCardShortNo) {
        this.bankCardShortNo = bankCardShortNo;
    }

    public String getBindId() {
        return bindId;
    }

    public void setBindId(String bindId) {
        this.bindId = bindId;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
