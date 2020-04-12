package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.common.vo.CommonResult;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 基础信息服务抽象类
 *
 * @author nano
 * Description: 定义了信息服务的基础操作方法
 */
public abstract class BaseInfoService<T, ID> {

    /**
     * 抽象方法
     */
    abstract JpaRepository<T, ID> getRepository();

    public CommonResult list(int page, int size) {
        return null;
    }

    public CommonResult save(T t) {
        return null;
    }

    public CommonResult save(T[] t) {
        return null;
    }

    public CommonResult delete(T t) {
        return null;

    }

    public CommonResult deleteById(ID id) {
        return null;

    }

    public CommonResult update(T t) {
        return null;

    }
}