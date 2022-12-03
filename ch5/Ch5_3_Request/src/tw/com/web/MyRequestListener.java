package tw.com.web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalTime;
@WebListener
public class MyRequestListener implements ServletRequestListener{
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		String acc = sre.getServletRequest().getParameter("acc");
		LocalTime time = LocalTime.now();
		System.out.println("acc:"+acc+" time:"+time);
		
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		LocalTime time = LocalTime.now();
		System.out.println("requestDestroyed time:"+time);
	}
}
