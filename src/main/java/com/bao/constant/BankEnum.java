package com.bao.constant;

/**
 * Created by baochunyu on 2016/8/6.
 */
public enum BankEnum {

    GDB("广东发展银行","03060000","3036"),
    HXB("华夏银行","03040000","3050"),
    BOCOM("交通银行","03010000","3020"),
    PAB("平安银行","03070000","3035"),
    SPDB("上海浦东发展银行","03100000","3004"),
    CMB("招商银行","03080000","3001"),
    CIB("兴业银行","03090000","3009"),
    ICBC("中国工商银行","01020000","3002"),
    CEB("中国光大银行","03030000","3022"),
    CCB("中国建设银行","01050000","3003"),
    CMBC("中国民生银行","03050000","3006"),
    ABC("中国农业银行","01030000","3005"),
    BOC("中国银行","01040000","3026"),
    PSBC("中国邮政储蓄银行","01000000","3038"),
    SHB("上海银行","04012900","3059"),
    CITIC("中信银行","03020000","3039"),
    SRCB("上海农商银行","","3037"),
    BOB("北京银行","",""),
    CBHB("渤海银行","",""),
    SDB("深圳发展银行","","");

    private String bankName;
    private String uniCode;
    private String bfUniCode;

    BankEnum(String bankName, String uniCode, String bfUniCode) {
        this.bankName = bankName;
        this.uniCode = uniCode;
        this.bfUniCode = bfUniCode;
    }

    public static boolean isSupportBankCode(String bankCode) {
        for (BankEnum bankEnum : BankEnum.values()) {
            if (bankCode.equals(bankEnum.name())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupportBankName(String bankName) {
        for (BankEnum bankEnum : BankEnum.values()) {
            if (bankName.equals(bankEnum.bankName)) {
                return true;
            }
        }
        return false;
    }

    public static String getUniCode(String bankCode) {
        for (BankEnum bankEnum : BankEnum.values()) {
            if (bankCode.equals(bankEnum.name())) {
                return bankEnum.uniCode;
            }
        }
        return "";
    }

    public static String getBankName(String bankCode) {
        for (BankEnum bankEnum : BankEnum.values()) {
            if (bankCode.equals(bankEnum.name())) {
                return bankEnum.bankName;
            }
        }
        return "";
    }

    public static String getBfUniCode(String bankCode) {
        for (BankEnum bankEnum : BankEnum.values()) {
            if (bankCode.equals(bankEnum.name())) {
                return bankEnum.bfUniCode;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(BankEnum.getBfUniCode("SHRCB"));
    }

    public String getBankName() {
        return bankName;
    }

    public String getUniCode() {
        return uniCode;
    }

    public String getBfUniCode() {
        return bfUniCode;
    }
}
