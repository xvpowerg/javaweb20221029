package tw.com.beans;

import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class JsonToWebInfo {
	
	private ServletRequest req;
	private ServletResponse resp;
	private AsyncContext ctx;
	private String json;
	private List<Mask> list;
	
	public AsyncContext getCtx() {
		return ctx;
	}
	public void setCtx(AsyncContext ctx) {
		this.ctx = ctx;
	}
	public ServletRequest getReq() {
		return req;
	}
	public void setReq(ServletRequest req) {
		this.req = req;
	}
	public ServletResponse getResp() {
		return resp;
	}
	public void setResp(ServletResponse resp) {
		this.resp = resp;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public List<Mask> getMaskList() {
		return list;
	}
	public void setMaskList(List<Mask> list) {
		this.list = list;
	}
	
	
	
}
