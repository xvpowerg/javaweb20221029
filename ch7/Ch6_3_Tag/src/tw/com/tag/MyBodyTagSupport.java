package tw.com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MyBodyTagSupport extends BodyTagSupport{
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		try {
		
			BodyContent bodyContent =   this.getBodyContent();
			String body = bodyContent.getString();
			JspWriter out =   bodyContent.getEnclosingWriter();
			if (body != null) {
				out.println(body.toUpperCase());
			}
		}catch(IOException ex) {
			System.out.println(ex);
		}
		
		return SKIP_BODY;
	}
}
