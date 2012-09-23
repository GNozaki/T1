package com.example.tcc;

import com.example.tcc.models.Caso;
import com.example.tcc.models.Usuario;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CaseDetailsActivity extends Activity {

	Caso showing_case = null;
	Button btn_start_case_as_part;
	Button btn_start_case_as_counter_part;
	CaseFunctions caseFunctions;
	Usuario current_user;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);
        
        showing_case = ((GlobalStateApp) getApplication()).getCaseSelected();
        
        TextView text_case_name = (TextView) findViewById(R.id.case_details_casename);
        TextView text_case_description = (TextView) findViewById(R.id.case_details_casedescription);
        
        text_case_name.setText(showing_case.titulo);
        text_case_description.setText(showing_case.resumo);
        
        caseFunctions = new CaseFunctions();
        btn_start_case_as_part = (Button) findViewById(R.id.case_details_btn_choose_as_part);
        current_user = ((GlobalStateApp) getApplication()).getCurrentUser();
        
        btn_start_case_as_part.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				caseFunctions.chooseCase(showing_case, current_user, "parte");
			}        	
        });
        
        btn_start_case_as_counter_part = (Button) findViewById(R.id.case_details_btn_choose_as_counter_part);
        btn_start_case_as_counter_part.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				caseFunctions.chooseCase(showing_case, current_user, "contraparte");
			}        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_case_details, menu);
        return true;
    }
}
