package tw.com.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/p1/*")
public class P1Filter extends HttpFilter{
			@Override
			protected void doFilter(HttpServletRequest request, 
					HttpServletResponse response, FilterChain chain)
					throws IOException, ServletException {
					HttpSession session = request.getSession();
					Object obj = session.getAttribute("login");
					System.out.println("obj:"+obj);
					if (obj == null) {
						String toPage = "../p2/login.html";
						response.sendRedirect(toPage);//³z¹LÂsÄý¾¹Âà­¶
						return;
					}
					chain.doFilter(request, response);
					
			}
}
