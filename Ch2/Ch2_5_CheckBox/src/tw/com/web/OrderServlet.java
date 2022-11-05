package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/order")
public class OrderServlet  extends HttpServlet {
	private Map<String,String> foodMap = new HashMap<>();
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		foodMap.put("0", "雞腿");
		foodMap.put("1", "排骨");
		foodMap.put("2", "魚排");
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//String food = req.getParameter("food");
		String[] foods = req.getParameterValues("food");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out =  resp.getWriter();
		if (foods == null) {
			out.println("請選餐點");
		}
//		for (String f : foods) {
//			out.println(f);
//		}
		String foodStr = Stream.of(foods).map(f->foodMap.get(f)).
					collect(Collectors.joining(","));
		out.print(foodStr);
	
		
			
	}
}
