package Principal;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    private static Modelo modelo = new Modelo("");


    public static void main(String[] args) {
        do {
            menu();
        }
        while (true);
    }

	public static void menu()
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
					entradaCarro();
					System.out.println("cheguei até aqui");
					break;

				case 1:
					Carro car = saidaCarro();
					System.out.println(car + ", preço a pagar: R$" + car.getValor());
					historico.add(car);
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


    private static void entradaCarro() {
        System.out.println("\nEntrada de carro");
        System.out.print("Insira placa do carro: ");
        String placaCarro = scanner.next();


        System.out.print("Insira modelo do carro: ");
        String modeloCarro = scanner.next();
        System.out.println("\nEstacionamento:");

        Modelo model = new Modelo(modeloCarro);

        Carro carro = new Carro(model, placaCarro, LocalDateTime.now());

        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == null) {
                vagas[i] = carro;
                break;
            }
        }
        for (int i = 0; i < vagas.length; i++) {
            System.out.println((i + 1) + ": " + vagas[i]);
        }

    }

    private static Carro saidaCarro() {
		String indexStr;
		Carro car;
		int index;
		long minutos;
		float valor;

		// Leitura do Index
		System.out.print("\nInsira a posição do carro a ser retirado: ");
		indexStr = scanner.next();
		index = Integer.parseInt(indexStr);

		// Remoção do carro
		car = vagas[index];
		vagas[index] = null;

		// Set da hora de saída
		car.setSaida(LocalDateTime.of(2021, 11, 14, 20, 22));

		// Cálculo do valor a ser cobrado
		minutos = ChronoUnit.MINUTES.between(car.getsaida(), car.getEntrada()) - 60;
		valor = (float) Math.ceil(minutos / 15.0);
		valor = valor < 0 ? 10 : 10 + valor * 2;

		// Set do valor a ser cobrado
		car.setvalor(valor);

		// TODO logica para calcular preco do estacionamento e coloca-lo no historico
		return car;

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
