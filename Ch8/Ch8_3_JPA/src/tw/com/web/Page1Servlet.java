package tw.com.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	
	@EJB
	private MyUserBeanLocal myuserBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyUser myUser = new MyUser();
		myUser.setAccount("Ken");
		myUser.setPassword("123456");
		myuserBean.regisrter(myUser);
		//myuserBean.deleteUser(myUser);
	MyUser qU =  myuserBean.findUserByAccount("Ken");
	System.out.println(qU);
	}
}
