package models.bean;

import java.util.Date;

public class Carro {
    private String placa;
    private int ano;
    private String cor;
    private String marca;
    private String modelo;
    private String chassi;
    private String proprietario;
    private Date dataCompra;

    public Carro(String placa, int ano, String cor, String marca, String modelo, String chassi, String proprietario, Date dataCompra) {
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.proprietario = proprietario;
        this.dataCompra = dataCompra;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
}
