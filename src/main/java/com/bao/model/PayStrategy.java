package com.bao.model;

import lombok.Data;

/**
 * Created by baochunyu on 2016/7/29.
 */

public class PayStrategy {

    private String strategy;// 支付方式(网银、快捷、扫码、钱包、现金券、加息券)
    private String couponId;//券Id
    private String couponCode;//券码
    private String couponType;//券类型
    private String bankCardType;// 银行卡类型
    private String bankCardNo;// 银行卡号
    private String bankCardShortNo;//  银行卡短卡号
    private String bankName;// 银行名称
    private String bankCode;// 银行编号
    private String bankId;// 银行卡记录Id
    private String provider;// 渠道提供商
    private String amount;// 金额
    private String rate;// 加息减息率
    private String providerFee;//渠道费用
    private String frontUrl;// 前端回调地址（网银扫码必传）
    private Boolean isNeedSmsCode;// 是否需要短信验证码

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankCardShortNo() {
        return bankCardShortNo;
    }

    public void setBankCardShortNo(String bankCardShortNo) {
        this.bankCardShortNo = bankCardShortNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getProviderFee() {
        return providerFee;
    }

    public void setProviderFee(String providerFee) {
        this.providerFee = providerFee;
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl;
    }

    public Boolean getIsNeedSmsCode() {
        return isNeedSmsCode;
    }

    public void setIsNeedSmsCode(Boolean needSmsCode) {
        isNeedSmsCode = needSmsCode;
    }
}
