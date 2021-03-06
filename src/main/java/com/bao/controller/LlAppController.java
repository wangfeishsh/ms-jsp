/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bao.controller;

import com.alibaba.fastjson.JSON;
import com.bao.constant.PaymentConstant;
import com.bao.model.CommonApplyRequest;
import com.bao.model.PayStrategy;
import com.bao.model.ResponseResult;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ll/app")
public class LlAppController {

    @GetMapping
    public ModelAndView apply() {

        CommonApplyRequest request = new CommonApplyRequest();
        request.setProductId("1");
        request.setProductType("test");
        request.setUserId("7707962");
        request.setRealName("test");
        request.setPlatformFee("0");
        request.setIsNonFee(Boolean.TRUE);
        request.setTransNo("123456");
        request.setTotalAmount("0.01");
        request.setIsFirstCardPay(Boolean.FALSE);
        PayStrategy payStrategy = new PayStrategy();
        payStrategy.setStrategy(PaymentConstant.STRATEGY_APP);
        payStrategy.setProvider(PaymentConstant.PROVIDER_LL);
        payStrategy.setAmount("0.01");
        List<PayStrategy> list = new ArrayList<>();
        list.add(payStrategy);
        request.setData(list);

        //gson与json转化decimal时候都有精度失真情况
        Gson gson = new Gson();

		System.out.println("==="+JSON.toJSONString(request));
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<String> requestEntity = new HttpEntity<>(JSON.toJSONString(request), headers);
        ResponseResult<Map> responseResult =
                restTemplate.postForObject("http://localhost:8080/v1/recharge/apply", requestEntity, ResponseResult.class);

//		Client client = ClientBuilder.newClient(new ClientConfig());
//		Entity<CommonApplyRequest> entity = Entity.entity(request,MediaType.APPLICATION_JSON_TYPE);
//		ResponseResult responseResult = client.target("http://localhost:8080/")
//				.path("v1/recharge/apply")
//				.request(MediaType.APPLICATION_JSON)
//				.post(entity, ResponseResult.class);
        Map dataMap = responseResult.getData();
        System.out.println(dataMap.get("formMap"));
        Map map =(Map) dataMap.get("formMap");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<div style=\"text-align:center\">正在提交订单...<form  method=\"post\" action=\"");
        stringBuffer.append(map.get("payUrl"));
        stringBuffer.append("\">");
        map.forEach((key, value) -> {
            stringBuffer.append("<input type=\"hidden\" name=\""+key+"\" value=\""+value+"\"/>");
        });
        stringBuffer.append("<input type=\"submit\" ")
        .append("name=\"submit\" value='提交到连连' ")
        .append("id=\"dh\" style=\"display:none\">");
        stringBuffer.append("<script>var a=document.getElementById(\"dh\");a.click();</script></form></div>");
        String html = stringBuffer.toString();
        return new ModelAndView("kq", "model", html);
    }

}
