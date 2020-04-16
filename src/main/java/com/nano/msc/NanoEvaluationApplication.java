package com.nano.msc;

import com.nano.msc.netty.NettyServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.net.InetSocketAddress;


@SpringBootApplication
@ComponentScan("com.nano.msc")
public class NanoEvaluationApplication {



	public static void main(String[] args) {
		SpringApplication.run(NanoEvaluationApplication.class, args);

		//启动服务端
		NettyServer nettyServer = new NettyServer();
		nettyServer.start(new InetSocketAddress("0.0.0.0", 9002));
	}


}
