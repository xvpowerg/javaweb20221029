package tw.com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MsgHelloTag  extends TagSupport{
	private String message;
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}
	
	@Override
	public int doEndTag() throws JspException {
		 PageContext pageContext =  this.pageContext;
		 JspWriter out =  pageContext.getOut();
		 String msg = String.format("<font size=6 color='red'>%s§A¦n</font>",message);
		// TODO Auto-generated method stub
		 try {
			out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		}
		return EVAL_PAGE;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
