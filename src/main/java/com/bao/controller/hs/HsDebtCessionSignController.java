package com.bao.controller.hs;

import com.alibaba.fastjson.JSONObject;
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
@RequestMapping("/hs/debtCessionSign")
public class HsDebtCessionSignController {
    @GetMapping
    public ModelAndView apply(String json) {

//        Map<String,String> formMap = new LinkedHashMap();
//        formMap.put("TRXDATE", DateUtil.getCurrentDate());//交易日期
//        formMap.put("TRXTIME", DateUtil.getCurrentTime());//交易时间
//        formMap.put("BANKCODE", "30040000");//银行代码
//        formMap.put("COINSTCODE", "000113");//合作单位编号
//        formMap.put("COINSTCHANNEL", "000002");//合作单位渠道
//
//        formMap.put("CARDNBRI", accountNoI);//承接方电子账号
//        formMap.put("SERI_NO", IdBuilder.getSeqNo());//申请流水号
//        formMap.put("OLDSEQNO", oldSeqNo);//原交易申请流水号
//        formMap.put("CARDNBRO", accountNoO);//转让方电子账号
//        formMap.put("TBALACE", tBalace);//总共可转让金额
//        formMap.put("AMOUNT", amount);//转让金额
//        formMap.put("TRPRICE", trPrice);//转让价格
//        formMap.put("INTDATE", intDate);//起息日
//        formMap.put("YIELD", yield);//转让后预期年化收益率
//        formMap.put("FEEWAY", feeWay);//手续费扣费方式
//        formMap.put("FEE", fee);//转让手续费
//        formMap.put("REMARK", "债转");//备注
//        formMap.put("TRDRESV", "");//第三方保留域
//        formMap.put("FORGERPWD_URL", "http://www.baidu.com");//忘记密码跳转链接
//        formMap.put("TRANSACTION_URL", "http://180.169.28.214:8080/pay-app/v1/provider/banks?provider=KQ");//返回交易页面链接
//        formMap.put("REBACK_URL", "http://180.169.28.214:8080/pay-app/callback/p2p/debtCessionSign");//后台响应链接
//        formMap.put("SUCCESSRESULT_URL", "http://180.169.28.214:8080/pay-app/monitor");//交易成功跳转链接
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
//        formMap.put("payUrl", "https://onlineuat.cupdata.com:50005/dbesbuat/app/to/debtCessionSign");
//
//        return new ModelAndView("jump", "model", formMap);

        Map requireMap = JSONObject.parseObject(json,Map.class);

        Map resultMap = ClientUtil.post("http://192.168.1.128:8080/pay-app/v1/p2p/debt/autoDebtCession", requireMap);

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
