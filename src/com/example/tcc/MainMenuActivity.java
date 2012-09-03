package com.example.tcc;

import com.example.tcc.models.User;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends Activity {
	
	Button btn_cases_list;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        btn_cases_list = (Button) findViewById(R.id.main_menu_btn_select_cases);
        
        btn_cases_list.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				MainMenuActivity.this.startActivity(new Intent(MainMenuActivity.this,
						CasesListActivity.class));
			}        	
        });
        
        //Obtém o usuário atual
        User current_user = ((GlobalStateApp) getApplication()).getCurrentUser();
        
        if(current_user.username != null){
        	TextView welcome = (TextView) findViewById(R.id.main_menu_welcome_text);
        	welcome.setText("Bem vindo "+current_user.username);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }
}
