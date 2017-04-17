package com.bao.controller.hs;

import com.alibaba.fastjson.JSONObject;
import com.bao.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 * @version 1.0 16/12/27 上午10:03 by zucker (chenzhang@nonobank.com)
 */
@Controller
@RequestMapping("/hs/autoBidApply")
public class HsAutoBidApplyController {

    @GetMapping
    public ModelAndView apply(String json) {
//        Map formMap = new LinkedHashMap();
//        formMap.put("TRXDATE", DateUtil.getCurrentDate());//交易日期
//        formMap.put("TRXTIME", DateUtil.getCurrentTime());//交易时间
//        formMap.put("BANKCODE", "30040000");//银行代码
//        formMap.put("COINSTCODE", "000113");//合作单位编号
//        formMap.put("COINSTCHANNEL", "000002");//合作单位渠道
//        formMap.put("CARDNBR", accountNo);//账户
//
//        formMap.put("SERI_NO", IdBuilder.getSeqNo());//签约交易流水号
//        formMap.put("AMOUNT", amount);//签约最高金额
//        formMap.put("REMARK", "");//备注
//        formMap.put("FORGERPWD_URL", "");//忘记密码跳转链接
//        formMap.put("TRANSACTION_URL", "http://180.169.28.214:8080/pay-app/v1/provider/banks?provider=KQ");//返回交易页面链接
//        formMap.put("REBACK_URL", "http://180.169.28.214:8080/pay-app/callback/p2p/autoBidApplySign");//后台响应链接
//        formMap.put("SUCCESSRESULT_URL", "http://180.169.28.214:8080/pay-app/monitor");//交易成功跳转链接
//
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
//        formMap.put("payUrl", "https://onlineuat.cupdata.com:50005/dbesbuat/app/to/autoBidApplySign");
//        return new ModelAndView("jump", "model", formMap);


        Map requireMap = JSONObject.parseObject(json,Map.class);

//        Map resultMap = ClientUtil.post("http://192.168.1.128:8081/pay-app/v1/p2p/acc/bid/auto/contract/sign", requireMap);
        Map resultMap = ClientUtil.post("http://localhost:8081/pay-app/v1/p2p/acc/bid/auto/contract/sign", requireMap);

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
