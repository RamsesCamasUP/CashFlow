package DAO;

import Adapter.MySQLAdapter;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection = null;
    public UserDAO() {
        MySQLAdapter conector = MySQLAdapter.getInstance();
        connection = conector.getConnection();
    }

    public Usuario getUser(String login) {
        Usuario user = null;
        if(connection!=null) {
            String sql = "select * from usuario where username = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, login);
                ResultSet results = statement.executeQuery();
                results.next();
                if (results.getRow()==1){
                    int idUser= results.getInt(1);
                    String username = results.getString(2);
                    String password = results.getString(3);
                    user = new Usuario(idUser,username, password);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return user;

    }
}
