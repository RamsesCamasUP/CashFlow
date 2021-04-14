package DAO;

import Adapter.MySQLAdapter;
import Model.Categoria;
import Model.Cuenta_S;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cuenta_SDAO {
    private Connection connection = null;
    public Cuenta_SDAO() {
        MySQLAdapter conector = MySQLAdapter.getInstance();
        connection = conector.getConnection();
    }

    public Cuenta_S getCuentaS(int id){
        Cuenta_S cuenta_s = null;
        if (connection!=null){
            String sql = "select * from cuenta_semanal where idCuenta = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                results.next();
                if (results.getRow()==1){
                    int idCuenta = results.getInt(1);
                    int No_Semana = results.getInt(2);
                    String razon_s = results.getString(3);
                    float utilidad = results.getFloat(4);
                    String tipo = results.getString(5);
                    cuenta_s = new Cuenta_S(idCuenta,No_Semana,razon_s,utilidad,tipo);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return cuenta_s;
    }
}
