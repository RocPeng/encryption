package cn.com.ambition.utils;

import org.junit.Test;

public class EncryptUtil {
	
	@Test
	public void AESTest() throws Exception{
		String content = "我和世界爱着你";  
        String password = "12345678";  
        // 加密  
        System.out.println("加密前：" + content);  
  
        String tt4 = AESUtil.encrypt2Str(content, password);  
        System.out.println("密文:"+new String(tt4));  
 
        // 解密  
        String d = AESUtil.decrypt2Str(tt4, password);  
        System.out.println("解密后：" + d);  
	}
	
	@Test
	public void RSATest(){
		RSAUtil rsa = RSAUtil.create();
        String pubKey = rsa.getPublicKey();
        String priKey = rsa.getPrivateKey();
        //原文
        StringBuffer res = new StringBuffer();
        res.append("我知道,这个世界,每天都有太多遗憾,所以你好,再见!");
        System.out.println("原文对比:"+res.toString());
        System.out.println("------------");
        String enStr = rsa.encodeByPublicKey(res.toString(), pubKey);
        String deStr = rsa.decodeByPrivateKey(enStr, priKey);
        System.out.println("公钥加密:"+enStr);
        System.out.println("私钥解密:"+deStr);
        System.out.println("------------");
        enStr = rsa.encodeByPrivateKey(res.toString(), priKey);
        deStr = rsa.decodeByPublicKey(enStr, pubKey);
        System.out.println("私钥加密:"+enStr);
        System.out.println("公钥解密:"+deStr);
	}
	
	@Test
	public void MD5Test(){
		System.out.println(MD5Util.getPwd("世上无难事,只要肯放弃!"));
	}
}
