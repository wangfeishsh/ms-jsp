package com.bao.controller.hs;

import com.bao.util.Base64Util;
import com.bao.util.DateUtil;
import com.bao.util.IdBuilder;
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
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 * Copyright (c) www.nonobank.com. All Rights Reserved.
 *
 * @version 1.0 16/12/27 上午10:02 by zucker (chenzhang@nonobank.com)
 */
@Controller
@RequestMapping("/hs/bidApply")
public class HsBidApplyController {
    @GetMapping
    public ModelAndView apply(String accountNo,String amount,
                              String product,String intDate,
                              String intType,String intPayDay,
                              String endDate, String yield,
                              String bosAmtYn ,String bosAmt) {

        Map formMap = new LinkedHashMap();
        formMap.put("VERSION", "1.1");//接口版本号
        formMap.put("TRXDATE", DateUtil.getCurrentDate());//交易日期
        formMap.put("TRXTIME", DateUtil.getCurrentTime());//交易时间
        formMap.put("BANKCODE", "30040000");//银行代码
        formMap.put("COINSTCODE", "000113");//合作单位编号
        formMap.put("COINSTCHANNEL", "000002");//合作单位渠道
        formMap.put("CARDNBR", accountNo);//账户

        formMap.put("SERI_NO", IdBuilder.getSeqNo());//申请流水号
        formMap.put("AMOUNT", amount);//投标金额
        formMap.put("FUISSUER", "A1");//产品发行方
        formMap.put("PRODUCT", product);//标的编号
        formMap.put("INTDATE", intDate);//起息日
        formMap.put("INTTYPE", intType);//付息方式
        formMap.put("INTPAYDAY", intPayDay);//利息每月支付日
        formMap.put("ENDDATE", endDate);//产品到期日
        formMap.put("YIELD", yield);//预期年化收益率
        formMap.put("FRZFLAG", "1");//是否冻结金额
        formMap.put("BOSAMT_YN", bosAmtYn);//是否使用红包
        formMap.put("BOSAMT", bosAmt);//抵扣红包金额
        formMap.put("REMARK", "投标");//备注
        formMap.put("TRDRESV", "");//第三方保留域
        formMap.put("FORGERPWD_URL", "");//忘记密码跳转链接
        formMap.put("TRANSACTION_URL", "http://180.169.28.214:8080/pay-app/v1/provider/banks?provider=KQ");//返回交易页面链接
        formMap.put("REBACK_URL", "http://180.169.28.214:8080/pay-app/callback/p2p/bidApplySign");//后台响应链接

        //签名
        StringBuffer sb = new StringBuffer();
        formMap.forEach((k,v)->{
            if(!StringUtils.isEmpty(sb)){
                sb.append(v);
            }
        });

        PrivateKey privateKey = null;
        try (InputStream is = new FileInputStream("/JAVA_Files/pay/ssl/kq/sign_.key")) {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(
                    new PKCS8EncodedKeySpec(
                            Base64Util.decodeToByte(
                                    StreamUtils.copyToString(is, Charset.forName("UTF-8")))));
        } catch (Exception e) {
            e.getStackTrace();
        }



        String signData = SignatureUtil.signatureWithMD5(sb.toString(),privateKey,"UTF-8");


        formMap.put("SIGN", signData);//签名
        formMap.put("payUrl", "https://onlineuat.cupdata.com:50005/dbesbuat/app/to/bidApplySign");
        return new ModelAndView("jump", "model", formMap);
    }
}
