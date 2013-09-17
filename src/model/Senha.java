package model;

public class Senha {
	
	int senha;
	String nomeFila;
	
	public Senha(int senha){
		this.senha = senha;
		nomeFila = "";
	}
	
	public int getSenha(){
		return senha;
	}
	
	public void setNomeFila(String nome){
		nomeFila = nome;
	}
	
	public String getNomeFila(){
		return nomeFila;
	}
	
	@Override
	public String toString(){
		return String.format("%03d", senha);
	}
}
