package com.bao.controller.hs;

import com.alibaba.fastjson.JSONObject;
import com.bao.util.ClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Copyright (c) www.nonobank.com. All Rights Reserved.
 *
 * @version 1.0 16/12/27 上午10:02 by zucker (chenzhang@nonobank.com)
 */
@Controller
@RequestMapping("/hs/trusteePay")
public class HsTrustPayController {


    @GetMapping
    public ModelAndView apply(String json) {
        Map requireMap = JSONObject.parseObject(json,Map.class);

//        Map resultMap = ClientUtil.post("http://192.168.1.128:8081/pay-app/v1/p2p/acc/withdrawAudit", requireMap);
        Map resultMap = ClientUtil.post("http://localhost:8081/pay-app/v1/p2p/product/trusteePaySign", requireMap);
//        Map resultMap = ClientUtil.post("http://192.168.3.176:8083/pay-app/v1/p2p/fin/withdrawAudit", requireMap);

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
