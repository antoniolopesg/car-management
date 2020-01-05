package controllers.listCars;

import boot.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.bean.Carro;
import models.dao.CarroDAO;

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
    public Button primeiro;
    public Button ultimo;
    public Button removerUltimo;

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

    public void obterTerceiro(ActionEvent actionEvent){
        if(carros != null && carros.size() >= 3){
            new Alert(Alert.AlertType.INFORMATION, carros.get(2).toString() + " Número de carros: " + carros.size()).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Não tem carro na posição 3").show();
        }
    }

    public void placaPrimeiro(ActionEvent actionEvent){
        if(carros != null && carros.size() >= 1){
            new Alert(Alert.AlertType.INFORMATION, carros.get(0).getPlaca()).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Não tem carro na posição 1").show();
        }
    }

    public void placaUltimo(ActionEvent actionEvent){
        if(carros != null && carros.size() >= 1){
            Carro ultimo = carros.get(carros.size() - 1);
            new Alert(Alert.AlertType.INFORMATION, ultimo.getPlaca()).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Não tem carro na lista").show();
        }
    }

    public void removerUltimo(ActionEvent actionEvent) {
        if(carros != null && carros.size() >= 1){
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.removeByPlaca(carros.get(carros.size() - 1).getPlaca());
            list();
            new Alert(Alert.AlertType.INFORMATION, "Deletado com sucesso").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Não tem carro na lista").show();
        }
    }
}
