package com.nano.msc.netty;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.evaluation.devicedata.param.ParamDeviceData;
import com.nano.msc.evaluation.param.ParamCollector;
import com.nano.msc.mq.consumer.IndicatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Gjing
 *
 * netty服务端处理器
 **/
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {



    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Channel active......");
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("Netty receive: {}", msg.toString());

        ParamCollector paramCollector = null;
        try {
            paramCollector = JSON.parseObject(msg.toString(), ParamCollector.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 原始待解析的数据
        String rawData = paramCollector.getData();
        ParamDeviceData paramDeviceData = null;
        try {
            paramDeviceData = JSON.parseObject(rawData, ParamDeviceData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 发送到消息队列
        IndicatorService.sendMessage("deviceData", paramDeviceData.getDeviceCode() + "@" + paramDeviceData.getDeviceData());
        ctx.write("{OK}");
        ctx.flush();
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
