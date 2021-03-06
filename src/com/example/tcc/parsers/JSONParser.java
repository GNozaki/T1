package com.example.tcc.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.tcc.BackGroundTask;

import android.util.Log;

public class JSONParser {
	 
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
 
    // constructor
    public JSONParser() {
 
    }
 
    public JSONObject getJSONFromUrl(String url,String method, List<NameValuePair> params) {

    	BackGroundTask Task = new BackGroundTask(url, method, params);
    	try{
    		return Task.execute().get();
    	} catch (InterruptedException e){
    		e.printStackTrace();
    		return null;
    	} catch (ExecutionException e){
    		e.printStackTrace();
    		return null;
    	}
    	
    }
}