package com.nano.msc.msm.service;

import java.util.Map;

public interface MsmService {
    boolean sendMsm(Map<String, Object> param, String phone);
}
