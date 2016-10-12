package com.bao.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;


public class Pkipair {
	
	
	public String signMsg( String signMsg) {

		String base64 = "";
		try {
			// ��Կ�ֿ�
			KeyStore ks = KeyStore.getInstance("PKCS12");

			FileInputStream ksfis = new FileInputStream("/Users/user/Desktop/idea/ms-online/src/main/resources/static/tester-rsa.pfx");
			
			BufferedInputStream ksbufin = new BufferedInputStream(ksfis);

			char[] keyPwd = "123456".toCharArray();
			//char[] keyPwd = "YaoJiaNiLOVE999Year".toCharArray();
			ks.load(ksbufin, keyPwd);
			// ����Կ�ֿ�õ�˽Կ
			PrivateKey priK = (PrivateKey) ks.getKey("test-alias", keyPwd);
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initSign(priK);
			signature.update(signMsg.getBytes("utf-8"));
			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			base64 = encoder.encode(signature.sign());
			
		} catch(FileNotFoundException e){
			System.out.println("�ļ��Ҳ���");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("test = "+base64);
		return base64;
	}
	public boolean enCodeByCer( String val, String msg) {
		boolean flag = false;
		try {
			//����ļ�(����·��)
			FileInputStream inStream = new FileInputStream("/Users/user/Desktop/idea/ms-online/src/main/resources/static/99bill[1].cert.rsa.20140803.cer");
			
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
			//��ù�Կ
			PublicKey pk = cert.getPublicKey();
			//ǩ��
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initVerify(pk);
			signature.update(val.getBytes());
			//����
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			System.out.println(new String(decoder.decodeBuffer(msg)));
			flag = signature.verify(decoder.decodeBuffer(msg));
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("no");
		} 
		return flag;
	}

	public static void main(String []args){
		Pkipair pkipair = new Pkipair();
		System.out.println(pkipair.signMsg("tewtwtet"));
	}
}
