package com.bao.controller.hs;

import com.alibaba.fastjson.JSONObject;
import com.bao.util.Base64Util;
import com.bao.util.ClientUtil;
import com.bao.util.DateUtil;
import com.bao.util.SignatureUtil;
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
 * @version 1.0 16/12/26 下午5:14 by zucker (chenzhang@nonobank.com)
 */
@Controller
@RequestMapping("/hs/pinsetting")
public class HsPinSettingController {

    @GetMapping
    public ModelAndView apply(String json) {

//        Map formMap = new LinkedHashMap();
//        formMap.put("VERSION", "1.1");//接口版本号
//        formMap.put("TRXDATE", DateUtil.getCurrentDate());//交易日期
//        formMap.put("TRXTIME", DateUtil.getCurrentTime());//交易时间
//        formMap.put("CARDNBR", accountNo);//账户
//        formMap.put("IDNO", idNo);//证件号码
//        formMap.put("IDTYPE", "01");//证件类型
//        formMap.put("PHONE", mobile);//手机号码
//        formMap.put("NAME", name);//姓名
//        formMap.put("BANKCODE", "30040000");//银行代码
//        formMap.put("RESETPWD_SURL", "http://180.169.28.214:8080/pay-app/monitor");//密码设置成功跳转链接
//        formMap.put("RESETPWD_FURL", "http://180.169.28.214:8080/pay-app/v1/provider/banks?provider=KQ");//密码设置失败跳转链接
//        formMap.put("BACKGROUND_URL", "http://180.169.28.214:8080/pay-app/callback/p2p/pinsettingSign");//后台响应链接
//        formMap.put("COINSTCODE", "000113");//合作单位编号
//        formMap.put("COINSTCHANNEL", "000002");//合作单位渠道
//
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
//        formMap.put("payUrl", "https://onlineuat.cupdata.com:50005/dbesbuat/app/to/pinsettingSign");
//
//        return new ModelAndView("jump", "model", formMap);

        Map requireMap = JSONObject.parseObject(json,Map.class);

//        Map resultMap = ClientUtil.post("http://192.168.1.128:8081/pay-app/v1/p2p/acc/pinSetting", requireMap);
//        Map resultMap = ClientUtil.post("http://localhost:8081/pay-app/v1/p2p/acc/pinSetting", requireMap);
        Map resultMap = ClientUtil.post("http://192.168.3.176:8083/pay-app/v1/p2p/acc/pinSetting", requireMap);

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
