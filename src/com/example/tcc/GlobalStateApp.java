package com.example.tcc;

import com.example.tcc.models.Case;
import com.example.tcc.models.User;

import android.app.Application;

public class GlobalStateApp extends Application {
	private User current_user;
	private Case case_selected;
	
	public User getCurrentUser(){
		return current_user;
	}
	
	public void setCurrentUser(User pUser){
		this.current_user = pUser;
	}
	
	public Case getCaseSelected(){
		return case_selected;
	}
	
	public void setCaseSelected(Case pCase){
		this.case_selected = pCase;
	}
}
