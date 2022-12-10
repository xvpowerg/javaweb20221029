package tw.com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.JsonToWebInfo;
import tw.com.beans.Mask;
import tw.com.json.MaskJsonTools;
import tw.com.tool.MaskNetTools;

@WebServlet(urlPatterns = "/mask",asyncSupported = true)
public class MaskServlet extends HttpServlet {

	
	private void jsonToObj(JsonToWebInfo jsonInfo) {				
		
		ServletRequest req = jsonInfo.getReq();
		req.setAttribute("maskList", jsonInfo.getMaskList());
		try {
			req.getRequestDispatcher("/mask.jsp").
			forward(req, jsonInfo.getResp());
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jsonInfo.getCtx().complete();	
		}
		
	}
	private void downloadMaskJson(JsonToWebInfo jsonInfo) {
		try {
			MaskJsonTools.maskJsonToObj(jsonInfo, this::jsonToObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("downloadMaskJson:"+e);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AsyncContext contxt = req.startAsync();
		MaskNetTools.downloadMaskJson(contxt,this::downloadMaskJson);
	}
}
