package com.bao.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * Created by chenzhang on 2016/9/26.
 */
public class SignatureUtil {
    private static final Logger logger = LoggerFactory.getLogger(SignatureUtil.class);

    private static final String SIGNATURE_SHA1 = "SHA1withRSA";
    private static final String SIGNATURE_MD5 = "MD5withRSA";

    public static String signatureWithSHA1(String content, PrivateKey privateKey,String charset){
        String base64 = "";
        try {
            Signature signature = Signature.getInstance(SIGNATURE_SHA1);

            signature.initSign(privateKey);
            signature.update(content.getBytes(charset));
            base64 = Base64Util.encodeByte(signature.sign());

        } catch (Exception e) {
            logger.error("签名失败", e);
        }
        return base64;
    }

    public static boolean verifyWithSHA1(String origin,String signData, PublicKey publicKey){
        boolean flag = false;
        try {
            Signature signature = Signature.getInstance(SIGNATURE_SHA1);
            signature.initVerify(publicKey);
            signature.update(origin.getBytes());
            flag = signature.verify(Base64Util.decodeToByte(signData));
        }catch (Exception e){
            logger.error("验签失败", e);
        }

        return flag;
    }

    public static String signatureWithMD5(String content, PrivateKey privateKey,String charset){
        String base64 = "";
        try {
            Signature signature = Signature.getInstance(SIGNATURE_MD5);

            signature.initSign(privateKey);
            signature.update(content.getBytes(charset));
            base64 = Base64Util.encodeByte(signature.sign());

        } catch (Exception e) {
            logger.error("签名失败", e);
        }
        return base64;
    }

    public static boolean verifyWithMD5(String origin,String signData, PublicKey publicKey){
        boolean flag = false;
        try {
            Signature signature = Signature.getInstance(SIGNATURE_MD5);
            signature.initVerify(publicKey);
            signature.update(origin.getBytes());
            flag = signature.verify(Base64Util.decodeToByte(signData));
        }catch (Exception e){
            logger.error("验签失败", e);
        }

        return flag;
    }
}
