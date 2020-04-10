package com.nano.msc.security.component;


import com.nano.msc.security.util.JwtTokenUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JWT登录授权过滤器
 * Created by macro on 2018/4/26.
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 值为Authorization
     */
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    /**
     * 值为Bearer
     */
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    /**
     * 在此处通过JWT对Token进行请求验证与过滤
     * @param request 请求
     * @param response 响应
     * @param chain 过滤链
     * @throws ServletException 异常
     * @throws IOException IO异常
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        // 从请求头获取
        String authHeader = request.getHeader(this.tokenHeader);
        // 检验Token是否是以Bearer开头的，不是直接忽略
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            // 获取真实的Token字符串，就是"Bearer "后面的部分
            String authToken = authHeader.substring(this.tokenHead.length());
            // 根据Token获取用户名
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            LOGGER.info("Checking username:{}", username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 通过用户名获取UserDetails对象
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                // 使用userDetails对Token进行验证
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    // 认证成功获取权限信息
                    UsernamePasswordAuthenticationToken authentication
                            = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // 用户已授权
                    LOGGER.info("Authenticated user:{}", username);
                    // 将权限信息存入Context中
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        // 传入过滤链中继续过滤
        chain.doFilter(request, response);
    }
}

