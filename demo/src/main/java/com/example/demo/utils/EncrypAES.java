package com.example.demo.utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncrypAES {

   // KeyGenerator 提供對稱密鑰生成器的功能，支持各種演算法 
   private KeyGenerator keygen;
   // SecretKey 負責保存對稱密鑰 
   private SecretKey deskey;
   // Cipher 加密對象負責完成加密或解密工作
   private Cipher c;
   //該字節數組負責保存加密的結果 
   private byte[] cipherByte;


   public EncrypAES(byte[] keyBytes)
       throws NoSuchAlgorithmException, NoSuchPaddingException
   {
       //Security.addProvider(new com.sun.crypto.provider.SunJCE());
       // 實例化支持 AES 演算法的密鑰生成器(演算法名稱命名需按規定，否則拋出異常)
       //algorithm加密類型
       keygen = KeyGenerator.getInstance("AES");
       //生成密鑰 加密規則?
       deskey = new SecretKeySpec(keyBytes, "AES");
       //生成 Cipher 物件,指定其支持的 AES 演算法 *transformation算法
       c = Cipher.getInstance("AES"); 
   } 

   //加密
   public byte[] Encrytor(String str)
       throws InvalidKeyException, IllegalBlockSizeException, 
              BadPaddingException 
   { 
       // 根據密鑰，對 Cipher 物件進行初始化，ENCRYPT_MODE 表示加密模式  deskey規則
       c.init(Cipher.ENCRYPT_MODE, deskey); 
       byte[] src = str.getBytes(); 
       // 加密方法，結果保存進 cipherByte 是亂碼
       cipherByte = c.doFinal(src);
       return cipherByte;
   } 
 
//解密
   public byte[] Decryptor(byte[] buff) 
       throws InvalidKeyException, IllegalBlockSizeException,
           BadPaddingException
   { 
       // 根據密鑰，對 Cipher 物件進行初始化，DECRYPT_MODE 表示加密模式 
       c.init(Cipher.DECRYPT_MODE, deskey); 
       cipherByte = c.doFinal(buff);
       return cipherByte;
   }
}
/*
    public static void main(String[] args) throws Exception {
        //定義key
        byte[] keyBytes = "0123456789abcdef".getBytes(); // 16字節的密鑰
        EncrypAES de1 = new EncrypAES(keyBytes);
        String msg ="1234567812345678";
        byte[] encontent = de1.Encrytor(msg);
        byte[] decontent = de1.Decryptor(encontent);
        System.out.println("明文是:" + msg);
        System.out.println("加密後:" + Base64.encodeBase64String(encontent));
        System.out.println("解密後:" + new String(decontent));
    }*/
