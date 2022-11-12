package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/page1"},asyncSupported = true)
public class Page1Servlet  extends HttpServlet{
		private ExecutorService es;
		@Override
		public void init() throws ServletException {
		// TODO Auto-generated method stub
			es = Executors.newCachedThreadPool();
		}
		
		private String getNumber() {
			System.out.println("getNumber Thread:"+Thread.currentThread().getName());
			Random ran = new Random();
			try {
				TimeUnit.SECONDS.sleep(10);	
			}catch(Exception ex) {
				
			}			
			
			int v = ran.nextInt();
			return v+"";
			
		}
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			System.out.println("doGet Thread:"+Thread.currentThread().getName());
		   AsyncContext ctx = req.startAsync();
		   
			es.execute(()->{
				
				String msg = getNumber();
				try{
					
					ctx.getResponse().getWriter().println(msg);	
					System.out.println("Try Thread:"+Thread.currentThread().getName());
				}catch(Exception ex) {
					
				}finally{
					ctx.complete();
					System.out.println("complete Thread:"+Thread.currentThread().getName());
				}
				
				
			});
			
		}
		
}
