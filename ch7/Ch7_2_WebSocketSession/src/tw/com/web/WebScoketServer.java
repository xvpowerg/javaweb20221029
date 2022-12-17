package tw.com.web;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebScoketServer  {
		
	@OnMessage
	public void onMessage(String message,Session session) throws IOException, InterruptedException {
		
		session.getBasicRemote().sendText("收到訊息了:"+message);
		for (int i = 1; i<= 10;i++) {
			
			Thread.sleep(500);
			session.getBasicRemote().sendText("Servert Send msg "+i+"筆數");
		}
		session.getBasicRemote().sendText("送完啦!");
		
	}
}
