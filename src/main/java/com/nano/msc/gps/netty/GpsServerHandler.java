package com.nano.msc.gps.netty;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.utils.SpringUtil;
import com.nano.msc.evaluation.devicedata.param.ParamDeviceData;
import com.nano.msc.evaluation.param.ParamCollector;
import com.nano.msc.gps.GpsDataEntity;
import com.nano.msc.gps.GpsDataRepository;
import com.nano.msc.mq.consumer.IndicatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nano
 *
 * netty服务端处理器
 **/
@Slf4j
@Component
public class GpsServerHandler extends ChannelInboundHandlerAdapter {


    private final GpsDataRepository dataRepository = SpringUtil.getBean(GpsDataRepository.class);


    GpsDataEntity gpsDataEntity = new GpsDataEntity();


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

        String data = msg.toString();

//        String[] values = data.split("#");


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
