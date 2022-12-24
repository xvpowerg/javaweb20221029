package tw.com.ws;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestRestful {
	//GET 用來做查詢 不會修該資料
	//POST 用來新增資料
	//PATCH 可用來修改資料
	//DELETE 用來刪除資料
		@GET
		public  String testHello() {
			return "{\"value\":\"Hello\"}";
		}
		
		@GET
		@Path("id")
		public String queryUserById(@QueryParam("myId") String id) {
			return "{\"id\":\""+id+"\"}";
		}
		// user/qwer123
		@GET
		@Path("/user/{myId:\\S+}")
		public String queryUser(@PathParam("myId") String id) {
			return "{\"id\":\""+id+"\"}";
		}
		
		@POST
		public String testPost(@QueryParam("name") String name,@QueryParam("pwd") String pass) {
			System.out.println("testPost1:");
			return String.format("{\"name\":\"%s\","
					+ "			\"pass\":\"%s\"}", 
					name,pass);
		}
		
		@POST
		@Path("test_post")
		public String testPost2(@FormParam("name") String name,@FormParam("pwd") String pass) {
			System.out.println("testPost2:");
			
			return  String.format("{\"name\":\"%s\","
					+ "			\"pass\":\"%s\"}", 
					name,pass);
		}
		
		@PATCH
		public String update(@QueryParam("id") Long id,
					@DefaultValue("empty") @QueryParam("name") String name,
					@DefaultValue("-1") @QueryParam("age") int age){
			
			String json = String.format("{\"id\":%d, \"name\":\"%s\",\"age\":%d}",id,name,age );
			return json;
		}
		
			
}
