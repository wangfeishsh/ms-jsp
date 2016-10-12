package com.bao.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by user on 16/9/19.
 */
public class GsonUtil {

//    public static Gson gson = instance();
//
//    public static Gson instance(){
//        GsonBuilder builder=new GsonBuilder();
//        builder.registerTypeAdapter(BigDecimal.class, new BigDecimalTypeAdapter());
//        Gson gson=builder.create();
//        return gson;
//    }
//
//    public static String toJson(Object o){
//        return gson.toJson(o);
//    }
//
//    static class BigDecimalTypeAdapter implements JsonSerializer<BigDecimal> {
//
//        @Override
//        public JsonElement serialize(BigDecimal d, Type type,
//                                     JsonSerializationContext context) {
//            DecimalFormat format=new DecimalFormat("##0.00");
//            String temp=format.format(d);
//            System.out.println(temp);
//            JsonPrimitive pri=new JsonPrimitive(temp);
//            return pri;
//        }
//
//    }

}
