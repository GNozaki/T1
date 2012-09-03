package com.example.tcc;

import java.util.ArrayList;

import com.example.tcc.adapters.CaseListAdapter;
import com.example.tcc.models.Case;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class CasesListActivity extends Activity {

	/*
	 * Layout de lista que conterá os casos para selecionar
	 */
	ListView lstTest;
	
	/*
	 * Lista que conterá os casos. 
	 */
	ArrayList<Case> lst_casos = null;
	
	/*
	 * Adapter da lista de casos
	 */
	CaseListAdapter case_adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_list);
        
        //Obtém a lista da interface
        lstTest = (ListView) findViewById(R.id.cases_list_select);
        
        CaseFunctions caseFunctions = new CaseFunctions();
        //caseFunctions.getListCases();
        
        //Inicializa a lista de casos
        lst_casos = new ArrayList<Case>();
        
        case_adapter = new CaseListAdapter(CasesListActivity.this, android.R.layout.simple_list_item_1, lst_casos);
        
        lstTest.setAdapter(case_adapter);
        
        //Parte de teste
        //lst_casos.add(new Case("Caso 1"));
        //lst_casos.add(new Case("Caso 2"));
        //Log.i("DEBUG", ""+caseFunctions.getArrayOfCases().size());
        lst_casos.addAll(caseFunctions.getArrayOfCases());
        
        case_adapter.notifyDataSetChanged();
        
        lstTest.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Case c = (Case) lstTest.getItemAtPosition(position);
				//Log.i("DEBUG", c.name);
				((GlobalStateApp) getApplication()).setCaseSelected(c);
				CasesListActivity.this.startActivity(new Intent(CasesListActivity.this,
						CaseDetailsActivity.class));
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cases_list, menu);
        return true;
    }
}
