package tw.com.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.MyApple;


@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	
	@Inject
	@Named("redApple")
	private MyApple apple;
	@Inject
	@Named("greenApple")
	private MyApple gapple;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println(apple);
			System.out.println(gapple);
	}
}
