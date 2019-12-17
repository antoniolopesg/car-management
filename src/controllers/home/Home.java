package controllers.home;

import boot.Main;
import controllers.listCars.ListCars;
import helpers.EmptyInputException;
import helpers.PlacaFormatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.bean.Carro;
import models.dao.CarroDAO;
import utils.FileHandler;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Home implements Initializable {
    public TextField placa;
    public TextField ano;
    public TextField cor;
    public TextField marca;
    public TextField modelo;
    public TextField chassi;
    public TextField proprietario;
    public DatePicker dataCompra;

    public TextField[] inputs;
    public Button listCars;

    @FXML
    private Button addCar;

    public void createCar(ActionEvent mouseEvent) {

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;

        Carro newCarro = null;

        try {
            for(TextField input:inputs){
                if(Home.InputValidator(input)){
                    throw new EmptyInputException(input.getId());
                }
            }

            validatePlaca();

            data = dt.parse(dataCompra.getEditor().getText());

            newCarro = new Carro(placa.getText().trim(),
                                       ano.getText().trim(),
                                       cor.getText().trim(),
                                       marca.getText().trim(),
                                       modelo.getText().trim(),
                                       chassi.getText().trim(),
                                       proprietario.getText().trim(),
                                       data);

            CarroDAO dao = new CarroDAO();

            dao.create(newCarro);

            FileHandler.writer("./ListagemCarros.txt", newCarro);
            new Alert(Alert.AlertType.INFORMATION, "Carro salvo com sucesso").show();
        } catch (ParseException e) {
            new Alert(Alert.AlertType.WARNING, "Data inválida: " + dataCompra.getEditor().getText() + " siga o modelo (06/06/2000)").show();
        } catch (EmptyInputException e){
            new Alert(Alert.AlertType.WARNING, e.toString()).show();
        } catch (PlacaFormatException e) {
            new Alert(Alert.AlertType.WARNING, e.toString()).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean InputValidator(TextField input){
        return input.getText().trim().equals("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.inputs = new TextField[] {placa, ano, cor, marca, modelo, chassi, proprietario};
        listCars.setOnAction(this::listCarsScreen);
    }

    public void listCarsScreen(ActionEvent mouseEvent){
        Main.changeScreen("listcars");
    }

    public void validatePlaca() throws PlacaFormatException {

        if(!this.placa.getText().trim().matches("[A-Z]{3}[-][0-9]{4}")){
            throw new PlacaFormatException(placa.getText());
        }
    }
}
