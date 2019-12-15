package controllers.listCars;

import boot.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.bean.Carro;
import models.dao.CarroDAO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

public class ListCars{

    public TableView<Carro> table;
    public TableColumn<Carro, String> colPlaca;
    public TableColumn<Carro, String> colAno;
    public TableColumn<Carro, String> colCor;
    public TableColumn<Carro, String> colMarca;
    public TableColumn<Carro, String> colModelo;
    public TableColumn<Carro, String> colChassi;
    public TableColumn<Carro, String> colProp;
    public TableColumn<Carro, Date> colDC;

    public static ArrayList<Carro> carros;

    public Button list;
    public Button voltar;
    public Button terceiro;

    public void list(){
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colChassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
        colProp.setCellValueFactory(new PropertyValueFactory<>("proprietario"));
        colDC.setCellValueFactory(new PropertyValueFactory<>("dataCompra"));

        CarroDAO carroDAO = new CarroDAO();
        carros = carroDAO.readAll();

        table.setItems(listaDeCarros());
    }

    public void voltar(){
        Main.changeScreen("home");
    }

    public ObservableList<Carro> listaDeCarros(){
        return FXCollections.observableArrayList(carros);
    }

    public void obterTerceiro(){
        try{
            Carro terceiro = carros.get(3);
            new Alert(Alert.AlertType.INFORMATION, terceiro.toString() + " Número de carros: " + carros.size()).show();
        } catch (NullPointerException | IndexOutOfBoundsException exc){
            new Alert(Alert.AlertType.WARNING, "Não tem carro na posição 3").show();
        }
    }
}
