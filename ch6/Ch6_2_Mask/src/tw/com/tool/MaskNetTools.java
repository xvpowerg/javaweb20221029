package tw.com.tool;
import java.io.IOException;
import java.util.function.Consumer;

import javax.servlet.AsyncContext;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tw.com.beans.JsonToWebInfo;
public class MaskNetTools {
	private final static String MASK_URL = "https://raw.githubusercontent.com/kiang/pharmacies/master/json/points.json";
	
	public static void downloadMaskJson(AsyncContext contex,Consumer<JsonToWebInfo> callback) {
		
		OkHttpClient client = 
				new OkHttpClient().newBuilder().build();
		Request okRequest = 
				new Request.Builder().url(MASK_URL).build();
		Call call = client.newCall(okRequest);
		call.enqueue(new Callback() {

			@Override
			public void onFailure(Call arg0, IOException ex) {
				// TODO Auto-generated method stub
				System.out.println("Faulure:"+ex);
			}

			@Override
			public void onResponse(Call arg0, Response respon) throws IOException {
				// TODO Auto-generated method stub
				JsonToWebInfo jsonToWebInfo = new JsonToWebInfo();
				jsonToWebInfo.setCtx(contex);
				jsonToWebInfo.setReq(contex.getRequest());
				jsonToWebInfo.setResp(contex.getResponse());
				String result = respon.body().string();
				jsonToWebInfo.setJson(result);
				callback.accept(jsonToWebInfo);
			}
			
			
			
		});
		
	}
	
	
}
