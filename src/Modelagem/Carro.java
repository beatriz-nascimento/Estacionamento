package Modelagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
    
    public String DataFormatada (LocalDateTime dt) {
    	DateTimeFormatter formatoData = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
    	
    	return dt.format(formatoData);
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getEntrada() {
        // DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m.s");
        // return entrada.format(formato);
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getsaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public float getValor() {
        return valor;
    }

    public void setvalor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m.s");
        return modelo + ", placa: " + placa + ", entrada: " + entrada.format(formato) + (saida == null? "" : ", saida: " + saida.format(formato));
    }


}