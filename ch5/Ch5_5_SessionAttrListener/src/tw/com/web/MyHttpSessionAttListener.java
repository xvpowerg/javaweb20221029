package tw.com.web;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttListener implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object obj = event.getValue();
		System.out.println("add:"+name+":"+obj);
		if (name.equals("acc")) {
			LocalDateTime now = LocalDateTime.now();
			System.out.println("µn¤J®É¶¡:"+now);
		}
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
			String name = event.getName();
			Object obj = event.getValue();
			System.out.println("Removed:"+name+":"+obj);
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object obj = event.getValue();
		Object obj2 = event.getSession().getAttribute(name);
		System.out.println("Replaced:"+name+":"+obj+":"+obj2);
		
	}
}
