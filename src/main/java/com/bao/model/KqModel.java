package com.bao.model;

import lombok.Data;

/**
 * Created by user on 16/9/18.
 */
@Data
public class KqModel {
    private String inputCharset;//编码方式，1代表 UTF-8; 2 代表 GBK; 3代表 GB2312 默认为1,该参数必填。
    private String pageUrl;//接收支付结果的页面地址，该参数一般置为空即可。
    private String bgUrl;//服务器接收支付结果的后台地址，该参数务必填写，不能为空。
    private String version;//网关版本，固定值：v2.0,该参数必填。
    private String language;//语言种类，1代表中文显示，2代表英文显示。默认为1,该参数必填。
    private String signType;//签名类型,该值为4，代表PKI加密方式,该参数必填。
    private String merchantAcctId; //人民币网关账号，该账号为11位人民币网关商户编号+01,该参数必填。
    private String payerName;
    private String payerContactType;
    private String payerContact;
    private String payerIdType;
    private String payerId;
    private String payerIP;
    private String orderId;
    private String orderAmount;
    private String orderTime;
    private String orderTimestamp;
    private String productName;
    private String productNum;
    private String productId;
    private String productDesc;
    private String ext1;
    private String ext2;
    private String payType;
    private String bankId;
    private String cardIssuer;
    private String cardNum;
    private String remitType;
    private String remitCode;
    private String redoFlag;
    private String pid;
    private String submitType;
    private String orderTimeOut;
    private String extDataType;
    private String extDataContent;

}
