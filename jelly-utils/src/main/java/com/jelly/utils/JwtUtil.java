package com.jelly.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by wu on 2018/9/8.
 */
public class JwtUtil {
    public static <T> String sign(T object,long maxAge) throws JsonProcessingException, UnsupportedEncodingException {
        Algorithm algorithm=Algorithm.HMAC256(Constant.JWT_SECRET);
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(object);
        JWTCreator.Builder signer= JWT.create()
                .withClaim(Constant.PAYLOAD,json);
        long expire=System.currentTimeMillis()+maxAge;
        signer.withExpiresAt(new Date(expire));
        return signer.sign(algorithm);


    }
    public  static <T> T unsign(String token,Class<T> classT) throws IOException {
        Algorithm algorithm=Algorithm.HMAC256(Constant.JWT_SECRET);
        JWTVerifier verifier=JWT.require(algorithm).build();
        DecodedJWT jwt=verifier.verify(token);
        Claim claim=jwt.getClaim(Constant.PAYLOAD);
        return new ObjectMapper().readValue(claim.asString(),classT);

    }

    public static void main(String[] args) throws IOException {
       String token= JwtUtil.sign(new Integer(1),10000);
        System.out.println(token);

        Integer i=JwtUtil.unsign(token,Integer.class);
        System.out.println(i);
    }
}
