package tw.com.web;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MyUser implements HttpSessionBindingListener{
	private String name;
	public  MyUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return  "name:"+name;
	}
	
 @Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	 	String name = event.getName();
	 	Object obj =  event.getValue();
	 	System.out.println(name+":"+obj);
	}
 
 	@Override
 	public void valueUnbound(HttpSessionBindingEvent event) {
 		// TODO Auto-generated method stub
 		String name = event.getName();
	 	Object obj =  event.getValue();
	 	System.out.println("valueUnbound:"+name+":"+obj);
 	}
}
