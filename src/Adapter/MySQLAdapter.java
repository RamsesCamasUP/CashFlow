package Adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAdapter {
    private static MySQLAdapter instancia=null;
    private static Connection connection =null;

    public static MySQLAdapter getInstance() {
        if(instancia == null) {
            instancia = new MySQLAdapter();
            instancia.Connection();
        }
        return instancia;
    }

    public void Connection() {
        String connectionString = "jdbc:mysql://localhost:3306/cashflow?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
        String user = "user.javafx";
        String password = "Machiniram117.";
        try {
            connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Conexion MySQL Existosa");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Conexion MySQL fallida");
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
