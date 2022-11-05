package tw.com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyDBContextListener  implements ServletContextListener {
		@Override
		public void contextInitialized(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			System.out.println("DB Init");
			ServletContext context = sce.getServletContext();
			context.setAttribute("dbacc", "qwer");
			context.setAttribute("dbpwd", "123456");
		}
		
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
			System.out.println("DB Destroy");
		}
}
