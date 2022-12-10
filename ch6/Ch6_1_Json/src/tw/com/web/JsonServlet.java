package tw.com.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/testJson")
public class JsonServlet  extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			String json ="{\r\n" + 
					"  \"squadName\" : \"Super hero squad\",\r\n" + 
					"  \"homeTown\" : \"Metro City\",\r\n" + 
					"  \"formed\" : 2016,\r\n" + 
					"  \"secretBase\" : \"Super tower\",\r\n" + 
					"  \"active\" : true,\r\n" + 
					"  \"members\" : [\r\n" + 
					"    {\r\n" + 
					"      \"name\" : \"Molecule Man\",\r\n" + 
					"      \"age\" : 29,\r\n" + 
					"      \"secretIdentity\" : \"Dan Jukes\",\r\n" + 
					"      \"powers\" : [\r\n" + 
					"        \"Radiation resistance\",\r\n" + 
					"        \"Turning tiny\",\r\n" + 
					"        \"Radiation blast\"\r\n" + 
					"      ]\r\n" + 
					"    },\r\n" + 
					"    {\r\n" + 
					"      \"name\" : \"Madame Uppercut\",\r\n" + 
					"      \"age\" : 39,\r\n" + 
					"      \"secretIdentity\" : \"Jane Wilson\",\r\n" + 
					"      \"powers\" : [\r\n" + 
					"        \"Million tonne punch\",\r\n" + 
					"        \"Damage resistance\",\r\n" + 
					"        \"Superhuman reflexes\"\r\n" + 
					"      ]\r\n" + 
					"    },\r\n" + 
					"    {\r\n" + 
					"      \"name\" : \"Eternal Flame\",\r\n" + 
					"      \"age\" : 1000000,\r\n" + 
					"      \"secretIdentity\" : \"Unknown\",\r\n" + 
					"      \"powers\" : [\r\n" + 
					"        \"Immortality\",\r\n" + 
					"        \"Heat Immunity\",\r\n" + 
					"        \"Inferno\",\r\n" + 
					"        \"Teleportation\",\r\n" + 
					"        \"Interdimensional travel\"\r\n" + 
					"      ]\r\n" + 
					"    }\r\n" + 
					"  ]\r\n" + 
					"}";
			System.out.println(json);
			ObjectMapper objMapper = new ObjectMapper();
			Map map = objMapper.readValue(json, Map.class);
			System.out.println(map.get("squadName"));
			System.out.println(map.get("active"));
			List<Map> mapList = (List<Map>)map.get("members");
			for(Map data : mapList) {
				System.out.println(data.get("name")+":"+data.get("age"));
			}
			
		}
}
