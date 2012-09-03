package com.example.tcc.models;

public class User {
	public int id;
	public String android_id;
	public String username;
	public String email;
	
	public User (int pId, String pAndroidId, String pUsername, String pEmail){
		this.id = pId;
		this.android_id = pAndroidId;
		this.username = pUsername;
		this.email = pEmail;
	}
	
	public User (String pAndroidId) {
		this.android_id = pAndroidId;
	}

}
