package tw.com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tw.com.db.DbTools;

@WebListener
public class MyDBInitListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext context = sce.getServletContext();
		String url = context.getInitParameter("db_url");
		String account = context.getInitParameter("db_account");
		String password = context.getInitParameter("db_password");
		
		DbTools.setUrl(url);
		DbTools.setAccount(account);
		DbTools.setPassword(password);
		
	}
	
}
