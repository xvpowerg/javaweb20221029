package tw.com.ws;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@Path("myuser")
@Produces(MediaType.APPLICATION_JSON)
public class TestMyUserWs {
	@EJB
	private MyUserBeanLocal myUserBean;
	public class Msg{
		private String msg;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
	}
	
	@POST
	public Response regisrter(@FormParam("account") String account,
						      @FormParam("passwprd") String password) {
		MyUser myUser = new MyUser();
		
		myUser.setAccount(account);
		myUser.setPassword(password);
		boolean pass = myUserBean.regisrter(myUser);
		if (pass) {
			return Response.ok().encoding("UTF-8").entity(myUser).build();
		}
		Msg erroMsg = new Msg();
		erroMsg.setMsg("fail");
		return Response.status(400).entity(erroMsg).build();
	}
	
}
