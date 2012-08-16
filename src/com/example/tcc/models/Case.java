package com.example.tcc.models;

public class Case {
	public int id;
	public String name;
	public String details;
	
	public Case (int pId, String pName, String pDetails){
		this.id = pId;
		this.name = pName;
		this.details = pDetails;
	}
	
	public Case (String pName){
		this.name = pName;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
