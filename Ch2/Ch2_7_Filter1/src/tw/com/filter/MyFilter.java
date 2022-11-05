package tw.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/mypage/*")
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter In");
		HttpServletResponse response = (HttpServletResponse) arg1;
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(arg0, arg1);
		System.out.println("doFilter Out");
	}

}
