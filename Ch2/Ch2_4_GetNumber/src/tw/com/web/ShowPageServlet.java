package tw.com.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/show_pages")
public class ShowPageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String number = req.getParameter("number");	
		  PrintWriter out = resp.getWriter();
		  
		  out.println("<html>"); 
		  out.println("<head>");
		  out.println("<meta charset=\"utf-8\">");
		  out.println("<title>TestPage</title>");
		  out.println("</head>");
		  out.println("<body>");
		  int count = 0;
		  try {
			  count = Integer.parseInt(number);  
		  }catch(Exception ex) {
			  out.println("<h1>Error</h1>");
			  //System.out.println(ex);
		  }
		  
		  for (int i = 1;i<= count;i++) {
			  out.println("<a href='#'>");
			  out.println(i);
			  out.println("</a>");
		  }
		  
		  
		  out.println("</body>");
		  out.println("</html>");
		  
		  
	}
}
