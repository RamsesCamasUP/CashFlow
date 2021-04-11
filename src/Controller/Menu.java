package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Menu {

    @FXML
    private Button btnShow1;

    @FXML
    private Button btnShow2;

    @FXML
    private Button btnShow3;

    @FXML
    void showBtn1(MouseEvent event) {
        System.out.println("Mostrar Categorías");
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

