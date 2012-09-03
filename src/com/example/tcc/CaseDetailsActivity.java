package com.example.tcc;

import com.example.tcc.models.Case;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class CaseDetailsActivity extends Activity {

	Case showing_case = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);
        
        showing_case = ((GlobalStateApp) getApplication()).getCaseSelected();
        
        TextView text_case_name = (TextView) findViewById(R.id.case_details_casename);
        TextView text_case_description = (TextView) findViewById(R.id.case_details_casedescription);
        
        text_case_name.setText(showing_case.name);
        text_case_description.setText(showing_case.details);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_case_details, menu);
        return true;
    }
}
