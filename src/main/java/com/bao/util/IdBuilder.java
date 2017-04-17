package com.bao.util;


/**
 * Created by user on 16/8/23.
 */
public class IdBuilder {

//    //与帐户系统交互
//    public static String getProofId() {
//        //+2位业务编号--98--无特殊意义
//        int i = (int) ((1 + Math.random() * 9) * 100000);
//        return PaymentConstant.PAY_APP_CODE + PaymentConstant.PAY_APP_SUB_CODE + "98" + DateUtil.getCurrentMillisDateString() + String.valueOf(i);
//    }
//
//    public static String getId(String orderType) {
//        //+2位业务编号
//        int i = (int) ((1 + Math.random() * 9) * 100000);
//        return PaymentConstant.PAY_APP_CODE + PaymentConstant.PAY_APP_SUB_CODE + getTransCode(orderType) + DateUtil.getCurrentMillisDateString() + String.valueOf(i);
//    }
//
//    public static String getTransCode(String orderType) {
//        if (PaymentConstant.ORDER_TYPE_AUTH_NON_FINANCE.equals(orderType)) {
//            return "01";
//        }
//        if (PaymentConstant.ORDER_TYPE_AUTH_FINANCE.equals(orderType)) {
//            return "02";
//        }
//        if (PaymentConstant.ORDER_TYPE_AUTH_CANCEL.equals(orderType)) {
//            return "03";
//        }
//        if (PaymentConstant.ORDER_TYPE_RECHARGE.equals(orderType)) {
//            return "04";
//        }
//        if (PaymentConstant.ORDER_TYPE_PAY_COMBINED.equals(orderType)) {
//            return "05";
//        }
//        return "99";
//    }

    /**
     * 按存管行的要求商户按规则生成。YYYYMMDD+ hhmmss+6位随机数，
     * //TODO 此处留坑，当并发上来之后，如果seqno经常碰撞需要对seqno做唯一性处理。
     * @return
     */
    public static String getSeqNo() {
        int i = (int) ((1 + Math.random() * 9) * 100000);
        return DateUtil.getCurrentDateString() + i;
    }

    public static String getBiaoId() {
        //+2位业务编号
        int i = (int) ((1 + Math.random() * 9) * 100000);
        return String.valueOf(i);
    }

}
