package com.example.tcc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }
}
