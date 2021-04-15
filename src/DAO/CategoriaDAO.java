package DAO;

import Adapter.MySQLAdapter;
import Model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {
    private Connection connection = null;
    public CategoriaDAO() {
        MySQLAdapter conector = MySQLAdapter.getInstance();
        connection = conector.getConnection();
    }

    public boolean insertCategoria(Categoria cat){
        boolean result = false;
        if (connection!=null){
            String sql = "insert into categoria values(?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,cat.getId());
                statement.setString(2,cat.getNombre());
                statement.executeUpdate();
                result = true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }

    public Categoria getCategoria(int id){
        Categoria cat = null;
        if(connection!=null){
            String sql = "select * from categoria where idCategoria = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                results.next();
                if (results.getRow()==1){
                    int idCategoria= results.getInt(1);
                    String nombre = results.getString(2);
                    cat = new Categoria(idCategoria,nombre);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return cat;
    }

    public Categoria getCategoria(String nombreCat){
        Categoria cat = null;
        if(connection!=null){
            String sql = "select * from categoria where nombre = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nombreCat);
                ResultSet results = statement.executeQuery();
                results.next();
                if (results.getRow()==1){
                    int idCategoria= results.getInt(1);
                    String nombre = results.getString(2);
                    cat = new Categoria(idCategoria,nombre);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return cat;
    }

    public ArrayList<Categoria> getAllCat(){
        ArrayList<Categoria> categorias = new ArrayList<>();
        if (connection!=null){
            String sql = "select * from categoria";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    int idCategoria = results.getInt(1);
                    String nombre = results.getString(2);
                    Categoria cat = new Categoria(idCategoria,nombre);
                    categorias.add(cat);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return  categorias;
    }
}
