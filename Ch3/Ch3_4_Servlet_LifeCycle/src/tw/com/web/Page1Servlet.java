package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	private int[] value = new int[100];
	//只會執行一次
	@Override
	 public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("ServletConfig:init()");
		Random ran = new Random();
		Arrays.fill(value,ran.nextInt());
	}
	
	//不建議去Override init(ServletConfig config)  因為很容易造成錯誤
	//@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		//super.init(config);
//		System.out.println("ServletConfig:init(config)");
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			PrintWriter out = resp.getWriter();
			System.out.println(this.getServletContext());
			out.println("Page1:"+value[2]);
			
	}
}
