package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		String title = req.getParameter("title");
		String count = req.getParameter("count");
		
		int countInt = count == null ?0:Integer.parseInt(count);
		out.print("<html>");
		out.print("<head>");
			out.print("<title>");
			out.print(title);
			out.print("</title>");
		out.print("</head>");
		
		out.print("<body>");
		out.print("<div>Test!</div>");
		out.print("Test2<br>");
		out.print("<ol>");
		char c1 = 'A';
		for (int i = 1;i <= countInt;i++) {
			out.print("<li>");
			out.print(c1++);
			out.print("</li>");
		}
			
		out.print("</ol>");				
		out.print("</body>");
		
		out.print("</html>");
	}
}
