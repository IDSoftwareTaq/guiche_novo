package model;

import java.util.ArrayList;
import java.util.List;

public class Fila {
	
	String nome;
	List<Senha> senhas;
	
	public Fila(String nome){
		this.nome = nome;
		senhas = new ArrayList<Senha>();
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void addSenha(Senha senha){
		senha.setNomeFila(nome);
		senhas.add(senha);
	}
	
	public Senha chamarSenha(){
		if (senhas.size() > 0){
			return senhas.remove(0);
		}
		return null;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Fila)){
			return false;
		}
		
		if (((Fila) obj).getNome().equals(nome)){
			return true;
		}
		
		return false;
	}
}
