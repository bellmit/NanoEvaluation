package com.nano.msc.info;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nano.msc.common.enums.CollectCodeEnum;
import com.nano.msc.common.utils.CollectionUtil;
import com.nano.msc.evaluation.info.entity.InfoDevice;
import com.nano.msc.evaluation.info.entity.InfoEvaluation;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.entity.InfoOperationMark;
import com.nano.msc.evaluation.info.repository.InfoOperationRepository;
import com.nano.msc.evaluation.param.ParamCollector;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DeviceDataCollectionTest {

    @Autowired
    private InfoOperationRepository operationRepository;


    @Test
    public void testParse() {
        String a = "{admissionNumber=438212309123, age=87, anesthesiaMode=局部麻醉, asaLevel=3, collectorMacAddress=08:00:20:0A:8C:6D, height=180, hospitalOperationNumber=AS1235621, isUrgent=true, medicalHistory=无, operationName=剪脚趾甲, patientId=400382195912021273, sex=0, specialCase=无, weight=70}";;

        JSONObject.parseObject(a, InfoOperation.class);
    }


    @Test
    void postOperationInfo() {

        InfoDevice[] infoDevice = new InfoDevice[6];
        infoDevice[0] = new InfoDevice("30", "XB123789", 12.0);
        infoDevice[1] = new InfoDevice("31", "XB123789", 12.0);
        infoDevice[2] = new InfoDevice("32", "XB123789", 12.0);
        infoDevice[3] = new InfoDevice("33", "XB123789", 12.0);
        infoDevice[4] = new InfoDevice("0", "", 0.0);
        infoDevice[5] = new InfoDevice("0", "", 0.0);

        InfoOperation infoOperation = new InfoOperation();
        infoOperation.setAdmissionNumber("123123");
        infoOperation.setHospitalOperationNumber("AS12309");
        infoOperation.setPatientId("123456789987654321");
        infoOperation.setAge(78);
        infoOperation.setAnesthesiaMode("局麻");
        infoOperation.setAsaLevel(3);
        infoOperation.setOperationState(1);
        infoOperation.setHeight(178);
        infoOperation.setIsUrgent(false);
        infoOperation.setSex(1);
        infoOperation.setWeight(78.0);
        infoOperation.setSpecialCase("无");
        infoOperation.setMedicalHistory("无");
        infoOperation.setOperationName("XXXXXXX");
        // 使用仪器信息
        infoOperation.setUsedDeviceInfo(JSONObject.toJSONString(infoDevice));
        System.out.println(JSONObject.toJSON(infoOperation));

        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(103);
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(-1);
        paramCollector.setData(JSONObject.toJSONString(infoOperation));
        String a = JSONObject.toJSONString(paramCollector);
        System.out.println(a);
        ParamCollector param = JSONObject.parseObject(a, ParamCollector.class);
        System.out.println(param.getData());

        InfoOperation b = JSONObject.parseObject((String)param.getData(), InfoOperation.class);
        List<InfoDevice> usedDevices = JSONObject.parseArray(b.getUsedDeviceInfo(), InfoDevice.class);
        CollectionUtil.printList(usedDevices);

    }


    @Test
    public void testOperationStart() {
        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(105);
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(26);
        // 默认无数据
        paramCollector.setData("");
        System.out.println(JSON.toJSONString(paramCollector));
    }

    @Test
    public void testPostMarkInfo() {
        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(CollectCodeEnum.COLLECTION_OPERATION_MARK.getCode());
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(26);

        List<InfoOperationMark> markList = new ArrayList<>(5);
        markList.add(new InfoOperationMark(26, "给药", "抗生素", "阿莫西林", "注射", "12.3", "无", LocalDateTime.now()));
        markList.add(new InfoOperationMark(26, "给药", "抗生素", "阿莫西林2", "注射", "12.43", "无", LocalDateTime.now()));
        markList.add(new InfoOperationMark(26, "给药", "抗生素", "阿莫西林3", "注射", "12.3", "无", LocalDateTime.now()));
        markList.add(new InfoOperationMark(26, "给药", "抗生素", "阿莫西林4", "注射", "0.98", "无", LocalDateTime.now()));
        markList.add(new InfoOperationMark(26, "事件", "基本事件", "麻醉开始", "---", "---", "无", LocalDateTime.now()));

        // 默认无数据
        paramCollector.setData(JSON.toJSONString(markList));
        System.out.println(JSON.toJSONString(paramCollector));
    }

    @Test
    public void testOperationStop() {
        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(CollectCodeEnum.COLLECTION_STOP_OPERATION.getCode());
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(26);
        // 默认无数据
        paramCollector.setData("");
        System.out.println(JSON.toJSONString(paramCollector));
    }


    @Test
    public void testPostEvaluationInfo() {
        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(CollectCodeEnum.COLLECTION_DEVICE_EVALUATION.getCode());
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(26);

        List<InfoEvaluation> evaluationList = new ArrayList<>(5);

        evaluationList.add(new InfoEvaluation(26, 30, "ABSXXX123", "麻醉科", "满意", "可靠性高", false, "", "", "无", "张良"));
        evaluationList.add(new InfoEvaluation(26, 31, "ABSXXX124", "麻醉科", "满意", "可靠性高", false, "", "", "无", "张良"));
        evaluationList.add(new InfoEvaluation(26, 32, "ABSXXX125", "麻醉科", "满意", "可靠性高", false, "", "", "无", "张良"));
        evaluationList.add(new InfoEvaluation(26, 32, "ABSXXX126", "麻醉科", "满意", "可靠性高", false, "", "", "无", "张良"));

        // 默认无数据
        paramCollector.setData(JSON.toJSONString(evaluationList));
        System.out.println(JSON.toJSONString(paramCollector));
    }
}
