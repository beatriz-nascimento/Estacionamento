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
        return entrada;
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
        return "Carro [modelo=" + modelo + ", placa=" + placa + ", entrada=" + entrada + ", saida=" + saida + ", valor="
                + valor + "]";
    }


}