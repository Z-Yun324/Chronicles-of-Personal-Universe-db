package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
@Configuration
//生成jwt工具
public class JWTutils {
    /**
     *
    一個JWT由三部分组成：
    header（頭部） —— base64編碼的Json字符串
    payload（資料）—— base64編碼的Json字符串
    signature（簽名）—— JWT 的最後一部分是 Signature ，這部分內容有三個部分，
    先是用 Base64 編碼的 header.payload ，再用加密演算法加密一下，加密的時候要放進去一個 Secret ，
    這個相當於是一個密碼，這個密碼祕密地儲存在服務端。
    中間用點分隔開，並且都會使用 Base64 編碼
    */

    //過期時間，15分鐘
    private static final long EXPIRE_TIME = 15 * 60 * 1000;
    //私鑰
    //private static final String TOKEN_SECRET = "privateKey";
    private static final String TOKEN_SECRET = "cuAihCz53DZRjZwbsGcZJ2Ai6At+T142uphtJMsk7iQ=";

    /**
     * 生成jwt
     * @param id UUID
     * @param subject 資訊
     * @param ttlMillis 過期時間
     * @return
     */
    //id是唯一的id，uuid進行生成，subject是jwt帶的數據，ttlMills是超時時間
    public static String creatJWT(String id,String subject,Long ttlMillis){

        //SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.ES256; jwt(0.9.0)
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis(); //.currentTimeMillis() 方法返回當前時間(毫秒)
        Date now=new Date(nowMillis);
        //如果傳進的預設時間為null，預設過期時間設為15分鐘
        if(ttlMillis  == null){
            ttlMillis=JWTutils.EXPIRE_TIME;
        }
        long expMills = nowMillis + ttlMillis; //過期時間點＝目前時間＋過期時間
        Date expDate = new Date(expMills);

        //SecretKey secretKey = generalKey(); //生成私有密鑰 (jwt 0.9.0)
        Key secretKey = generalKey();

        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject) //主題可以是json數據
                .setIssuer("yun") //簽名
                .setIssuedAt(now) //簽發時間
                .signWith(secretKey,signatureAlgorithm)
                //.signWith(signatureAlgorithm,secretKey) //(jwt 0.9.0)使用ES256演算法簽名，第二個參數為密鑰
                .setExpiration(expDate);//設置過期時間

        return builder.compact();
    }


    /**
     * 生成jwt
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String creatJWT(String subject,Long ttlMillis){
        if(ttlMillis  == null){
            ttlMillis=JWTutils.EXPIRE_TIME;
        }
        return  creatJWT(getUUID(),subject,ttlMillis);
    }

    /**
     * 生成jwt
     * @param subject
     * @return
     */
    public static String creatJWT(String subject){
        return  creatJWT(getUUID(),subject,null);
    }



    //生成令牌
    //public  static  SecretKey generalKey(){ //(jwt 0.9.0)
    public  static  Key generalKey(){

        //byte[] encodeKey = Base64.getDecoder().decode(JWTutils.TOKEN_SECRET);
       // SecretKey key = new SecretKeySpec(encodeKey,0, encodeKey.length, "AES");

        byte[] encodeKey = Decoders.BASE64.decode(JWTutils.TOKEN_SECRET);
        Key key= Keys.hmacShaKeyFor(encodeKey);
        return key;

    }

    /**
     * 解析JWT
     *
     * @param jwt 要解析的jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception{
        //SecretKey secretKey = generalKey(); jwt0.9.0
        Key secretKey = generalKey();
        return Jwts
                /*.parser() jwt(0.9.0)
                //.setSigningKey(secretKey)
                 */
                .parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private static String getUUID(){
        return UUID.randomUUID().toString();
    }
    private static final String AES_KEY = "0123456789abcdef";

    public String encrypt(String data) throws Exception {
        SecretKey secretKey = new SecretKeySpec(AES_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public String decrypt(String encryptedData) throws Exception {
        SecretKey secretKey = new SecretKeySpec(AES_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }

    /**
     * 測試JWT生成與解析的工具
     *
     * @param args
     * @throws Exception
     */

    /*public static void main(String[] args) throws Exception {
        //生成
        String token = JWTutils.creatJWT("測試", null);
        System.out.println("生成token=:" + token);
        //解析
        try {
        Claims claims = JWTutils.parseJWT(token);
        System.out.println("解析成功" + claims.getSubject());

        }catch (Exception exception){
        System.out.println("解析失敗:");
        exception.printStackTrace();
        }

    }*/
}
