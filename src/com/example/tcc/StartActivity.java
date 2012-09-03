package com.example.tcc;

import com.example.tcc.models.User;

import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		final Button btn_ok = (Button) findViewById(R.id.splash_btn_ok);

		btn_ok.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				StartActivity.this.startActivity(new Intent(StartActivity.this,
						MainMenuActivity.class));
			}
		});
		
		//Obtém o android_id do device android
		String android_id =  Secure.getString(getContentResolver(), Secure.ANDROID_ID);
		
		//Faz a requisição para checar se o usuário já usou o aplicativo
		UserFunctions userFunctions = new UserFunctions();
		User actual_user = userFunctions.getUser(android_id);
		
		//Grava o usuário atual utilizado
		GlobalStateApp globalApp = (GlobalStateApp) getApplication();
		globalApp.setCurrentUser(actual_user);
		
		//Linha para testar só
		//btn_ok.setText(actual_user.email);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_start, menu);
		return true;
	}
}
