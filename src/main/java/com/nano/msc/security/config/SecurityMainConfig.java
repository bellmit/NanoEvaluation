package com.nano.msc.security.config;


import com.nano.msc.security.po.AuthPermission;
import com.nano.msc.security.po.AuthUser;
import com.nano.msc.security.bo.AuthUserDetails;
import com.nano.msc.security.component.JwtAuthenticationTokenFilter;
import com.nano.msc.security.component.RestAuthenticationEntryPoint;
import com.nano.msc.security.component.RestfulAccessDeniedHandler;
import com.nano.msc.security.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.List;


/**
 * SpringSecurity的配置
 *
 * @author nano
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityMainConfig extends WebSecurityConfigurerAdapter {
    /**
     * 后台管理员Service
     */
    @Autowired
    private AuthUserService userService;

    /**
     * 当访问接口没有权限时，自定义的返回结果
     */
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    /**
     * 当未登录或者token失效访问接口时，自定义的返回结果
     */
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /**
     * 登出成功回调器
     */
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;



    /**
     * 核心配置
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 由于使用的是JWT，我们这里不需要CSRF
        httpSecurity.csrf()
                .disable()
                // 基于Token，所以不需要Session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 允许对于网站静态资源的无授权访问 上线后关闭Swagger
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll()
                // 对登录与注册功能要允许匿名访问
                .antMatchers("/user/login", "/user/register")
                .permitAll()
                // 跨域请求会先进行一次options请求
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                // 测试时全部运行访问
                .antMatchers("/**")
                .permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest()
                .authenticated();


        // 配置退出逻辑
        httpSecurity
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler);




        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);
        // 添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 配置密码加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 获取登录用户信息
        return username -> {
            // 通过用户名查询用户信息
            AuthUser user = userService.getUserByUsername(username);
            if (user != null) {
                List<AuthPermission> permissionList = userService.getPermissionList(user);
                System.out.println("userDetailsService:查询一次用户权限");
                return new AuthUserDetails(user, permissionList);
            }
            // 未查询到用户信息
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    /**
     * JWT登录过滤器
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


//    @Bean
//    public LogoutSuccessHandler myLogoutSuccessHandler() {
//        return new MyLogoutSuccessHandler();
//    }
}
