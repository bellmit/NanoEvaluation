package com.nano.msc.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * JWT工具类
 *
 * @author nano
 * @since 2019/10/16
 */
public class JwtUtils {

    /**
     * token过期时间
     */
    public static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;

    /**
     * 密钥
     */
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 生成token字符串的方法
     *
     * @param id 传入用户ID
     * @param nickname 用户昵称
     * @return JWT String
     */
    public static String getJwtToken(String id, String nickname){
        return Jwts.builder()
                // 设置JWT头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // 分类信息，根据业务修改即可
                .setSubject("eval-user")
                .setIssuedAt(new Date())
                // 设置过期时间，根据业务修改即可
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))

                // 设置token主体部分 ，存储用户信息，根据业务修改即可
                .claim("id", id)
                .claim("nickname", nickname)
                // 设置签名
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken 已有的Token String
     * @return 是否有效
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            // 根据密钥解析并验证密钥
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request 传入请求
     * @return 是否有效
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            // 从Header得到token
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token字符串获取会员id
     *
     * @param request 请求
     * @return ID信息
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if(StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        // 获取载荷体
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }

}
