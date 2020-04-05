package com.nano.msc.common.service;


import com.nano.msc.common.util.ServiceCrudCheckUtils;
import com.nano.msc.common.vo.ResultDTO;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 基础服务类，定义了一些CRUD基本操作
 *
 * @author luoxin
 * @version V1.0
 * @date 2019/11/27
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public abstract class BaseService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    public ResultDTO list(int page, int size) {
        return ServiceCrudCheckUtils.listObjectAndCheck(getRepository(), page, size);
    }

    public ResultDTO save(T t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(getRepository(), t);
    }

    public ResultDTO save(T[] t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(getRepository(), t);
    }

    public ResultDTO delete(T t) {
        return ServiceCrudCheckUtils.deleteObjectAndCheck(getRepository(), t);
    }

    public ResultDTO deleteById(ID id) {
        return ServiceCrudCheckUtils.deleteObjectAndCheck(getRepository(), id);
    }

    public ResultDTO update(T t) {
        return ServiceCrudCheckUtils.updateObjectAndCheck(getRepository(), t);
    }
}