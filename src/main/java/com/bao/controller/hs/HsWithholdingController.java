package com.bao.controller.hs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.bao.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 * Copyright (c) www.nonobank.com. All Rights Reserved.
 *
 * @version 1.0 16/12/27 上午10:02 by zucker (chenzhang@nonobank.com)
 */
@Controller
@RequestMapping("/hs/withholding")
public class HsWithholdingController {


    @GetMapping
    public ModelAndView apply(String json) {

//        Map formMap = new LinkedHashMap();
//        formMap.put("VERSION", "1.1");//接口版本号
//        formMap.put("ORDERNO", IdBuilder.getSeqNo());//订单编号
////        formMap.put("ORDERNO", "05000120170208211445926622753");//订单编号
//        formMap.put("TRXDATE", DateUtil.getCurrentDate());//交易日期
//        formMap.put("TRXTIME", DateUtil.getCurrentTime());//交易时间
//        formMap.put("BANKCODE", "30040000");//银行代码
//        formMap.put("COINSTCODE", "000113");//合作单位编号
//        formMap.put("COINSTCHANNEL", "000002");//合作单位渠道
//        formMap.put("CARDNBR", accountNo);//账户
//
//        formMap.put("BANKNAME", bankName);//银行名称
//        formMap.put("CARD_BIND", bankCardNo);//绑定卡号
//        formMap.put("NAME", name);//姓名
//        formMap.put("IDNO", idNo);//证件号码
//        formMap.put("IDTYPE", "01");//证件类型
//        formMap.put("PHONE", mobile);//手机号码
//        formMap.put("AMOUNT", amount);//提现金额
//        formMap.put("FEE", fee);//手续费
//        formMap.put("FORGERPWD_URL", "http://www.baidu.com");//忘记密码跳转链接
//        formMap.put("BACKGROUND_URL", "http://180.169.28.214:8080/pay-app/callback/hs/withholdingSign");//后台响应链接
//        formMap.put("TRANSACTION_URL", "http://180.169.28.214:8080/pay-app/monitor");//交易页面跳转链接
//        formMap.put("ROUT_FLAG", "N");//是否指定通道
//        formMap.put("ROUT_CODE", "");//通道标识
//        formMap.put("BANK_CNAPS", "");//开户银行联行号
//        formMap.put("BANK_CODE", "");//开户银行代码
//        formMap.put("BANK_NAME_EN", "");//开户银行英文缩写
//        formMap.put("BANK_NAME_CN", "");//开户银行中文名称
//        formMap.put("ISS_BANK_PROVINCE", "");//开户行省份
//        formMap.put("ISS_BANK_CITY", "");//开户行城市
//        //签名
//        StringBuffer sb = new StringBuffer();
//        formMap.forEach((k,v)->{
//            if(!StringUtils.isEmpty(sb)){
//                sb.append(v);
//            }
//        });
//
//        PrivateKey privateKey = null;
//        try (InputStream is = new FileInputStream("/JAVA_Files/pay/ssl/kq/sign_.key")) {
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            privateKey = keyFactory.generatePrivate(
//                    new PKCS8EncodedKeySpec(
//                            Base64Util.decodeToByte(
//                                    StreamUtils.copyToString(is, Charset.forName("UTF-8")))));
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//
//
//
//        String signData = SignatureUtil.signatureWithMD5(sb.toString(),privateKey,"UTF-8");
//
//
//        formMap.put("SIGN", signData);//签名
//
//        formMap.put("payUrl", "https://onlineuat.cupdata.com:50005/dbesbuat/app/to/withholdingSign");
//        return new ModelAndView("jump", "model", formMap);

        Map requireMap = JSONObject.parseObject(json,Map.class);

        Map resultMap = ClientUtil.post("http://localhost:8080/pay-app/v1/p2p/fin/withdrawAudit", requireMap);

//        requireMap.put("SIGN", );//签名
        boolean suc = (boolean) resultMap.get("succeed");
        if (suc) {
            Map postMap = new HashMap();
            Map data = (Map)resultMap.get("data");
            Map formData = (Map)data.get("formData");
            formData.put("payUrl", data.get("targetUrl")); //"https://onlineuat.cupdata.com:50005/dbesbuat/app/to/autoBidApplySign\""
            return new ModelAndView("jump", "model", formData);
        }

        return null;
    }


}
