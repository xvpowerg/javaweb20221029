package tw.com.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.beans.Msg;

@ServerEndpoint("/websocket")
public class WebSocketServer {
	private static Map<String,Session> sessionMap = new HashMap<>();	
	//msg
	//fromUser
	//toUser
	@OnMessage
	public void onMessage(String message,Session serssion) throws IOException {
		ObjectMapper  objMap = new ObjectMapper();
		Msg msg = objMap.readValue(message, Msg.class);
		System.out.println("msg:"+msg);
		serssion.getBasicRemote().sendText("我收到訊息了:"+message);
		sessionMap.putIfAbsent(msg.getFromUser(), serssion);
		
		if (sessionMap.containsKey(msg.getToUser())) {
			sessionMap.get(msg.getToUser()).getBasicRemote().sendText(msg.getMsg());
		}else {
			serssion.getBasicRemote().sendText("無法傳送給:"+msg.getToUser());
		}
	}
}
