package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tw.com.beans.MyMsg;

@WebServlet("/page1")
public class Page1Servelt extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
				OkHttpClient clinet = new OkHttpClient().newBuilder().build();
				
				Request okRequest = 
						new Request.
						Builder().url("http://localhost:8080/Ch8_2_TestRestful/test").build();
				Call call = clinet.newCall(okRequest);
				call.enqueue(new Callback() {					
					@Override
					public void onResponse(Call arg0, Response resp) throws IOException {
						// TODO Auto-generated method stub
							String result = resp.body().string();						
							
							ObjectMapper objMap = new ObjectMapper();
							MyMsg msg = objMap.readValue(result, MyMsg.class);
							System.out.println(msg);
							
					}
					
					@Override
					public void onFailure(Call arg0, IOException arg1) {
						// TODO Auto-generated method stub
						
					}
				});
		}
}
