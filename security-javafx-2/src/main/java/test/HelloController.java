package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class HelloController extends FXMLController {

    @Autowired
    public AuthenticationManager authManager;

    @Autowired
    public OperationService operationService;

    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public TextField txtDiv;
    @FXML
    public TextField txtMult;
    @FXML
    public TextField txtSuma;
    @FXML
    public Label lblInfo;

    @FXML
    public void onAuthClick(ActionEvent event) {
        try {
            final String usuario = username.getText().trim();
            final String contrasena = password.getText().trim();

            Authentication request = new UsernamePasswordAuthenticationToken(usuario, contrasena);
            Authentication result = authManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);

            String name = result.getName();
            String roles = result.getAuthorities().toString();

            lblInfo.setText("Bienvenido: " + name + " " + roles);
            lblInfo.setTextFill(Color.GREEN);

            username.clear();
            password.clear();

        } catch (AuthenticationException e) {
            lblInfo.setText("usuario (y/o) contrasena incorrecto.");
            lblInfo.setTextFill(Color.RED);

            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    @FXML
    public void onSuma(ActionEvent actionEvent) {
        try {
            clear();
            double r = operationService.sumar(2, 2);
            txtSuma.setText("Sumar: 2 + 2 = " + r);
        } catch (AccessDeniedException e) {
            txtSuma.setText(e.getMessage());
        }
    }

    @FXML
    public void onMult(ActionEvent actionEvent) {
        try {
            clear();
            double r = operationService.multiplicar(4, 6);
            txtMult.setText("Multiplicar: 4 * 6 = " + r);
        } catch (AccessDeniedException e) {
            txtMult.setText(e.getMessage());
        }
    }

    @FXML
    public void onDiv(ActionEvent actionEvent) {
        clear();
        double r = operationService.dividir(8, 2);
        txtDiv.setText("Dividir: 8 / 2 = " + r);
    }

    @FXML
    public void onLogout(ActionEvent actionEvent) {
        MainApp.logout();

        username.clear();
        password.clear();
        lblInfo.setText("");
    }

    private void clear() {
        txtSuma.clear();
        txtMult.clear();
        txtDiv.clear();
    }
}
