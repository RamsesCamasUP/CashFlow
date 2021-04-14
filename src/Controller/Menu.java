package Controller;

import DAO.CategoriaDAO;
import DAO.Cuenta_SDAO;
import DAO.SubCategoriaDAO;
import Model.Main;
import Model.Subcategoria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Menu {

    @FXML
    private Button btnShow1;

    @FXML
    private Button btnShow2;

    @FXML
    private Button btnShow3;

    @FXML
    void showBtn1(MouseEvent event) {
        try {
            Main.setFXML("ShowCat","Categorias");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showBtn2(MouseEvent event) {
        System.out.println("Flujo de efectivo");
    }

    @FXML
    void showBtn3(MouseEvent event) {
        System.out.println("Generar Reporte Mensual");
    }

}

