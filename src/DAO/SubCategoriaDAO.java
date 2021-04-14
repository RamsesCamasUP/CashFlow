package DAO;

import Adapter.MySQLAdapter;
import Model.Categoria;
import Model.Subcategoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubCategoriaDAO {
    private Connection connection = null;
    public SubCategoriaDAO() {
        MySQLAdapter conector = MySQLAdapter.getInstance();
        connection = conector.getConnection();
    }
    public Subcategoria getSubcategoria(int id){
        Subcategoria s_cat = null;
        if(connection!=null){
            String sql = "select * from subcategoria where idSubcategoria = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                results.next();
                if (results.getRow()==1){
                    int idCategoria= results.getInt(1);
                    String nombre = results.getString(2);
                    int idSubCategoria = results.getInt(3);
                    s_cat = new Subcategoria(idCategoria,nombre,idSubCategoria);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return s_cat;
    }

    public ArrayList<Subcategoria> getAllSubC(){
        ArrayList<Subcategoria> subcategorias = new ArrayList<>();
        if(connection!=null){
            String sql = "select * from subcategoria";
            CategoriaDAO c_dao = new CategoriaDAO();
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    int idSubcategoria = results.getInt(1);
                    String nombre = results.getString(2);
                    int idCategoria = results.getInt(3);
                    String categoria = c_dao.getCategoria(idCategoria).getNombre();
                    Subcategoria s_cat = new Subcategoria(idSubcategoria,nombre,idCategoria,categoria);
                    subcategorias.add(s_cat);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return subcategorias;
    }
}
