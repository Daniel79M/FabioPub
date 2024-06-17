package com.example.fabiopub.controllers;

import com.example.fabiopub.Entity.User;
import com.example.fabiopub.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;

public class HomePage extends Homemain {

    private String username;
    private String password;
    private String Email;
    private String confirmePass;

    @FXML
    private PasswordField confirmPasswordfield;
    @FXML
    private Label name;
    @FXML
    private Label email;

    @FXML
    private TextField emailTextfield;

    @FXML
    private PasswordField passPasswordField;

    @FXML
    private TextField emailTexteField;
    @FXML
    private PasswordField passwordTextfield;

    @FXML
    private ImageView userImage;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Label Logo;

    @FXML
    private Label conecteButton;

    @FXML
    public void connexion() throws IOException {
        Homemain back = new Homemain();
        back.showPage("Fabio Pub 24","connexion.fxml", conecteButton);
    }

    @FXML
    public void inscription() throws IOException {
       Homemain back = new Homemain();
        back.showPage("Fabio Pub 24","inscription.fxml", conecteButton);
    }

    @FXML
    public void onback() throws IOException {
        Homemain back = new Homemain();
        back.showPage("Fabio Pub 24","FirstHome.fxml", email);
    }

    @FXML
    private void toRegiste() throws SQLException, IOException, NoSuchAlgorithmException {
        this.username = userNameTextField.getText().trim();
        this.password = passwordTextfield.getText();
        this.confirmePass = confirmPasswordfield.getText();
        this.Email = emailTextfield.getText();
        if(!password.equals(confirmePass)){
            showErrorMessage("Erreur","Les deux mots de passe ne sont pas correcte \n veuiller ressaisir");
        }else if(!username.isEmpty() && !password.isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            user.setPassword(encoded);
            user.setEmail(Email);
            user.Inscription(user);
            showInformationMessage("Information","Votre Inscription à été validé");
        }
        showPage("Fabio pub","connexion.fxml",email);

    }

    @FXML
    private void toConnect() throws SQLException, IOException, NoSuchAlgorithmException {
        this.username = emailTexteField.getText().trim();
        this.password = passPasswordField.getText();
        if (!username.isEmpty() && !password.isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            user.setPassword(encoded);
            if (user.toConnect(user)){
                Stage stage = (Stage) email.getScene().getWindow();
                Stage newStage = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull (HelloApplication.class.getResource("Fabio-View.fxml")));
                newStage.setTitle("Fabio pub 24");
                newStage.setScene(new Scene(root));
                newStage.show();
                stage.close();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Echec de connexion");
                alert.setHeaderText("Nom d'utilisateur ou mot de passe incorrect(s)");
                alert.setContentText("Nous ne parvenons pas à vous connecter à votre session avec ces identifiants. vérifiez-les puis réessayez.");
                alert.show();
            }
        }
    }
}
