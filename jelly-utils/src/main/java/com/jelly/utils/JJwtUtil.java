package com.jelly.utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wu on 2018/9/8.
 */
public class JJwtUtil {
    private static Lock lock=new ReentrantLock();
    private static JJwtUtil jJwtUtil=null;
    private JJwtUtil(){
    }
    public static JJwtUtil getInstance(){
        lock.lock();
        if(jJwtUtil==null){
            jJwtUtil=new JJwtUtil();
        }
        lock.unlock();
        return jJwtUtil;
    }

    public SecretKey generalKey(){
        String stringKey=Constant.JWT_SECRET;
        byte[] encodeKey= org.apache.commons.codec.binary.Base64.decodeBase64(stringKey);

        SecretKey key=new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        return key;
    }

    /**
     * 创建token
     * @param map
     * @param id
     * @param isuser
     * @param subject
     * @param ttlMills
     * @return
     */
    public String createJWT(Map map,String id,String isuser,String
            subject,long ttlMills){
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        long nowMills=System.currentTimeMillis();
        Date now=new Date(nowMills);
       SecretKey key=generalKey();
        JwtBuilder builder= Jwts.builder()
                .setClaims(map)
               .setId(id)
                .setIssuedAt(now)
                .setIssuer(isuser)
                .setSubject(subject)
                .signWith(signatureAlgorithm,key);

        if(ttlMills>=0){
            long expMills=nowMills+ttlMills;
            Date exp=new Date(expMills);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    public Claims parseJWT(String jwt){
        SecretKey key=generalKey();
        Claims claims=Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Map map=new HashMap();
        map.put("name","w");
        map.put("phone","123456");
        String sub= new ObjectMapper().writeValueAsString(map);
        JJwtUtil jwtUtil=new JJwtUtil();
       String jwt= jwtUtil.createJWT(map,Constant.JWT_ID,"Anno",sub,Constant.JWT_TTL);
        System.out.println(jwt);
        Claims claims=jwtUtil.parseJWT(jwt);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
    }
}
