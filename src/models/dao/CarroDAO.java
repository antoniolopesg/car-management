package models.dao;

import cfg.ConnectionDatabase;
import javafx.scene.control.Alert;
import models.bean.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO {
    public void create(Carro carro) {
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
            stmt.setString(8, carro.getPlaca());

            stmt.executeUpdate();
        } catch (SQLException exc) {
            if (exc.getSQLState().equals("23505")) {
                new Alert(Alert.AlertType.WARNING, "Placa já foi cadastrada").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Houve algum erro").show();
            }
        } finally {
            if (stmt != null) {
                ConnectionDatabase.closeConn(conn, stmt);
            } else {
                ConnectionDatabase.closeConn(conn);
            }
        }
    }

    public ArrayList<Carro> readAll() {
        Connection conn = ConnectionDatabase.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Carro> lista = new ArrayList<Carro>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM carros");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Carro car = new Carro();
                car.setPlaca(rs.getString("placa"));
                car.setAno(rs.getString("ano"));
                car.setCor(rs.getString("cor"));
                car.setMarca(rs.getString("marca"));
                car.setModelo(rs.getString("modelo"));
                car.setChassi(rs.getString("chassi"));
                car.setProprietario(rs.getString("proprietario"));
                car.setDataCompra(rs.getDate("datacompra"));
                lista.add(car);
            }
        } catch (SQLException exc) {
            new Alert(Alert.AlertType.WARNING, "HOUVE ALGUM ERRO AO CARREGAR DADOS").show();
        } finally {
            if (stmt != null) {
                ConnectionDatabase.closeConn(conn, stmt);
            } else {
                ConnectionDatabase.closeConn(conn);
            }
        }

        return lista;
    }

    public void removeByPlaca(String placa) {
        Connection conn = ConnectionDatabase.getConn();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM carros WHERE placa = ?");
            stmt.setString(1, placa);

            stmt.executeUpdate();
        } catch (SQLException exc) {
            new Alert(Alert.AlertType.WARNING, "Houve algum erro").show();
        } finally {
            if (stmt != null) {
                ConnectionDatabase.closeConn(conn, stmt);
            } else {
                ConnectionDatabase.closeConn(conn);
            }
        }
    }
}
