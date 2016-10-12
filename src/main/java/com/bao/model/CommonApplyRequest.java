package com.bao.model;

import lombok.Data;

import java.util.List;

/**
 * Created by user on 16/8/22.
 */
public class CommonApplyRequest {

    private String userId;
    private String realName;// 用户名称
    private String mobile;//手机号
    private String cardType;//证件类型
    private String cardNo;//证件号
    private String productId;// 产品Id
    private String productType;// 产品类型
    private String platformType;// 平台来源
    private String platformFee;// 平台费用
    private Boolean isNonFee;// 是否免平台费用
    private Boolean isFirstCardPay;// 是否第一次卡支付
    private String transNo;//  交易号
    private String totalAmount;//  交易总金额
    private String provinceCode;//卡省份
    private String cityCode;//卡市区

    private String needSmsCode;//是否需要验证码 0-否 1-是 2-不确定
    private String orderType;//订单类型--充值、组合支付、提现、金融签约、非金融签约、解约
    private List<PayStrategy> data;

    private String wapBgColor;
    private String wapFontColor;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getPlatformFee() {
        return platformFee;
    }

    public void setPlatformFee(String platformFee) {
        this.platformFee = platformFee;
    }

    public Boolean getIsNonFee() {
        return isNonFee;
    }

    public void setIsNonFee(Boolean nonFee) {
        isNonFee = nonFee;
    }

    public Boolean getIsFirstCardPay() {
        return isFirstCardPay;
    }

    public void setIsFirstCardPay(Boolean firstCardPay) {
        isFirstCardPay = firstCardPay;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getNeedSmsCode() {
        return needSmsCode;
    }

    public void setNeedSmsCode(String needSmsCode) {
        this.needSmsCode = needSmsCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public List<PayStrategy> getData() {
        return data;
    }

    public void setData(List<PayStrategy> data) {
        this.data = data;
    }

    public String getWapBgColor() {
        return wapBgColor;
    }

    public void setWapBgColor(String wapBgColor) {
        this.wapBgColor = wapBgColor;
    }

    public String getWapFontColor() {
        return wapFontColor;
    }

    public void setWapFontColor(String wapFontColor) {
        this.wapFontColor = wapFontColor;
    }
}
