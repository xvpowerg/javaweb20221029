package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.User;
import tw.com.db.DbTools;
import tw.com.db.MySqlUser;
import tw.com.db.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//			PrintWriter out = resp.getWriter();
//			out.println("Page1");
//			String url = "jdbc:mysql://localhost:3306/testdb20221217?serverTimezone=CST&useSSL=false&allowPublicKeyRetrieval=true";
//			String user = "root";
//			String password = "123456";
//			try(Connection con = DriverManager.getConnection(url,user,password)){
//				
//			}catch(SQLException ex) {
//				System.out.println(ex);
//			}
		
//		try {
//			Connection conn = DbTools.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
		UserDao userDao= new MySqlUser();
//		boolean b1 = userDao.regisrter("Ken", "12345");
//		System.out.println(b1);
		
//		User user = userDao.findUserByAccount("ken");
//		System.out.println(user);
		boolean b1 = userDao.login("ken", "12345");
		boolean b2 = userDao.login("ken", "123456");
		System.out.println(b1);
		System.out.println(b2);
		
	}
}
