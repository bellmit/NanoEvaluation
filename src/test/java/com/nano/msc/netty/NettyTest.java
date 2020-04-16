package com.nano.msc.netty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NettyTest {


    @Test
    public void test() {
        // 启动netty客户端
        NettyClient nettyClient = new NettyClient();
        nettyClient.start();
    }

}
