package com.example.tcc;

import com.example.tcc.models.Caso;
import com.example.tcc.models.Usuario;

import android.app.Application;

public class GlobalStateApp extends Application {
	private Usuario current_user;
	private Caso case_selected;
	
	public Usuario getCurrentUser(){
		return current_user;
	}
	
	public void setCurrentUser(Usuario pUser){
		this.current_user = pUser;
	}
	
	public Caso getCaseSelected(){
		return case_selected;
	}
	
	public void setCaseSelected(Caso pCase){
		this.case_selected = pCase;
	}
}
