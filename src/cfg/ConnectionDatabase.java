package cfg;

import org.postgresql.core.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDatabase {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URI = "jdbc:postgresql://localhost:5432/car_management";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConn(){
        try {
            Class.forName(DRIVER);
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
            return DriverManager.getConnection(URI, USER, PASSWORD);
        } catch(ClassNotFoundException | SQLException excep){
            throw new RuntimeException("Erro na conexão com o banco de dados", excep);
        }
    }

    public static void closeConn(Connection conn){
        try {
            conn.close();
        } catch (SQLException excep){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, excep);
        }
    }

    public static void closeConn(Connection conn, PreparedStatement stmt){
        closeConn(conn);
        try {
            stmt.clearParameters();
            stmt.close();
        } catch (SQLException excep){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, excep);
        }
    }
}
