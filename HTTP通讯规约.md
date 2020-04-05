# 通讯API

## enum code
* UNKNOWN_ERROR(-1,"未知错误"),
* DEVICE_REGISTER(99, "注册"),
* REGISTER_SUCCESS(100, "开机注册成功"),
* VERSION_REQUEST(101, "请求版本号"),
* VERSION_REQUEST_SUCCESS(102, "版本号请求成功"),
* DATA_FORMAT_ERROR(-2,"数据格式错误"), 
* OPERATION_READY(151,"准备要开始新的手术，获取operationNumber"),
* OPERATION_READY_SUCCESS(152,"服务器准备完毕，可以开始手术了"),
* OPERATION_DEVICE_READY(153,"准备开始发送手术设备信息"),
* OPERATION_DEVICE_READY_SUCCESS(154,"可以准备开始发送手术设备信息"),
* OPERATION_DEVICE(155,"是手术设备信息"),
* OPERATION_DEVICE_SUCCESS(156,"该条信息保存完毕"),
* OPERATION_DEVICE_END(157, "设备数据发送完毕"),
* OPERATION_DEVICE_END_SUCCESS(158, "回复设备数据发送可以完毕"),
* PATIENT_INFO_READY(159,"准备上传病人数据"),
* PATIENT_INFO_READY_SUCCESS(160, "可以开始上传病人数据"),
* PATIENT_INFO(161,"是病人数据"),
* PATIENT_INFO_SUCCESS(162, "该条病人数据保存完毕"),
* PATIENT_INFO_END(163,"病人信息发送完毕"),
* PATIENT_INFO_END_SUCCESS(164,"病人信息发送完毕收到"),
* DEVICE_DATA_READY(165, "准备发送仪器数据"),
* DEVICE_DATA_READY_SUCCESS(166, "可以开始上传仪器数据"),
* DEVICE_DATA(167, "是仪器数据"),
* DEVICE_DATA_SUCCESS(168, "该条仪器数据保存完毕"),
* DEVICE_DATA_END(169,"仪器数据发送完毕"),
* DEVICE_DATA_END_SUCCESS(170,"病人信息发送完毕收到"),
* OPERATION_MARK_READY(171,"手术过程中标记信息准备发送"),
* OPERATION_MARK_READY_SUCCESS(172,"手术过程中标记信息可以发送"),
* OPERATION_MARK(173,"是手术过程中的标记数据"),
* OPERATION_MARK_SUCCESS(174,"该条过程中的标记数据收到"),
* OPERATION_MARK_END(175, "手术过程中的标记数据发送结束"),
* OPERATION_MARK_END_SUCCESS(176, "手术过程中的标记数据发送结束收到"),
* OPERATION_END_READY(177,"请求手术结束"),
* OPERATION_END_READY_SUCCESS(178, "是手术结束的信息"),
* OPERATION_END(179, "是手术结束的信息"),
* OPERATION_END_SUCCESS(180, "回复收到手术结束的信息"),
* POSTOPERATIVE_PATIENT_INFO_READY(181, 请求发送术后患者信息),
* POSTOPERATIVE_PATIENT_INFO_READY_SUCCESS(182, "可以发送术后患者信息，服务器已经准备好了"),
* POSTOPERATIVE_PATIENT_INFO(183, "是术后患者信息"),
* POSTOPERATIVE_PATIENT_INFO_SUCCESS(184, "收到术后患者信息"),
* FEEDBACK_INFO(185, "是反馈错误数据"),
* FEEDBACK_INFO_SUCCESS(186, "反馈错误数据接收成功"),
* GET_ALL_OPERATION_INFORMATION(187, "请求所有的手术场次信息")
* RECEIVE_ALL_OPERATION_INFORMATION(188, "获取到所有的手术场次信息")
* GET_MARK_EVENT_LIST_OF_ONE_OPERATION(189, "请求指定手术场次号的全部标记事件")
* RECEIVE_MARK_EVENT_LIST_OF_ONE_OPERATION(190, "获取指定手术场次号的全部标记事件")

## response code
* UNKNOWN_ERROR(-1, "未知错误"),
* DATA_FORMAT_ERROR(-2, "数据格式错误"),
* CODE_ERROR(-3, "请求的CODE是错误的"),
* DATA_DOES_NOT_EXIST(-4, "数据不存在"),
* REQUEST_PARAMETER_DOES_NOT_EXIST(-5, "请求参数不存在"),
* DATA_EXISTED(-6, "数据已经存在"),
* DATA_STATE_FINISHED(-7, "该数据已经处于结束状态"),
* OPERATION_NOT_READY(-8, "手术没有开始，没有前置数据"),

## 上传规则
###所有时间格式采用TimeStamp格式1552012460277

### 1. 所有设备开机时发送
* 数据上传URL 120.79.151.208:8080/campephilus/instrument/
* 请求方式 POST
* 请求类型 x-www-form-urlencoded
* 请求体
```
code: 199
mac: "mac"
operationNumber: 1
data: {}
```
code、mac、operationNumber、data为必填字段



* #### 请求版本号
```
code: 101
mac: "mac"
operationNumber: -1
data: {}
```

* #### 回复请求版本号
```
code: 102
mac: "mac"
operationNumber: -1
data: {}
```

* #### 准备要开始手术了(手术开始准备,请求operationNumber)
```
code: 151
mac: "mac"
operationNumber: -1
data: {
    "infoOperation": {
        "hospitalCode": "0156161",
        "operationName": "胸腔开孔",
        "hospitalOperationNumber": "777777"
    },
    "olderOperationDeviceInfo": {
        "deviceCode0": "12",
        "deviceSerialNumber0": "2008-12-21-abcde",
        "deviceCode1": "12",
        "deviceSerialNumber1": "2008-12-21-abcde",
        "deviceCode2": "12",
        "deviceSerialNumber2": "2008-12-21-abcde",
        "deviceCode3": "12",
        "deviceSerialNumber3": "2008-12-21-abcde",
        "deviceCode4": "12",
        "deviceSerialNumber4": "2008-12-21-abcde",
        "deviceCode5": "12",
        "deviceSerialNumber5": "2008-12-21-abcde"
    },
    "patientInfo": {
        "patientId": "5000115165156156156",
        "admissionNumber": "dsadasdas",
        "sex": 0,
        "height": 170,
        "weight": 70,
        "age": 26
    },
    "beforeOperationInfo": {
        "anesthesiaMode": "麻醉方式",
        "isUrgent": true,
        "ASALevel": 0,
        "medicalHistory": "既往病史",
        "specialCase": "特殊情况"
    }
}
```

* #### 服务器也准备完毕，返回operationNumber，数据已经保存了
```
code: 152
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发送仪器数据
```
code: 167
mac: "mac"
operationNumber: 1
data: {"data":"#32#322342342342342342342#"}
```

* #### 接收到数据
```
code: 168
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发送标记信息
```
code: 173
mac: "mac"
operationNumber: 1
data: {"mark" : "#12#123123123#"}
```

* #### 收到该标记信息
```
code: 174
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发送手术开始的信息
```
code: 177
mac: "mac"
operationNumber: 1
data: {}
```

* #### 收到手术结束的信息
```
code: 178
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发送手术结束的信息
```
code: 179
mac: "mac"
operationNumber: 1
data: {}
```

* #### 收到手术结束信息
```
code: 180
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发送术后患者情况（回访信息）
```
code: 183
mac: "mac"
operationNumber: 1
data: {
          "patientId": "value",
          "postoperativeData": {}
      }
```

* #### 收到发送的术后患者情况
```
code: 184 
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发送采集器日志信息
```
code: 185
mac: "mac"
operationNumber: -1
data: {
          "errorMessage": "error"
      }
```

* #### 收到用户反馈信息
```
code: 186
mac: "mac"
operationNumber: -1
data: {}
```