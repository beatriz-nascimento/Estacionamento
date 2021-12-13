package Principal;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;

public class Principal {

    private static Carro[] vagas = new Carro[100]; // o estacionamento tem 100 vagas numeradas de 0..99
    private static ArrayList<Marca> marcas = new ArrayList<Marca>();
    private static ArrayList<Carro> historico = new ArrayList<Carro>();
    private static Scanner scanner = new Scanner(System.in);
    private static Modelo modelo = new Modelo("");

    public static void main(String[] args) {
		// Valores default para teste
		Carro c1 = new Carro(new Modelo("Uno"), "AUX-1234", LocalDateTime.now().minusHours(6));
		marcas.add(new Marca("Renault"));
		marcas.get(0).getModelos().add(new Modelo("Kwid"));
		vagas[0] = c1;

		// Loop principal
		menu();
    }

	public static void menu()
	{
		int opcao;
		while(true) {
			printMenu();
			opcao = scanner.nextInt();
			switch (opcao) {
				case 0:
					cadastrarEntrada();
					break;
				case 1:
					saidaCarro();
					break;
				case 2:
					ocupacaoEstacionamento();
					break;
				case 3:
					consultaHistorico();
					break;
				default:
					System.out.println("XX Opção Inválida, selecione uma opção válida");
					break;
			}
		}
	}

	private static void printMenu() {
		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.println("|                      MENU                      |");
		System.out.println("--------------------------------------------------");
		System.out.println("|  0  | Cadastrar entrada do carro               |");
		System.out.println("|  1  | Efetuar uma saida de carro               |");
		System.out.println("|  2  | Mostrar ocupação do estacionamento       |");
		System.out.println("|  3  | Mostrar relatório gerencial consolidado  |");
		System.out.println("--------------------------------------------------");
		System.out.print("\n>> Selecione a opção desejada: ");
	}


	private static void entradaCarro(String modeloCarro) {
        System.out.print("\n>> Insira placa do carro: ");
        String placaCarro = scanner.next();

		Carro carro = new Carro(new Modelo(modeloCarro), placaCarro, LocalDateTime.now());

		// Posiciona carro na primeira vaga disponível
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == null) {
                vagas[i] = carro;
                break;
            }
        }

		// Mostra situação do estacionamento
        ocupacaoEstacionamento();
    }

    private static void saidaCarro() {
		String indexStr;
		Carro car;
		int index = 0;
		long minutos;
		float valor;

		while(index <= 0 || index > 100){
			// Leitura do index
			System.out.print("\n>> Insira a posição do carro a ser retirado: ");
			indexStr = scanner.next();
			index = Integer.parseInt(indexStr);

			// Verifica se foi escolhido uma posição válida
			if(index <= 0 || index > 100){
				System.out.println("\nXX Valor inválido! Selecione um valor válido");
				continue;
			}

			// Resgata o carro
			car = vagas[index-1];

			// Checa se existe algum carro na posição
			if(car == null){
				System.out.println("\nXX Não existe carro nesta posição");
				return;
			}

			// Retira o carro
			vagas[index-1] = null;

			// Set da hora de saída
			car.setSaida(LocalDateTime.now());

			// Cálculo do valor a ser cobrado
			minutos = ChronoUnit.MINUTES.between(car.getEntrada(), car.getsaida()) - 60;
			valor = (float) Math.ceil(minutos / 15.0);
			valor = valor < 0 ? 10 : 10 + valor * 2;

			// Set do valor a ser cobrado
			car.setvalor(valor);

			// Loga a saida do carro
			System.out.println("\n=> Carro Retirado!");
			System.out.println("=> Dados do carro: " + car.toString());

			// Registra no histórico
			historico.add(car);
		}
	}

	private static String cadastrarMarcaModelo()
	{
		String nomeMarca, nomeModelo;

		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.println("|             CADASTRO MODELO/MARCA              |");
		System.out.println("--------------------------------------------------");

		System.out.print(">>  Marca do carro: ");
		nomeMarca = scanner.next();
		Marca marca = new Marca(nomeMarca);
		marcas.add(marca);

		System.out.print(">>  Modelo do carro: ");
		nomeModelo = scanner.next();
		Modelo modelos = new Modelo(nomeModelo);
		marca.addModelo(modelos);

		return nomeModelo;
	}

	private static String cadastrarModelo(int posicao)
	{
		String nomeModelo;

		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.println("|                 CADASTRO MODELO                |");
		System.out.println("--------------------------------------------------");

		System.out.print(">>  Modelo do carro: ");
		nomeModelo = scanner.next();
		Modelo modelos = new Modelo(nomeModelo);
		marcas.get(posicao).addModelo(modelos);

		return nomeModelo;
    }

	private static void cadastrarEntrada(){
		String modeloSelecionado;
		int posicaoMarca = -1;

		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.println("|                CADASTRAR ENTRADA               |");

		while(posicaoMarca < 0 || posicaoMarca > marcas.size() + 1){
			System.out.println("==================================================");
			System.out.println("|  Lista das marcas cadastradas:");
			System.out.println("--------------------------------------------------");
			for (int i = 0; i < marcas.size(); i++) System.out.println("|  " + (i + 1) + "  |  " + marcas.get(i).getNome());
			System.out.println("==================================================");

			System.out.print("\n>> Selecione a marca desejada (se não estiver na lista digite 0 para adicionar): ");
			posicaoMarca = scanner.nextInt();

			if (posicaoMarca < 0 || posicaoMarca > marcas.size() + 1){
				System.out.println("\nXX Valor inválido! Selecione um valor válido\n");
				continue;
			}

			modeloSelecionado = posicaoMarca == 0 ? cadastrarMarcaModelo() : validarModelo(posicaoMarca);

			entradaCarro(modeloSelecionado);
		}
	}

	private static String validarModelo(int posicaoMarca) {
		String modeloSelecionado = null, marcaSelecionada;
		int posicaoModelo = -1;
		Marca marca = marcas.get(posicaoMarca-1);

		marcaSelecionada = marca.getNome();

		System.out.println("");

		while(posicaoModelo < 0 || posicaoModelo > marca.getModelos().size()+1){
			System.out.println("=============================================================================");
			System.out.println("|  Lista das modelos cadastrados para a marca " + marcaSelecionada.toLowerCase() + ":");
			System.out.println("-----------------------------------------------------------------------------");
			for (int i = 0; i < marcas.get(posicaoMarca - 1).getModelos().size(); i++)
				System.out.println("|  " + (i + 1) + "  |  " + marcas.get(posicaoMarca - 1).getModelos().get(i));
			System.out.println("=============================================================================");

			System.out.print("\n>> Selecione o modelo desejado (se não estiver na lista, digite 0 para adicionar): ");

			posicaoModelo = scanner.nextInt();

			if(posicaoModelo < 0 || posicaoModelo > marca.getModelos().size()+1){
				System.out.println("\nXX Valor inválido! Selecione um valor válido\n");
				continue;
			}

			switch(posicaoModelo) {
				case 0:
					modeloSelecionado = cadastrarModelo(posicaoMarca - 1);
					break;
				default:
					modeloSelecionado = marca.getModelos().get(posicaoModelo - 1).getNome();
					break;
			}
		}

		return modeloSelecionado;
	}

	private static void ocupacaoEstacionamento(){
		String vaga;

		System.out.println("");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("|                              ESTACIONAMENTO                             |");
		System.out.println("---------------------------------------------------------------------------");
		for (int i = 0; i < 100; i++)
		{
			vaga = vagas[i] == null ? "Vazio" : vagas[i].toString();
			if(i < 9) System.out.println("|  " + (i+1) + "    |  " + vaga);
			else if(i >= 9 && i < 99) System.out.println("|  " + (i+1) + "   |  " + vaga);
			else System.out.println("|  " + (i+1) + "  |  " + vaga);
		}
		System.out.println("---------------------------------------------------------------------------");
	}

	private static void consultaHistorico(){
		Carro hist;
		ArrayList <Carro> carHist = new ArrayList <Carro>();

		System.out.println("");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("|                                 HISTÓRICO                               |");
		System.out.println("---------------------------------------------------------------------------");
		System.out.print("\n>> Insira a data que você deseja consultar (no formato DD/MM/AAAA): ");
		String data = scanner.next();

		// Cria novo array somente com o histórico na data selecionada
		for(int i = 0; i < historico.size(); i++){
			hist = historico.get(i);
			if(hist.getEntradaFormatada().equals(data)){
				carHist.add(hist);
			}
		}

		// Checa se o novo array não está vazio
		if(carHist.isEmpty()){
			System.out.println("\nXX Não existem carros para a data selecionada");
			return;
		}

		System.out.println("");
		System.out.println("==================================================");
		System.out.println("|  Histórico para o dia " + data +":");
		System.out.println("--------------------------------------------------");
		// Printa na tela os dados dos carros na data selecionada
		for(int i = 0; i < carHist.size(); i++){
			System.out.println("|  " + (i+1) + "  |  " + carHist.get(i).toString());
		}
		System.out.println("==================================================");
	}

}
