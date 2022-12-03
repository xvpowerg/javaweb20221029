package tw.com.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view_images")
public class ViewImageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Path path = Paths.get("C:","upload_images");	
		 List<String> fileNamesList = 
				 Files.list(path).map(p->p.getFileName().
						 toString()).collect(Collectors.toList());
		 PrintWriter out =  resp.getWriter();
		 out.print("<html>");
		 out.print("<body>");
		
		 for(String file: fileNamesList) {
			 out.print("<div>");
			 out.print("<img width='30%' height='30%' src=/myimages/"+file+">");
			 out.print("</div>");
		 }
		 
		 out.print("</body>");
		 out.print("</html>");
		 System.out.println(fileNamesList);
		
	}

}
