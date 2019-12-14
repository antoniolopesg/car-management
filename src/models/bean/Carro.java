package models.bean;

import java.util.Date;

public class Carro {
    private String placa;
    private String ano;
    private String cor;
    private String marca;
    private String modelo;
    private String chassi;
    private String proprietario;
    private Date dataCompra;

    public Carro(String placa, String ano, String cor, String marca, String modelo, String chassi, String proprietario, Date dataCompra) {
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.proprietario = proprietario;
        this.dataCompra = dataCompra;
    }

    public Carro() {
        placa = null;
        ano = null;
        cor = null;
        marca = null;
        modelo = null;
        chassi = null;
        proprietario = null;
        dataCompra = null;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
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

    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", ano='" + ano + '\'' +
                ", cor='" + cor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", chassi='" + chassi + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", dataCompra=" + dataCompra +
                '}';
    }
}
