package com.bao.util;

import com.alibaba.fastjson.JSON;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * Created by liuguobin on 2017/3/10.
 */
public class ClientUtil {

    public static Map post(String path, Map<String, Object> map) {

        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
            StringBuilder sb = new StringBuilder();
            map.entrySet().forEach(en -> {
                sb.append(en.getKey())
                        .append("=")
                        .append(en.getValue())
                        .append("&");
            });
            String s = sb.substring(0, sb.lastIndexOf("&"));

            // 发送请求参数
            printWriter.write(s);//post的参数 xx=xx&yy=yy
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            String result = bos.toString("utf-8");
            Map resultMap = (Map)JSON.parse(result);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
