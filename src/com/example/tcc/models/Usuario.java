package com.example.tcc.models;

public class Usuario {
	public int id;
	public String android_id;
	public String username;
	public int num_celular;
	public String aparelho;
	
	public Usuario (int pId, String pAndroidId, String pUsername){
		this.id = pId;
		this.android_id = pAndroidId;
		this.username = pUsername;		
	}
	
	public Usuario (int pId, String pAndroidId, String pUsername, int pNumeroCelular, String pAparelho){
		this.id = pId;
		this.android_id = pAndroidId;
		this.username = pUsername;
		this.num_celular = pNumeroCelular;
		this.aparelho = pAparelho;
	}
	
	public Usuario (String pAndroidId) {
		this.android_id = pAndroidId;
	}

}
