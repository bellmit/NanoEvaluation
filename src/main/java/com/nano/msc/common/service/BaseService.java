package com.nano.msc.common.service;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 基础服务类，定义了一些CRUD基本操作
 *
 * @author nano
 * @version V1.0
 * @date 2019/11/27
 * Description: 其他服务类继承这个抽象类可以实现一些通用的服务
 */
public abstract class BaseService<T, ID> {

    /**
     * 抽象方法 实现类需要传入自己的JpaRepository
     */
    protected abstract JpaRepository<T, ID> getRepository();

//    public CommonResult list(int page, int size) {
//        return ServiceCrudCheckUtils.listObjectAndCheck(getRepository(), page, size);
//    }

    public CommonResult save(T t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(getRepository(), t);
    }

    public CommonResult save(T[] t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(getRepository(), t);
    }

    public CommonResult delete(T t) {
        return ServiceCrudCheckUtils.deleteObjectAndCheck(getRepository(), t);
    }

    public CommonResult deleteById(ID id) {
        return ServiceCrudCheckUtils.deleteObjectAndCheck(getRepository(), id);
    }

    public CommonResult update(T t) {
        return ServiceCrudCheckUtils.updateObjectAndCheck(getRepository(), t);
    }
}
