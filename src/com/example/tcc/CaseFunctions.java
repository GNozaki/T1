package com.example.tcc;

import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.tcc.models.Case;
import com.example.tcc.parsers.JSONParser;
 
import android.util.Log;;

public class CaseFunctions {
	private JSONParser jsonParser;
	
	//Testando em localhost usando wamp
	//Tem que usar http://10.0.2.2/ ao invés de http://localhost/
	private static String api_url = "http://10.0.2.2/tcc/";
	
	public CaseFunctions(){
		jsonParser = new JSONParser();
	}
	
	/*
	 * function getListCases
	 */
	public JSONObject getListCases(){
		// Montando parâmetros
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jsonParser.getJSONFromUrl(api_url+"get_list_of_cases.php", "GET", params);
		return json;
	}
	
	public ArrayList<Case> getArrayOfCases(){
		ArrayList<Case> retorno = new ArrayList<Case>();
		JSONObject jsonObj = getListCases();
		
		try {
			JSONArray jsonArray = jsonObj.getJSONArray("list");
			for(int i=0; i < jsonArray.length();i++){
				JSONObject childObject = jsonArray.getJSONObject(i);
				int id = childObject.getInt("id");
				String name = childObject.getString("name");
				String details = childObject.getString("details");
				Case newCase = new Case(id, name, details);
				retorno.add(newCase);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		
		return retorno;
	}
}
