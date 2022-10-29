package tw.com.web;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
@WebServlet("/page1")
public class Page1Sevelt extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws IOException{
		//HttpServletRequest ¡@¿é¤J req.getInputStream();
		//HttpServletResponse ¿é¥X resp.getOutputStream();
		PrintWriter out =
				resp.getWriter();
		out.print("Page1");
		
	}
}
