package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.tcc.models.Caso;
import com.example.tcc.models.Usuario;
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
	
	public Usuario getUser(String pAndroidId){
		Usuario retorno = null;
		JSONObject jsonObj = getUserByAndroidId(pAndroidId);
		
		try {
			JSONArray jsonArray = jsonObj.getJSONArray("user");
			for(int i=0; i < jsonArray.length();i++){
				JSONObject childObject = jsonArray.getJSONObject(i);
				int id = childObject.getInt("id");
				int num_cell = childObject.getInt("num_celular");
				String username = childObject.getString("username");
				String aparelho = childObject.getString("aparelho");
				Usuario usuario = new Usuario(id, pAndroidId, username, num_cell, aparelho);
				retorno = usuario;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		
		return retorno;
	}
}
