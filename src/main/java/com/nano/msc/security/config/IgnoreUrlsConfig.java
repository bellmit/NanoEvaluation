package com.nano.msc.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 用于配置不需要保护的资源路径
 * Created by macro on 2018/11/5.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "security.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();

}
