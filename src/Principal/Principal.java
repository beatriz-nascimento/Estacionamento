package Principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;

public class Principal<modelo> {

	// atributos static s�o atributos de classe
	private static Carro[] vagas = new Carro[100]; // o estacionamento tem 100 vagas numeradas de 0..99
	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	private static ArrayList<Carro> historico = new ArrayList<Carro>();
	private static Scanner scanner = new Scanner(System.in);
	private static Modelo modelo = new Modelo("");

	public static void main(String[] args) {
		menu();
	}

	private static void menu(){
		int opcao;

		do {
			System.out.println("\n==> menu\n");
			System.out.println("   0 - cadastrar entrada do carro");
			System.out.println("   1 - efetuar uma saida de carro");
			System.out.println("   2 - cadastrar marca");
			System.out.println("   3 - cadastrar modelo");
			System.out.println("   4 - mostrar ocupa��o do estacionamento");
			System.out.println("   5 - mostrar relat�rio gerencial consolidado");
			opcao = scanner.nextInt();

			switch (opcao) {
				case 0:
					System.out.println("\n==> marcas\n");
					System.out.println("   0 - adicionar marca");
					System.out.println("   1 - marca 1");
					System.out.println("   2 - marca 2");
					System.out.println("   3 - marca 3");
					int marcaopt;

					marcaopt = scanner.nextInt();
					switch (marcaopt){
						case 0: entradaCarro();
					}
					// ao escolher marca e modelo pega a hora de entrada e inclui o carro no estacionamento da menor vaga
					// se for marca nova vai pro case 2
					// se for modelo novo vai pro case 3
					break;
				case 1:
					// pega o numero da vaga em vagas do carro
					// pega a hora de saida com LocalDateTime.now()
					// colocar carro no hist�rico
					historico.add(vagas[0]);  // coloca o carro da vaga 0 que saiu no hist�rico
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
					// mostra a ocupa��o do estacionamento, printa vetor vagas com vaga ou ocupada
					for (int i = 0; i < 100; i++) {
						System.out.println((i+1) + ": " + vagas[i]);
					}
					break;
				case 5:
					//mostrar relat�rio gerencial consolidado
					// solicita a data de entrada
			}

		} while (opcao != 0);

	}

	private static void entradaCarro() {
		System.out.println("\nEntrada de carro");
		System.out.print("Insira placa do carro: ");
		String placaCarro = scanner.next();


		System.out.print("Insira modelo do carro: ");
		String modeloCarro = scanner.next();
		System.out.println(modelo);
		Modelo model = new Modelo(modeloCarro);

		Carro carro = new Carro(model, placaCarro, LocalDateTime.now());

		for (int i = 0; i < 100; i++) {
			if(vagas[i]==null){
				vagas[i] = carro;
				break;
			}
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(vagas[i]);
		}

		menu();


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

	// outros m�todos static conforme especificacao do trabalho e necessidades de
	// implementacao
}
