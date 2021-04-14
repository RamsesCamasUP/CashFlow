package Controller;

import DAO.CategoriaDAO;
import DAO.SubCategoriaDAO;
import Model.Categoria;
import Model.Subcategoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowCat implements Initializable {

    @FXML
    private Label txt_error;

    @FXML
    private Button btn_Cat;

    @FXML
    private Button btn_SubCat;

    @FXML
    private TableView<Categoria> t_Cat;

    @FXML
    private TableColumn<Categoria, Integer> tCat_id;

    @FXML
    private TableColumn<Categoria, String> tCat_Nombre;

    @FXML
    private TableView<Subcategoria> t_subCat;

    @FXML
    private TableColumn<Subcategoria,Integer> tSub_id;

    @FXML
    private TableColumn<Subcategoria, String> tSub_Nombre;

    @FXML
    private TableColumn<Subcategoria, String> tSub_Cat;

    @FXML
    private TextField txt_NombreCat;

    @FXML
    private Button btn_add;

    @FXML
    void setAddCat(MouseEvent event) {
        txt_NombreCat.setVisible(true);
        txt_NombreCat.setDisable(false);
        btn_add.setVisible(true);
    }

    @FXML
    void addCat(MouseEvent event) {
        System.out.println("Wenas");
    }

    @FXML
    void validCat(KeyEvent event) {
        if (!txt_NombreCat.getText().isEmpty()){
            btn_add.setDisable(false);
        }else {
            btn_add.setDisable(true);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CategoriaDAO c_DAO = new CategoriaDAO();
        ArrayList<Categoria> categorias = c_DAO.getAllCat();

        SubCategoriaDAO s_cDAO = new SubCategoriaDAO();
        ArrayList<Subcategoria> subcategorias = s_cDAO.getAllSubC();

        txt_NombreCat.setVisible(false);
        txt_NombreCat.setDisable(true);
        btn_add.setVisible(false);
        btn_add.setDisable(true);

        tCat_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tCat_Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        for (int i =0;i<categorias.size();i++){
            t_Cat.getItems().add(categorias.get(i));
        }

        tSub_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tSub_Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tSub_Cat.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        for (int i=0; i<subcategorias.size();i++){
            t_subCat.getItems().add(subcategorias.get(i));
        }

    }
}
