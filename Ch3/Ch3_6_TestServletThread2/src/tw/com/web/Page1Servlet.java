package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	private ExecutorService es;
	@Override
	public void init() throws ServletException {
	// TODO Auto-generated method stub
		es = Executors.newCachedThreadPool();
	}	
	
	private void testWork() {
		for (int i = 1;i<= 10;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1000);	
			}catch(Exception ex) {
				
			}			
		}
		System.out.println(Thread.currentThread().getName()+": Finish");
	}
	
	private void testWork(HttpServletResponse resp) {
		for (int i = 1;i<= 3;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1000);	
			}catch(Exception ex) {
				
			}			
		}
		try {
			resp.getWriter().println("Page1Servlet Finish:"+Thread.currentThread().getName());
		}catch(Exception ex) {
			
		}
		
	}
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		PrintWriter out = 	  resp.getWriter();
		out.println(Thread.currentThread().getName()+" Start==================");
		//es.execute(this::testWork);
		es.execute(()->testWork(resp));
		out.println(Thread.currentThread().getName()+" End=====================");	
		
		}
}
