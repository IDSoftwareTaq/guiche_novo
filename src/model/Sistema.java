package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


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
		Fila f = null;
		
		switch (fila) {
		case 1:
			f = fila1;
			break;
		case 2:
			f = fila2;		
			break;
		case 3:
			f = fila3;
			break;
		case 4:
			f = fila4;
			break;
		case 5:
			f = fila5;
			break;
		case 6:
			f = fila6;
			break;
		case 7:
			f = fila7;
			break;
		case 8:
			f = fila8;
			break;
		default:
			break;
		}
		if (f != null){
			if (!(f.getNome().equals(""))){
				senha++;
				f.addSenha(s);
				senhasGeradas.add(0, s);
			}
		}
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
			Thread t = new Thread(new Play());
			t.start();
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
	
	public void setNomes(String nome1, String nome2, String nome3, String nome4, String nome5, String nome6, String nome7, String nome8){
		fila1.setNome(nome1);
		fila2.setNome(nome2);
		fila3.setNome(nome3);
		fila4.setNome(nome4);
		fila5.setNome(nome5);
		fila6.setNome(nome6);
		fila7.setNome(nome7);
		fila8.setNome(nome8);
	}
	
	private void tocaMusica(){
		try {
            File soundFile = new File("C:/guiche/som.wav");  
            AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);  
            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());  
            Clip clip = (Clip) AudioSystem.getLine(info);  
            clip.open(sound);  
            clip.start();  
         }catch (Exception ex){
           ex.printStackTrace();
         }
	}

	public class Play implements Runnable{

		@Override
		public void run() {
			tocaMusica();
		}

	}
	
	public String getNome(int fila){
		String nome = "";
		
		switch (fila) {
		case 1:
			nome = fila1.getNome();
			break;
		case 2:
			nome = fila2.getNome();		
			break;
		case 3:
			nome = fila3.getNome();
			break;
		case 4:
			nome = fila4.getNome();
			break;
		case 5:
			nome = fila5.getNome();
			break;
		case 6:
			nome = fila6.getNome();
			break;
		case 7:
			nome = fila7.getNome();
			break;
		case 8:
			nome = fila8.getNome();
			break;
		default:
			break;
		}
		return nome;
	}
}
