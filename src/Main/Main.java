package Main;

import Bibliotheque.Bibliotheque;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        new Bibliotheque().start();
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnCloseRequest(e -> {
            if(JOptionPane.showConfirmDialog(null,"Do you really wish to close the app ? ","Closing",JOptionPane.YES_NO_OPTION)==0){
                primaryStage.close();
                System.exit(0);
            }
            e.consume();
        });
        primaryStage.show();
    }
}