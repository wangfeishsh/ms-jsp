package com.bao.constant;


/**
 * Created by baochunyu on 2016/8/1.
 */
public class PaymentConstant {

    public final static String PAY_APP_CODE = "05";
    public final static String PAY_APP_NAME = "PAY";
    public final static String PAY_APP_SUB_CODE = "00";

    //交易类型
    public final static String TRANS_TYPE_AUTH_APPLY = "authApply"; //绑卡（鉴权）申请--支持三要素、四要素
    public final static String TRANS_TYPE_AUTH_CONFIRM = "authConfirm"; //绑卡（鉴权）确认
    public final static String TRANS_TYPE_AUTH_CANCEL = "authCancel"; //解约
    public final static String TRANS_TYPE_BIND_CARD_AND_PAY_APPLY = "bindCardAndPayApply";//绑卡并支付申请
    public final static String TRANS_TYPE_BIND_CARD_AND_PAY_CONFIRM = "bindCardAndPayConfirm";//绑卡并支付确认
    public final static String TRANS_TYPE_PAY_APPLY = "payApply";//代收申请
    public final static String TRANS_TYPE_PAY_CONFIRM = "payConfirm";//代收确认
    public final static String TRANS_TYPE_WITHDRAW_APPLY = "withDrawApply";//代扣申请
    public final static String TRANS_TYPE_WITHDRAW_CONFIRM = "withDrawConfirm";//代扣确认
    public final static String TRANS_TYPE_QUERY_PAY = "queryPay";//查询代收结果
    public final static String TRANS_TYPE_QUERY_WITHDRAW = "queryWithDraw";//查询代付结果
    //渠道提供方
    public final static String PROVIDER_KQ = "KQ"; //快钱
    public final static String PROVIDER_SFT = "SFT";//盛付通
    public final static String PROVIDER_YL = "YL"; //易连
    public final static String PROVIDER_YB = "YB"; //易宝
    public final static String PROVIDER_LL = "LL"; //连连
    public final static String PROVIDER_BF = "BF"; //宝付
    public final static String PROVIDER_QF = "QF"; //钱方
    public final static String PROVIDER_SELF = "SELF"; //平台

    //支付方式
    public final static String STRATEGY_WEB = "web"; //web支付
    public final static String STRATEGY_ONLINE = "online"; //网银
    public final static String STRATEGY_FAST = "fast"; //快捷
    public final static String STRATEGY_WX_CODE = "wxCode"; //微信扫码
    public final static String STRATEGY_BALANCE = "balance"; //余额
    public final static String STRATEGY_WALLET = "wallet"; //钱包
    public final static String STRATEGY_COUPON = "coupon"; //券
    public final static String STRATEGY_WAP = "wap"; //wap支付
    public final static String STRATEGY_APP = "app"; //app支付(移动端sdk)

    public static final String MESSAGE_PATH = "/messages/msg_zh_CN.properties";

    //订单类型
    public static final String ORDER_TYPE_RECHARGE = "recharge";
    public static final String ORDER_TYPE_PAY_COMBINED = "payCombined";
    public static final String ORDER_TYPE_AUTH_FINANCE = "authFinance";
    public static final String ORDER_TYPE_AUTH_NON_FINANCE = "authNonFinance";
    public static final String ORDER_TYPE_AUTH_CANCEL = "authCancel";

    //系统订单状态
    public static final String ORDER_STATUS_INIT = "DRAFT";
    public static final String ORDER_STATUS_APPLY = "APPLY";
    public static final String ORDER_STATUS_PAYING = "PROCESSING";
    public static final String ORDER_STATUS_SUCCESS = "PAID";
    public static final String ORDER_STATUS_FAIL = "FAILED";
    //系统支付状态
    public static final String PAY_STATUS_INIT = "DRAFT";
    public static final String PAY_STATUS_APPLY = "APPLY";
    public static final String PAY_STATUS_PAYING = "PROCESSING";
    public static final String PAY_STATUS_SUCCESS = "PAID";
    public static final String PAY_STATUS_FAIL = "FAILED";
    //系统账户状态
    public static final String ACC_STATUS_INIT = "INIT";
    public static final String ACC_STATUS_FROZEN = "FROZEN";
    public static final String ACC_STATUS_UNFROZEN = "UNFROZEN";
    public static final String ACC_STATUS_FAIL = "FAIL";
    //是否需要验证码
    public static final String NEED_SMS_CODE_YES = "yes";
    public static final String NEED_SMS_CODE_NO = "no";
    public static final String NEED_SMS_CODE_UNCERTAIN = "uncertain";

    //鉴权状态
    public static final String AUTH_STATUS_YES = "success";//成功
    public static final String AUTH_STATUS_NO = "no";//未开通
    public static final String AUTH_STATUS_CANCEL = "cancel";//解约
    public static final String AUTH_STATUS_FAIL = "fail";//失败


    public static final String KQ_RETURN_SUCCESS = "00";//块钱返回成功code
    public static final String KQ_RETURN_ERRO_MESSAGE = "第三方返回错误";//块钱返回成功code
    public static final String KQ_MSG_C0 = "C0";//块钱返回错误码

    //自定义签约解约产品Id与类型
    public static final String PRODUCT_ID_AUTH_APPLY = "6";
    public static final String PRODUCT_ID_AUTH_CANCEL = "7";
    public static final String PRODUCT_ID_RECHARGE = "8";//TODO
    public static final String PRODUCT_TYPE_AUTH_APPLY = "AUTO_AUTH";
    public static final String PRODUCT_TYPE_AUTH_CANCEL = "CANCEL_AUTH";
    public static final String PRODUCT_TYPE_RECHARGE = "RECHARGE";
    public static final String PRODUCT_TYPE_FINANCE_PLAN = "FINANCE_PLAN";

    //支付操作类型
    public static final String PAY_OPERATION_APPLY = "APPLY";
    public static final String PAY_OPERATION_CONFIRM = "CONFIRM";


    //证件类型
    public static final String CREDENTIALS_ID_CARD = "idCard"; //身份证

    //银行卡类型
    public static final String BANK_CARD_CREDIT = "credit"; //信用卡
    public static final String BANK_CARD_DEPOSIT = "deposit"; //储蓄卡
    public static final String BANK_CARD_DEBIT = "debit"; //借记卡


    //与第三方交易通讯纪录状态
    public static final String STATUS_INIT = "INIT"; //初始化
    public static final String STATUS_USED = "USED"; //已使用


    //support 代表此渠道是否支持此银行  0-否 1-是
    //supportType 代表此渠道是否支持直接绑卡 1-是消费鉴权 2-支持非消费鉴权
    public static final String PROVIDER_SUPPORT_BANK = "1";
    public static final String PROVIDER_NOT_SUPPORT_BANK = "0";
    public static final String IS_FINANCE_AUTH = "1";
    public static final String IS_NON_FINANCE_AUTH = "2";


    //mq
    public static final String MQ_PAY_GROUP="pay_group";
    public static final String MQ_TOPIC_ACC="pay_topic_acc";
    public static final String MQ_TAG_RECHARGE="recharge";
    public static final String MQ_TAG_AUTH_RECHARGE="authAndRecharge";
    public static final String MQ_TAG_AUTH_PAY_FROZEN="authAndPayAndFrozen";
    public static final String MQ_TAG_PAY_FROZEN="payAndFrozen";


}
