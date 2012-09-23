package com.example.tcc.models;

public class Caso {
	public int id;
	public String titulo;
	public String resumo;
	public String descricao;
	public String info_parte;
	public String info_contraparte;
	public String perfil_parte;
	public String perfil_contraparte;
	
	public Caso (int pId, String pTitulo, String pResumo, String pDescricao, String pInfoParte, String pInfoContraparte, String pPerfilParte, String pPerfilContraParte){
		this.id = pId;
		this.titulo = pTitulo;
		this.resumo = pResumo;
		this.descricao = pDescricao;
		this.info_parte = pInfoParte;
		this.info_contraparte = pInfoContraparte;
		this.perfil_parte = pPerfilParte;
		this.perfil_contraparte = pPerfilContraParte;	
	}
	
	public Caso (int pId, String pTitulo){
		this.id = pId;
		this.titulo = pTitulo;
	}
	
	@Override
	public String toString() {
		return this.titulo;
	}
}
