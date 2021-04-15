package Controller;

import DAO.CategoriaDAO;
import DAO.SubCategoriaDAO;
import Model.Categoria;
import Model.Main;
import Model.Subcategoria;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowCat implements Initializable {

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
    private TextField txt_NombreSub;

    @FXML
    private Button btn_addSub;


    @FXML
    private Button btn_Back;

    @FXML
    private ImageView img_Back;

    @FXML
    private Button btn_HCat;

    @FXML
    private Button btn_HSub;

    @FXML
    private ChoiceBox<String> c_Cat;

    CategoriaDAO c_DAO;

    ArrayList<Categoria> categorias;

    ArrayList<Subcategoria> subcategorias;

    SubCategoriaDAO s_cDAO;

    @FXML
    void back(MouseEvent event) {
        try {
            Main.setFXML("Menu","Menú");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void hideCat(MouseEvent event) {
        txt_NombreCat.setVisible(false);
        btn_add.setVisible(false);
        btn_HCat.setVisible(false);

        txt_NombreCat.setDisable(true);
        btn_add.setDisable(true);
        btn_HCat.setDisable(true);
    }

    @FXML
    void hideSub(MouseEvent event) {
        txt_NombreSub.setVisible(false);
        btn_addSub.setVisible(false);
        btn_HSub.setVisible(false);
        c_Cat.setVisible(false);

        txt_NombreSub.setDisable(true);
        btn_addSub.setDisable(true);
        btn_HSub.setDisable(true);
        c_Cat.setDisable(true);
    }

    @FXML
    void setAddCat(MouseEvent event) {
        txt_NombreCat.setVisible(true);
        txt_NombreCat.setDisable(false);
        btn_HCat.setVisible(true);
        btn_HCat.setDisable(false);
        btn_add.setVisible(true);
    }

    @FXML
    void addCat(MouseEvent event) {
        categorias = c_DAO.getAllCat();
        Categoria n_cat = new Categoria(categorias.size()+1,txt_NombreCat.getText());
        c_DAO.insertCategoria(n_cat);
        t_Cat.getItems().clear();
        categorias = c_DAO.getAllCat();
        c_Cat.getItems().clear();
        for (int i =0;i<categorias.size();i++){
            t_Cat.getItems().add(categorias.get(i));
            c_Cat.getItems().add(categorias.get(i).getNombre());
        }


    }

    @FXML
    void addSubCat(MouseEvent event) {
        subcategorias = s_cDAO.getAllSubC();
        Categoria cat = c_DAO.getCategoria(c_Cat.getValue());
        Subcategoria n_sCat = new Subcategoria(subcategorias.size()+1,txt_NombreSub.getText(),cat.getId());
        s_cDAO.insertSubCat(n_sCat);
        t_subCat.getItems().clear();
        subcategorias = s_cDAO.getAllSubC();
        for (int i=0; i<subcategorias.size();i++){
            t_subCat.getItems().add(subcategorias.get(i));
        }
    }

    @FXML
    void setAddSub(MouseEvent event) {
        txt_NombreSub.setVisible(true);
        txt_NombreSub.setDisable(false);
        btn_HSub.setVisible(true);
        btn_HSub.setDisable(false);
        c_Cat.setVisible(true);
        c_Cat.setDisable(false);

        btn_addSub.setVisible(true);
    }



    @FXML
    void validCat(KeyEvent event) {
        if (!txt_NombreCat.getText().isEmpty()){
            btn_add.setDisable(false);
        }else {
            btn_add.setDisable(true);
        }
    }

    @FXML
    void validSubK(KeyEvent event) {
        if (!txt_NombreSub.getText().isEmpty() && c_Cat.getValue()!=null){
            btn_addSub.setDisable(false);
        }else{
            btn_addSub.setDisable(true);
        }
    }

    @FXML
    void validSubM(MouseEvent event) {
        if (c_Cat.getValue()!=null){
            btn_addSub.setDisable(false);
        }else{
            btn_addSub.setDisable(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c_DAO = new CategoriaDAO();
        categorias = c_DAO.getAllCat();
        s_cDAO = new SubCategoriaDAO();
        subcategorias = s_cDAO.getAllSubC();

        txt_NombreCat.setVisible(false);
        txt_NombreSub.setVisible(false);
        btn_add.setVisible(false);
        btn_addSub.setVisible(false);
        c_Cat.setVisible(false);
        btn_HCat.setVisible(false);
        btn_HSub.setVisible(false);


        txt_NombreSub.setDisable(true);
        txt_NombreCat.setDisable(true);
        btn_add.setDisable(true);
        btn_addSub.setDisable(true);
        btn_HCat.setDisable(true);
        btn_HSub.setDisable(true);
        c_Cat.setDisable(true);

        tCat_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tCat_Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        for (int i =0;i<categorias.size();i++){
            t_Cat.getItems().add(categorias.get(i));
            c_Cat.getItems().add(categorias.get(i).getNombre());
        }

        tSub_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tSub_Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tSub_Cat.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        for (int i=0; i<subcategorias.size();i++){
            t_subCat.getItems().add(subcategorias.get(i));
        }


    }
}
