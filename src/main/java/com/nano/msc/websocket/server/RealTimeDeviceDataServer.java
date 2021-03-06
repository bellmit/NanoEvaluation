package com.nano.msc.websocket.server;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.nano.msc.websocket.entity.DataSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * WebSocket仪器实时数据服务端
 *
 * @author: nano
 * @time: 2020/6/2 18:00
 */
@ServerEndpoint("/device-real-time-data/{operationNumber}/{currentDeviceCode}/{browserId}")
@Component
public class RealTimeDeviceDataServer {

	private final static Log logger = LogFactory.get(RealTimeDeviceDataServer.class);

	/**
	 * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	 */
	private static int onlineCount = 0;

	/**
	 * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	 */
	public static final ConcurrentHashMap<String, RealTimeDeviceDataServer> connectionMap = new ConcurrentHashMap<>();


	public static final ConcurrentHashMap<String, DataSession> dataSessionMap = new ConcurrentHashMap<>();

	/**
	 * 与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	private Session session;

	/**
	 * 接收operationNumber
	 */
	private Integer operationNumber = 0;
	private Integer deviceCode = 0;
	private String browserId;


	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("operationNumber") Integer operationNumber,
					   @PathParam("currentDeviceCode") Integer currentDeviceCode,
					   @PathParam("browserId") String browserId) {
		this.session = session;
		this.operationNumber = operationNumber;

		this.browserId = browserId;


		// 构造Session
		DataSession dataSession = new DataSession(session, operationNumber, currentDeviceCode, browserId);
		dataSessionMap.put(dataSession.getSessionKey(), dataSession);
		if (dataSessionMap.containsKey(dataSession.getSessionKey())) {
			dataSessionMap.remove(dataSession.getSessionKey());
			dataSessionMap.put(dataSession.getSessionKey(), dataSession);
		} else {
			dataSessionMap.put(dataSession.getSessionKey(), dataSession);
			// 在线数加1
			addOnlineCount();
		}
		logger.info("用户连接:" + dataSession.toString() + ",当前在线人数为:" + dataSessionMap.size());
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		if (dataSessionMap.containsKey(operationNumber + browserId)) {
			dataSessionMap.remove(operationNumber + browserId);
			// 从set中删除
			subOnlineCount();
		}
		logger.info("用户退出:场次号:" + operationNumber + ",浏览器ID" + browserId + ",当前在线人数为:" + dataSessionMap.size());
	}

	/**
	 * 实现服务器主动推送
	 */
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	/**
	 * 推送数据
	 *
	 * @param operationNumber   手术场次号
	 * @param currentDeviceCode 仪器号
	 * @param message           信息
	 */
	public static void sendDeviceRealTimeData(int operationNumber, int currentDeviceCode, String message) {
		logger.info("发送消息到:" + operationNumber + "，报文:" + message);

		for (DataSession dataSession : dataSessionMap.values()) {
			if (dataSession.getCurrentDeviceCode() == currentDeviceCode && dataSession.getOperationNumber() == operationNumber) {
				// 发送数据
				try {
					dataSession.getSession().getBasicRemote().sendText(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * 发送自定义消息
	 */
	public static void sendDeviceRealTimeData(String message, @PathParam("operationNumber") String operationNumber,
											  @PathParam("deviceCode") Integer deviceCode) throws IOException {
		logger.info("发送消息到:" + operationNumber + "，报文:" + message);
		if (StringUtils.isNotBlank(operationNumber) && connectionMap.containsKey(operationNumber + "%" + deviceCode)) {
			connectionMap.get(operationNumber + "%" + deviceCode).sendMessage(message);
		} else {
			logger.error("用户" + operationNumber + ",不在线！");
		}
	}


	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 *                格式: operationNumber#browserId#newDeviceCode
	 */
	@OnMessage
	public void onMessage(String message, Session session) {

		String[] values = message.split("#");
		int operationNumber = 0;
		String browserId = "";
		int newDeviceCode = 0;
		try {
			operationNumber = Integer.parseInt(values[0]);
			browserId = values[1];
			newDeviceCode = Integer.parseInt(values[2]);

			// 说明没这个链接
			if (!dataSessionMap.containsKey(operationNumber + browserId)) {
				session.getBasicRemote().sendText("没有当前Key");
			} else {
				// 修改当前正在看的仪器号
				dataSessionMap.get(operationNumber + browserId).setCurrentDeviceCode(newDeviceCode);
			}
		} catch (Exception e) {
			logger.error("更改当前查看仪器切换错误:" + message);
		}

	}


	/**
	 * 发生错误
	 *
	 * @param session session
	 * @param error   错误
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		logger.error("用户错误:" + this.operationNumber + ",原因:" + error.getMessage());
		error.printStackTrace();
	}


	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		RealTimeDeviceDataServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		RealTimeDeviceDataServer.onlineCount--;
	}
}

