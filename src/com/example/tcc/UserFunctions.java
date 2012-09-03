package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.tcc.models.Case;
import com.example.tcc.models.User;
import com.example.tcc.parsers.JSONParser;

public class UserFunctions {
	private JSONParser jsonParser;
	
	//Testando em localhost usando wamp
	//Tem que usar http://10.0.2.2/ ao invés de http://localhost/
	private static String api_url = "http://10.0.2.2/tcc/";
	
	public UserFunctions(){
		jsonParser = new JSONParser();
	}
	
	private JSONObject getUserByAndroidId(String pAndroidId){
		// Montando parâmetros
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("android_id", pAndroidId));
		JSONObject json = jsonParser.getJSONFromUrl(api_url+"get_user_data.php", "POST", params);
		return json;
	}
	
	public User getUser(String pAndroidId){
		User retorno = null;
		JSONObject jsonObj = getUserByAndroidId(pAndroidId);
		
		try {
			JSONArray jsonArray = jsonObj.getJSONArray("user");
			for(int i=0; i < jsonArray.length();i++){
				JSONObject childObject = jsonArray.getJSONObject(i);
				int id = childObject.getInt("id");
				String username = childObject.getString("username");
				String email = childObject.getString("email");
				User user = new User(id, pAndroidId, username, email);
				retorno = user;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		
		return retorno;
	}
}
