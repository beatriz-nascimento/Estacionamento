package Modelagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Carro {

    private Modelo modelo;
    private String placa;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private float valor;

    public Carro(Modelo modelo, String placa, LocalDateTime entrada) {
        super();
        this.placa = placa;
        this.entrada = entrada;
        this.modelo = modelo;
    }
    
    public String getEntradaFormatada () {
    	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	return this.entrada.format(formatoData);
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getsaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public void setvalor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m.s");
        return this.modelo + ", Placa: " + this.placa
                + ", Entrada: " + this.entrada.format(formato)
                + (this.saida == null? "" : ", Saida: " + this.saida.format(formato))
                + (this.valor == 0.0? "" : ", Valor Pago: R$" + this.valor);
    }
}