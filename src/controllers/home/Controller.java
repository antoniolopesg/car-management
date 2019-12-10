package controllers.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.bean.Carro;
import models.dao.CarroDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    public TextField placa;
    public TextField ano;
    public TextField cor;
    public TextField marca;
    public TextField modelo;
    public TextField chassi;
    public TextField proprietario;
    public DatePicker dataCompra;
    public Label errorMsg;

    @FXML
    private Button addCar;

    public void createCar(ActionEvent mouseEvent) throws ParseException {

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;

        try {
            data = dt.parse(dataCompra.getEditor().getText());

            String placa = this.placa.getText();

            if(placa.charAt(3) != '-'){
                placa = placa.substring(0, 3) + "-" + placa.substring(3, 7);
            }

            Carro newCarro = new Carro(placa, ano.getText(), cor.getText(), marca.getText(), modelo.getText(), chassi.getText(), proprietario.getText(), data);

            CarroDAO dao = new CarroDAO();

            dao.create(newCarro);
        } catch (ParseException exc) {
            new Alert(Alert.AlertType.WARNING, "Insira uma data válida").show();
        }

    }

}
