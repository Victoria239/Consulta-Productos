package view;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginView extends GridPane {
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label messageLabel;

    public LoginView() {
        // Configurar los márgenes y el espaciado
        this.setPadding(new Insets(20));
        this.setVgap(10);
        this.setHgap(10);


        Text title = new Text("Iniciar Sesión");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setStyle("-fx-fill: #4B0082;"); // Indigo
        this.add(title, 0, 0, 2, 1);

        // Mensaje de error o bienvenida
        messageLabel = new Label();
        this.add(messageLabel, 0, 1, 2, 1);


        Label usernameLabel = new Label("Usuario:");
        usernameLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        usernameLabel.setStyle("-fx-text-fill: #4B0082;");
        usernameField = new TextField();
        this.add(usernameLabel, 0, 2);
        this.add(usernameField, 1, 2);


        Label passwordLabel = new Label("Contraseña:");
        passwordLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        passwordLabel.setStyle("-fx-text-fill: #4B0082;");
        passwordField = new PasswordField();
        this.add(passwordLabel, 0, 3);
        this.add(passwordField, 1, 3);


        loginButton = new Button("Iniciar Sesión");
        loginButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        loginButton.setStyle("-fx-background-color: #4B0082; -fx-text-fill: white;");
        this.add(loginButton, 1, 4);


        this.setStyle("-fx-background-color: #9370DB; -fx-padding: 20px; -fx-border-color: #4B0082; -fx-border-width: 2px; -fx-border-radius: 5px;");

        // Estilo para el mensaje
        messageLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }
}
