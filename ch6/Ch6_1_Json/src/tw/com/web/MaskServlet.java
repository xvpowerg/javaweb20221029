package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@WebServlet(urlPatterns= {"/mask"},asyncSupported = true)
public class MaskServlet extends HttpServlet{
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				System.out.println("Thread Name 1:"+Thread.currentThread().getName());
				AsyncContext ctx = req.startAsync();
				
				final String URL =
						"https://raw.githubusercontent.com/kiang/pharmacies/master/json/points.json";
				OkHttpClient client 
				= new OkHttpClient().newBuilder().build();
				Request okRequest =
						new Request.Builder().url(URL).build();
			Call call = client.newCall(okRequest);
			call.enqueue(new Callback() {
				
				public void onFailure(Call  call,IOException ex) {
					
				}
				public void onResponse(Call call,Response respon) throws IOException {
					ServletResponse servletResp =  ctx.getResponse();
					try{
						System.out.println("Thread Name 2:"+Thread.currentThread().getName());					
						String result = respon.body().string();
						//System.out.println(result);
						PrintWriter out =   servletResp.getWriter();
						out.println("Finish!");
					}finally {
						ctx.complete();
					}
					
					
				}
				
			});
				
			}
}
