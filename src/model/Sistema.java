package model;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private static Sistema instancia = null; 
	private List<Senha> senhasChamadas;
	private List<Senha> senhasGeradas;
	private int senha;
	
	//filas
	private Fila fila1, fila2, fila3, fila4, fila5, fila6, fila7, fila8;
	
	private Sistema(){
		senhasChamadas = new ArrayList<Senha>();
		senhasGeradas = new ArrayList<Senha>();
		senha = 1;
		
		fila1 = new Fila("");
		fila2 = new Fila("");
		fila3 = new Fila("");
		fila4 = new Fila("");
		fila5 = new Fila("");
		fila6 = new Fila("");
		fila7 = new Fila("");
		fila8 = new Fila("");
	}
	
	public static Sistema getInstance(){
		if (instancia == null){
			instancia = new Sistema();
		}
		
		return instancia;
	}
	
	public Senha gerarSenha(int fila){
		Senha s = new Senha(senha);
		senha++;
		switch (fila) {
		case 1:
			fila1.addSenha(s);
			break;
		case 2:
			fila2.addSenha(s);		
			break;
		case 3:
			fila3.addSenha(s);
			break;
		case 4:
			fila4.addSenha(s);
			break;
		case 5:
			fila5.addSenha(s);
			break;
		case 6:
			fila6.addSenha(s);
			break;
		case 7:
			fila7.addSenha(s);
			break;
		case 8:
			fila8.addSenha(s);
			break;
		default:
			break;
		}
		senhasGeradas.add(0, s);
		return s;
	}
	
	public Senha chamarSenha(int fila){
		Senha s = null;
		switch (fila) {
		case 1:
			s = fila1.chamarSenha();
			break;
		case 2:
			s = fila2.chamarSenha();		
			break;
		case 3:
			s = fila3.chamarSenha();
			break;
		case 4:
			s = fila4.chamarSenha();
			break;
		case 5:
			s = fila5.chamarSenha();
			break;
		case 6:
			s = fila6.chamarSenha();
			break;
		case 7:
			s = fila7.chamarSenha();
			break;
		case 8:
			s = fila8.chamarSenha();
			break;
		default:
			break;
		}
		
		if (s != null){
			senhasChamadas.add(0, s);
		}
		return s;
	}
	
	public Senha getSenhaGerada(int i){
		if (senhasGeradas.size() <= i){
			return new Senha(0);
		}
		return senhasGeradas.get(i);
	}
	
	public Senha getSenhaChamada(int i){
		if (senhasChamadas.size() <= i){
			return new Senha(0);
		}
		return senhasChamadas.get(i);
	}
}
