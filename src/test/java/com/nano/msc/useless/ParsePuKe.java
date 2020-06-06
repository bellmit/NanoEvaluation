package com.nano.msc.useless;


import com.alibaba.fastjson.JSON;

/**
 * 解析普可仪器的数据类
 *
 * @author cz
 */
public class ParsePuKe {


    /**
     * 普可的数据解析
     *
     * @param deviceData 原始数据
     * @return 返回普可数据实体
     * <p>
     * 数据格式: FF 01 04 05 62 00 64
     * 长度固定，格式固定
     */
    public static String parseData(int deviceCode, String deviceData, String serialNumber) {

        DataPuKe dataPuKe = new DataPuKe(serialNumber);

        if (verifyData(deviceData)) {
            String[] result = deviceData.split(" ");
            int Ai = Integer.parseInt(result[3], 16);
            System.out.println(Ai);
            int BSR = Integer.parseInt(result[4], 16);
            System.out.println(BSR);
            int EMG = Integer.parseInt(result[5], 16);
            System.out.println(EMG);
            int SQI = Integer.parseInt(result[6], 16);
            System.out.println(SQI);

            if (Ai > 100) {
                dataPuKe.setAi(-1000);
            } else {
                dataPuKe.setAi(Ai);
            }

            if (SQI == 255) {
                dataPuKe.setSQI(-1000);

            } else {
                dataPuKe.setSQI(SQI);
            }

            if (EMG == 255) {
                dataPuKe.setEMG(-1000);
            } else {
                dataPuKe.setEMG(EMG);
            }

            if (BSR == 255) {
                dataPuKe.setBSR(-1000);
            } else {
                dataPuKe.setBSR(BSR);
            }
            System.out.println(serialNumber);
        }
        System.out.println(dataPuKe.getSerialNumber());
        String dataString = JSON.toJSONString(dataPuKe);
        System.out.println(dataString);
        return dataString;
    }

    /**
     * 普可的数据格式检验
     *
     * @param data 数据
     * @return 返回是否是合格数据
     */
    private static boolean verifyData(String data) {
        System.out.println(data.split(" ").length);
        return data.startsWith("FF") && data.split(" ").length == 7;
    }

    public static void main(String[] args) {
        System.out.println(parseData(31, "FF 01 04 32 54 33 23", "123456789"));;

    }
}
