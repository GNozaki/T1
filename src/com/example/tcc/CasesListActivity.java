package com.example.tcc;

import java.util.ArrayList;

import com.example.tcc.adapters.CaseListAdapter;
import com.example.tcc.models.Case;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
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
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cases_list, menu);
        return true;
    }
}
