package tw.com.web;

import java.util.ArrayList;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class MyProduces {
	
	@Produces
	@Named("nameList")
	private ArrayList<String> getNameList(){
		
		ArrayList<String> list = new ArrayList();
		list.add("Ken");
		list.add("Vivin");
		list.add("Lucy");
		list.add("Joy");
		return list;
	}
	
	
}
