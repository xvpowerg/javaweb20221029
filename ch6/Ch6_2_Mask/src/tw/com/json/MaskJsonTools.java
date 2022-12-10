package tw.com.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.beans.JsonToWebInfo;
import tw.com.beans.Mask;

public class MaskJsonTools {
	public static void maskJsonToObj(JsonToWebInfo jsonToWebInfo,
			Consumer<JsonToWebInfo> maskListCallBack) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper  objMapper = new ObjectMapper();	
		Map map = objMapper.readValue(jsonToWebInfo.getJson(), Map.class);
		List<Map<String,Object>> list =
				(List<Map<String,Object>>)map.get("features");
		List<Mask> maskList = new ArrayList();
		
		for(Map<String,Object> dataMap : list) {
			Map<String,Object> pMap = (Map<String,Object>)dataMap.get("properties");
			Mask mask = new Mask();
			mask.setId(pMap.get("id").toString());//id
			mask.setName(pMap.get("name").toString());//name
			mask.setMaskAdult(pMap.get("mask_adult").toString());//mask_adult
			mask.setMaskChild(pMap.get("mask_child").toString());//mask_child
			
			maskList.add(mask);
		}
		jsonToWebInfo.setMaskList(maskList);
		maskListCallBack.accept(jsonToWebInfo);
		
	}
}
