package com.example.fabiopub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FirstHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fabio pub");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
//    public static void open(String[] args)[]
//        File file = new File("src/main/resources/com/example/fabiopub/text.txt");
//            try{
//                file.createNewFile();
//            }catch (IOException e){
//                    e.printStackTrace();
//            }
}
