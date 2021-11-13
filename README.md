# Estacionamento

Uma sessão típica consiste em: 
1) cadastrar a entrada do carro: o sistema mostra uma lista de marcas para escolher uma (ArrayListmarcas) e depois uma lista demodelos disponíveis para escolher 
daquela marca(a partir do ArrayListmodelosda classe Marca). Caso o modelo não exista na lista, é possível escolher uma opção para cadastrar um
novo modelo (o que pode incluir uma nova marca). Uma vez definidoo modelo, pega-sea data e hora e inclui o carro no estacionamento (vetor vagas) 
2) efetuar uma saída de carro: o usuário informa o número da vaga em uso(que corresponde a posição do vetor vagas), o sistema registra data e hora de saída
lendodo sistema, calcula o preço e coloca este objeto Carro no ArrayList historico, deixando a vaga fica livre para ser usada novamente.
A primeira hora custa R$10,00, que é o valor mínimo praticado. Após uma hora o valor é fracionado, R$ 2,00 a cada 15 minutos.
3) cadastrar marca: permite o cadastro de novas marcas de carro(ou seja, novos objetos da classeMarcano ArrayListmarcasdefinido comostatic na classe Principal).
4) cadastrar modelo: permite o cadastro de novos modelos de carros (fazer um add de um novo ModelonoArrayListmodelosda classeMarca) em uma marca já existente no 
sistema (ArrayListmarcas)
5) mostrar ocupação do estacionamento: mostraa situação das 100 vagas, consultando o vetorvagas, mostra as vagaslinearmentepelo número, com a informação de Livre ou de Ocupado (modeloplaca-dd/mm/aaaa-hh:mm).Sendoomodelo,placa, data e hora de entradaos atributos do carro que está ocupando a respectiva vaga.6) mostrar relatório gerencialconsolidado: solicita adata(dd/mm/aaaa)que se deseja consultar e mostra, consultando o ArrayListhistorico, todas as movimentações efetuadas naquele dia, cada linha do relatório contendo: placa, modelo, marca, entrada, saída e valor pago. Ao final,mostrartambémo valor total faturado naquele dia.
