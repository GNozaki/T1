package com.example.tcc.adapters;

import java.util.List;

import com.example.tcc.models.Case;

import android.content.Context;
import android.widget.*;

public class CaseListAdapter extends ArrayAdapter<Case> {
    int resource;
    String response;
    Context context;

    //Inicializando o adapter
    public CaseListAdapter(Context context, int resource, List<Case> items) {
        super(context, resource, items);
        this.resource=resource;
    }


}
