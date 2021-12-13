package Modelagem;

public class Modelo {

	private String nome;
	
	public Modelo(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public String toString() {
		return "Modelo: " + this.nome;
	}

}
