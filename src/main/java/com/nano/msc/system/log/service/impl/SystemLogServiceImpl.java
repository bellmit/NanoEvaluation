package com.nano.msc.system.log.service.impl;

import com.nano.msc.common.utils.TimeStampUtils;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;
import com.nano.msc.system.log.entity.SystemLog;
import com.nano.msc.system.log.repository.SystemLogRepository;
import com.nano.msc.system.log.service.SystemLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统日志服务接口
 * @author nano
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogRepository systemLogRepository;


    /**
     * 保存日志信息
     *
     * @param systemLog 系统日志
     */
    @Override
    public void save(SystemLog systemLog) {
        ServiceCrudCheckUtils.saveObjectAndCheck(systemLogRepository, systemLog);
    }

    @Override
    public List<SystemLog> listCurrentDay(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return systemLogRepository.findByGmtCreateAfter(TimeStampUtils.getCurrentDayZeroLocalDateTime(), pageable);
    }

    @Override
    public List<SystemLog> listCurrentDayAndLogLevel(int page, int size, int logLevel) {
        Pageable pageable = PageRequest.of(page, size);
        return systemLogRepository.findByGmtCreateAfterAndLogLevel(TimeStampUtils.getCurrentDayZeroLocalDateTime(), logLevel, pageable);
    }

    @Override
    public List<SystemLog> list(int page, int size) {
        return systemLogRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
