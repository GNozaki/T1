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
	private JSONObject getListCases(){
		// Montando parâmetros
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jsonParser.getJSONFromUrl(api_url+"get_list_of_cases.php", "GET", params);
		return json;
	}
	
	public ArrayList<Caso> getArrayOfCases(){
		ArrayList<Caso> retorno = new ArrayList<Caso>();
		JSONObject jsonObj = getListCases();
		
		try {
			JSONArray jsonArray = jsonObj.getJSONArray("list");
			for(int i=0; i < jsonArray.length();i++){
				JSONObject childObject = jsonArray.getJSONObject(i);
				
				int id = childObject.getInt("id");
				String title = childObject.getString("titulo");
				String resumo = childObject.getString("resumo");
				String description = childObject.getString("descricao");
				String info_parte = childObject.getString("info_parte");
				String info_contraparte = childObject.getString("info_contraparte");
				String perfil_parte = childObject.getString("perfil_parte");
				String perfil_contraparte = childObject.getString("perfil_contraparte");
				Caso newCase = new Caso(id, title, resumo, description, info_parte, info_contraparte, perfil_parte, perfil_contraparte);
				retorno.add(newCase);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		
		return retorno;
	}
	/*
	 * Escolhe um caso
	 */
	private JSONObject saveCaseChoice(int case_id, int user_id, String lado){
		// Montando parâmetros
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("user_id", String.valueOf(user_id)));
		params.add(new BasicNameValuePair("case_id", String.valueOf(case_id)));
		params.add(new BasicNameValuePair("side", lado));
		
		JSONObject json = jsonParser.getJSONFromUrl(api_url+"choose_case.php", "POST", params);
		return json;
	}
	
	public void chooseCase(Caso selected_case, Usuario current_user, String side){
		JSONObject jsonObj = saveCaseChoice(selected_case.id, current_user.id, side);
	}
}
