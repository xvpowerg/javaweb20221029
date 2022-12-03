package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//設定ServeltContext 設定兩組Attribute
		//value1 Test1
		//value2 12345
	ServletContext app = this.getServletContext();
	app.setAttribute("value1", "Test1");
	app.setAttribute("value2", 12345);
	app.setAttribute("value3", "ABCD");
	app.setAttribute("value4", "RTYU");
	
	app.removeAttribute("value3");
	app.setAttribute("value4", "UIOO");
		//設定完畢後再page1.jsp 顯示value1 與 value2
	resp.sendRedirect("page1.jsp");
	}
}
