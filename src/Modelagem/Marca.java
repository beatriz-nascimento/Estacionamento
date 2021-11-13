package Modelagem;

import java.util.ArrayList;


public class Marca {

	private String nome;
	private ArrayList<Modelo> modelos;
	
	public Marca(String nome) {
		super();
		this.nome = nome;
		this.modelos = new ArrayList<Modelo>();
	}
	
	public void addModelo(Modelo modelo) {
		this.modelos.add(modelo);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Modelo> getModelos() {
		return modelos;
	}


}
