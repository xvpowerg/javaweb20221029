package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		   PrintWriter out =  resp.getWriter();
		   out.println("<html>");
			   out.println("<body>");
				resp.getWriter().println("<a href=\"page2?count=10\">Page2</a>");
				out.println("</body>");
			out.println("</html>");
		}
}
