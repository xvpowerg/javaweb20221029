package tw.com.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ServletContextAttrListener 
		implements ServletContextAttributeListener {
			@Override
			public void attributeAdded(ServletContextAttributeEvent event) {
				// TODO Auto-generated method stub
				String name = event.getName();
				String value = event.getValue().toString();
				System.out.println("Add:"+name+":"+value);
			}
			@Override
			public void attributeRemoved(ServletContextAttributeEvent event) {
			// TODO Auto-generated method stub
				String name = event.getName();
				String value = event.getValue().toString();
				System.out.println("Removed:"+name+":"+value);
	
			}
			@Override
			public void attributeReplaced(ServletContextAttributeEvent event) {
			// TODO Auto-generated method stub
				String name = event.getName();
				String value = event.getValue().toString();
				System.out.println("Replaced:"+name+":"+value);	
				ServletContext app = event.getServletContext();
				System.out.println("Replaced:"+name+":"+app.getAttribute(name));
			
			}
	
}
