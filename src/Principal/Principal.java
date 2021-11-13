package Principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;

public class Principal {

	// atributos static são atributos de classe
	private static Carro[] vagas = new Carro[100]; // o estacionamento tem 100 vagas numeradas de 0..99
	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	private static ArrayList<Carro> historico = new ArrayList<Carro>();
	private static Scanner scanner = new Scanner(System.in);

	// eventualmente outros atributos static

	public static void main(String[] args) {
		int opcao;
		// ctrl + space
		
		// criando pra teste
		Carro c1 = new Carro(null, "AUX-1234", LocalDateTime.now());  // tudo isso vai estar dentro de um método que vai perguntar a placa e modelo
		vagas[0] = c1;
		
		// menu principal
		do {
			System.out.println("\n==> menu\n");
			System.out.println("   0 - cadastrar entrada do carro");
			System.out.println("   1 - efetuar uma saida de carro");
			System.out.println("   2 - cadastrar marca");
			System.out.println("   3 - cadastrar modelo");
			System.out.println("   4 - mostrar ocupação do estacionamento");
			System.out.println("   5 - mostrar relatório gerencial consolidado");
			opcao = scanner.nextInt();
			
			switch (opcao) {
			case 0:
				System.out.println("\n==> marcas\n");
				System.out.println("   0 - adicionar marca");
				System.out.println("   1 - marca 1");
				System.out.println("   2 - marca 2");
				System.out.println("   3 - marca 3");
				opcao = scanner.nextInt();
				// ao escolher marca e modelo pega a hora de entrada e inclui o carro no estacionamento da menor vaga
				// se for marca nova vai pro case 2
				// se for modelo novo vai pro case 3
				break;
			case 1:
				// pega o numero da vaga em vagas do carro
				// pega a hora de saida com LocalDateTime.now()
				// colocar carro no histórico
				historico.add(vagas[0]);  // coloca o carro da vaga 0 que saiu no histórico
				vagas[0] = null; // libera a vaga
				// calcula valor
				break;
			case 2:
				System.out.println("\n==> marcas cadastradas\n");
				for (Marca marca : marcas) {
					System.out.println(marca.getNome());
				}
				cadastrarMarca();
				break;
			case 3:
				System.out.println("\n==> selecione a marca para adicionar o modelo\n");
				int m = 0;
				for (Marca marca : marcas) {
					System.out.println("   " + m + " - " + marca.getNome());
					m++;
				cadastrarModelo();
				}
				break;			
			case 4:
				// mostra a ocupação do estacionamento, printa vetor vagas com vaga ou ocupada
				for (int i = 0; i < 100; i++) {
					System.out.println((i+1) + ": " + vagas[i]);
				}
				break;
			case 5:		
				//mostrar relatório gerencial consolidado
				// solicita a data de entrada
				}
				
			} while (opcao != 0);
				
		
		
		// outras variaveis locais
		// menu 1, 2, 3, 4 (copiar base trabalho contatos)
		// opcao
		// chamar metodos static que correspondam as opcoes de menu
	}

	private static void entradaCarro() {
		// criar o carro e cadastra-lo no vetor na posicao correta
	}

	private static float saidaCarro() {
		float preco = 0;
		// logica para calcular preco do estacionamento e coloca-lo no historico
		return preco;
	}
	
	private static void cadastrarMarca() {
		System.out.println("\n==> cadastro de marca\n");
		String nome;
		
		scanner.nextLine();
		System.out.print("   marca: ");
		nome = scanner.nextLine();
		
		Marca marca = new Marca(nome);
		marcas.add(marca);
	}
	
	private static void cadastrarModelo() {
		System.out.println("\n==> cadastro de modelo\n");
		String nome;
		
		scanner.nextLine();
		System.out.print("   modelo: ");
		nome = scanner.nextLine();
		
		Modelo modelos = new Modelo(nome);
		//marcas.add(modelos);
	}

	// outros métodos static conforme especificacao do trabalho e necessidades de
	// implementacao
}
