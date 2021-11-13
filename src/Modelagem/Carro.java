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
        this.modelo = modelo;
        this.placa = placa;
        this.entrada = entrada;
        this.modelo = modelo;
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

    public String getEntrada(LocalDateTime entrada) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m.s");

        return entrada.format(formato);
    }

    public void SetEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getsaida() {
        return saida;
    }

    public void SetSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public float GetValor() {
        return valor;
    }

    public void setvalor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carro [modelo=" + modelo + ", placa=" + placa + ", entrada=" + getEntrada(entrada) + ", saida=" + saida + ", valor="
                + valor + "]";
    }


}