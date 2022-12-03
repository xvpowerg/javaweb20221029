package tw.com.web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestAttrListener implements ServletRequestAttributeListener {
	  @Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		  String name = srae.getName();
		  String value = srae.getValue().toString();
		  System.out.println("add name:"+name);
		  System.out.println("add value:"+value);
	}
	  
	  @Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		
		  String name = srae.getName();
		  Object obj =   srae.getValue();
		  System.out.println("Remove:"+name+":"+obj);
		  
	}
	  
	  @Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		  String name = srae.getName();
		  Object value = srae.getValue();
		  System.out.println("Replaced:"+name+":"+value);
		 Object chValue = srae.getServletRequest().getAttribute(name);
		 System.out.println("Replaced:"+name+":"+chValue);
	}
	  
}
