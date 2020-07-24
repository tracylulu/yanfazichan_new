package com.h3c.platform.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
	
public class TokenUtil {
	/**
	 * 签名算法使用的密钥，可以随机设置，但每个系统必须相同
	 * 因为还需要密钥解码。
     */
    private static final String TOKEN_SECRET = "amberpaiosd@%#yq3e1";
    /**
     * 签发人
     */
    @Value("${sso.main.siteid}")
	private  static String issUser;
    /**
     * 加密算法（需要输入密钥）
     */
    private static Algorithm JWTAlgorithm = null;
    /**
     * 验证器
     */
    private static JWTVerifier verifier = null;


    /**
     * 生成Token
     *
     * @return
     */
    public static String createToken(String userCode) {
        String token = null;
        try {
            //过期时间5h
            //Date expiresAt = new Date(System.currentTimeMillis() + 5L * 60L * 60L * 1000L);
        	Date expiresAt = new Date(System.currentTimeMillis() + 10000L);
            //签发日期
            Date issueAt = new Date(System.currentTimeMillis());
            //userId是重要信息，进行加密下
            //String encryId = Base64Util.
            token = JWT.create()
            		.withSubject(userCode)
                    .withIssuer(issUser)                    
                    .withExpiresAt(expiresAt)
                    .withNotBefore(issueAt)
                    .withIssuedAt(issueAt)
                    .sign(getJWTAlgorithm());
           
            
        } catch (JWTCreationException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return token;
    }
    
    /**
     * 获取用户
     * @param token
     * @return
     */
    public static String getUser(String token) {
        return getVerifier().verify(token).getSubject();
    }
    
    /**
     * sso登录5小时，因此token设置5小时有效，此处校验token过期时间  
     * @param token
     * @return true ：有效，false：失效
     */
    public static boolean checkExpireTime(String token) {
    	return new Date().before(getVerifier().verify(token).getExpiresAt());
    }

    /**
     * 解码Token
     *
     * @param token
     * @return
     */
    public static DecodedJWT deToken(String token) {
        return getVerifier().verify(token);
    }

    /**
     * 每次前端请求后，刷新token
     *
     * @param oldToken 请求时携带的token
     * @return new token
     */
    public static String refreshToken(String oldToken) {
        DecodedJWT decodedJWT = deToken(oldToken);
        if (decodedJWT == null) {
            return null;
        }
        //如果还有2min过期
        if (decodedJWT.getExpiresAt().getTime() - System.currentTimeMillis() < 2L * 60L * 1000L) {
            return createToken(getUser(oldToken));
        }
        return oldToken;
    }

    /**
     * 根据密钥生成签名算法
     *
     * @return
     */
    public static Algorithm getJWTAlgorithm() {
        if (JWTAlgorithm == null) {
            JWTAlgorithm = Algorithm.HMAC256(TOKEN_SECRET);
        }
        return JWTAlgorithm;
    }

    /**
     * 根据签名算法与签发人，生成验证器
     *
     * @return
     */
    public static JWTVerifier getVerifier() {
        if (verifier == null) {
            verifier = JWT.require(getJWTAlgorithm())
                    .withIssuer(issUser)
                    .build();
        }
        return verifier;
    }
}

