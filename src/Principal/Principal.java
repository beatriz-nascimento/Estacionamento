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

	public static void main(String[] args)
	{
		int opcao;
		String marcaSelecionada;
		// ctrl + space
		
		// criando pra teste
		Carro c1 = new Carro(null, "AUX-1234", LocalDateTime.now());  // tudo isso vai estar dentro de um método que vai perguntar a placa e modelo
		vagas[0] = c1;
		
		// menu principal
		do {
			System.out.println("\n==> menu\n");
			System.out.println("   0 - cadastrar entrada do carro");
			System.out.println("   1 - efetuar uma saida de carro");
			System.out.println("   2 - mostrar ocupação do estacionamento");
			System.out.println("   3 - mostrar relatório gerencial consolidado");
			System.out.println("\n selecione a opção desejada: ");
			opcao = scanner.nextInt();
			
			switch (opcao)
			{
				case 0:
					System.out.println("\n==> *cadastrar entrada*\n");				
					// printa as marcas e modelos e pega hora de entrada
					System.out.println("\n==> selecione a marca desejada, se não estiver na lista digite 0 para adicionar\n");
					
					for (Marca marca : marcas)
					{
						System.out.println(marca.getNome());
					}
					
					int posicaoMarca = scanner.nextInt();
					
					if (posicaoMarca == 0)
					{
						cadastrarMarca();
					}
					else
					{
						//entra e escolher modelo
						marcaSelecionada = marcas.get(posicaoMarca-1).getNome();
						
						if (marcaSelecionada != null)
						{
							System.out.println("lista de modelos da marca" + marcaSelecionada.toLowerCase() + ":");
							
							for (int i = 0; i < marcas.get(posicaoMarca-1).getModelos().size(); i++)
							{
								System.out.println((i+1) + " - " + marcas.get(posicaoMarca-1).getModelos().get(i));
							}
						/*System.out.println("\n==> selecione a marca para adicionar o modelo\n");
						int m = 0;
						for (Marca marca : marcas) {
							System.out.println("   " + m + " - " + marca.getNome());
							m++;
						cadastrarModelo(int posicao);*/
						}
					
	
					}
					System.out.println("cheguei até aqui");
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
					// mostra a ocupação do estacionamento, printa vetor vagas com vaga ou ocupada
					for (int i = 0; i < 100; i++)
					{
						System.out.println((i+1) + ": " + vagas[i]);
					}
					break;
					
				case 3:
					//mostrar relatório gerencial consolidado
					// solicita a data de entrada
					break;
			}
				
		} while (opcao != 999);
				
		
		
		// outras variaveis locais
		// menu 1, 2, 3, 4 (copiar base trabalho contatos)
		// opcao
		// chamar metodos static que correspondam as opcoes de menu
	}

	private static void entradaCarro()
	{
		// criar o carro e cadastra-lo no vetor na posicao correta
	}

	private static float saidaCarro()
	{
		float preco = 0;
		// logica para calcular preco do estacionamento e coloca-lo no historico
		return preco;
	}
	
	private static void cadastrarMarca()
	{
		String nomeMarca, nomeModelo;
		
		System.out.println("\n==> modelos disponíveis\n");
		
		System.out.print("   marca: ");
		nomeMarca = scanner.next();
		
		Marca marca = new Marca(nomeMarca);
		marcas.add(marca);
		
		System.out.println("\n==> cadastro de modelo\n");
		
		System.out.print("   modelo: ");
		nomeModelo = scanner.next();
		
		Modelo modelos = new Modelo(nomeModelo);
		marca.addModelo(modelos);
	}
	
	private static void cadastrarModelo(int posicao)
	{
		String nomeModelo;
		
		System.out.println("\n==> cadastro de modelo\n");
		
		System.out.print("   modelo: ");
		nomeModelo = scanner.next();
		
		Modelo modelos = new Modelo(nomeModelo);
		marcas.get(posicao).addModelo(modelos);
	}

	// outros métodos static conforme especificacao do trabalho e necessidades de
	// implementacao
}
