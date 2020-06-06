package com.nano.msc.useless;


import com.alibaba.fastjson.JSON;

/**
 * 解析诺和数据的类
 * @author cz
 */
public class ParseNuoHe {

    /**
     * 解析数据
     *
     * @param deviceData 仪器原始数据
     * @return 诺和的数据实体
     *
     * 数据格式:FF 01 7D 58 EC 2C 78 02 0B 00 00 02 00 00 FF FF FF 00 00 FF C8 CA 3C 19 E60065000000000000000000000000000000000000000000000000000
     * 00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
     * 000000000000009D25FE
     *
     * 特征:长度固定 4个参数的位置也是固定
     */
    public static String parseData(int deviceCode, String deviceData, String serialNumber){
        DataNuoHe dataNuoHe = new DataNuoHe();

        if (verifyData(deviceData)){

            String[] values = deviceData.split(" ");

            // CSI:偏移量15字节  BS:偏移量16字节  SQI:偏移量17字节   EMG:偏移量20字节
            int CSI = Integer.parseInt(values[14], 16);
            int BS = Integer.parseInt(values[15], 16);
            int SQI = Integer.parseInt(values[16], 16);
            int EMG = Integer.parseInt(values[19], 16);

            if (CSI == 255){
                dataNuoHe.setCsi(-1000);
            }else{
                dataNuoHe.setCsi(CSI);
            }

            if (BS == 255){
                dataNuoHe.setBs(-1000);
            }else {
                dataNuoHe.setBs(BS);
            }

            if (SQI == 255){
                dataNuoHe.setSqi(-1000);
            }else {
                dataNuoHe.setSqi(SQI);
            }

            if (EMG == 255){
                dataNuoHe.setEmg(-1000);
            }else {
                dataNuoHe.setEmg(EMG);
            }

            // 设置序列号
            dataNuoHe.setSerialNumber(serialNumber);
        }

        String dataString = JSON.toJSONString(dataNuoHe);
        System.out.println(dataString);
        return "";
    }

    public static void main(String[] args) {
        parseData(30, "FF 01 7D 58 EC 2C 78 02 0B 38 00 00 00 00 5D 00 19 03 04 64 C8 CA 3C 19 84 00 C2 00 05 FB FC 03 05 04 01 03 03 FE 01 03 FB FB 00 F9 FA 00 FE 00 00 FD 02 04 02 01 02 09 06 FE 04 03 FE 04 FF FA 02 FE F7 FF 04 01 F8 F5 FB F9 FF 0D 06 FC FD 00 00 F8 FC 06 02 FE 04 05 02 05 08 FF FD 07 06 00 FD FE FF FD F9 FF FC FA 09 0B 04 0C 07 F8 FC 04 FC F7 00 FF FB 01 01 FF F8 EA F6 09 FE F9 0B 0C 19 DD FE"
        , "12345");
    }

    /**
     * 诺和的数据格式检验
     * @param data 数据
     * @return 返回是否是合格数据
     */
    private static boolean verifyData(String data){
        return data.startsWith("FF") && data.endsWith("FE");
    }

}
