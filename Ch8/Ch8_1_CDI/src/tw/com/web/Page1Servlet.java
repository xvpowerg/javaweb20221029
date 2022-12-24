package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Inject
	@Named("nameList")
	private ArrayList nameList;
		@Override
		protected void doGet(HttpServletRequest req,
				HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			System.out.println(nameList);
		}
}
