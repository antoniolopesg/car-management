package models.dao;

import cfg.ConnectionDatabase;
import javafx.scene.control.Alert;
import models.bean.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroDAO {
    public void create(Carro carro)  {
        Connection conn = ConnectionDatabase.getConn();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO carros (ano, cor, marca, modelo, chassi, proprietario, datacompra, placa) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, carro.getAno());
            stmt.setString(2, carro.getCor());
            stmt.setString(3, carro.getMarca());
            stmt.setString(4, carro.getModelo());
            stmt.setString(5, carro.getChassi());
            stmt.setString(6, carro.getProprietario());
            stmt.setDate(7, new java.sql.Date(carro.getDataCompra().getTime()));
            stmt.setString(8,  carro.getPlaca());

            stmt.executeUpdate();
        } catch (SQLException exc){
            if(exc.getSQLState().equals("23505")){
                new Alert(Alert.AlertType.WARNING, "Placa já foi cadastrada").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Verifique novamente o formato dos campos e se tem algum vazio").show();
            }
        } finally {
            if(stmt != null){
                ConnectionDatabase.closeConn(conn, stmt);
            } else {
                ConnectionDatabase.closeConn(conn);
            }
        }
    }


}
