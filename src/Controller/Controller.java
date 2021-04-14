package Controller;

import DAO.UserDAO;
import Model.Main;
import Model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Controller {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private Label txt_error;

    @FXML
    void login(MouseEvent event) {
        UserDAO userDAO = new UserDAO();
        Usuario user = null;
        if (!txt_username.getText().isEmpty()){
            user = userDAO.getUser(txt_username.getText().trim());
            System.out.println(user);
        }else {
            txt_error.setText("Ingrese un usuario");
        }
        if(user!=null){
            if(txt_password.getText().equals(user.getPassword())){
                try {
                    Main.setFXML("Menu","Menu");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                txt_error.setText("Usuario o contraseña incorrecto");
            }
        }
    }

}
