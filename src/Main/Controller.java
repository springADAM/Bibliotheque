package Main;

import Bibliotheque.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;

public class Controller {
    private static Stage stage = new Stage();
    private Bibliotheque MainB = new Bibliotheque();

    @FXML MenuItem close;
    public void Close(){
        new Bibliotheque().stop();
        System.exit(0);
    }

    //**************************Adding Bloc**************************
    @FXML MenuItem add;
    @FXML Button ConfirmAdd;
    @FXML TextField TitreTxt;
    @FXML TextField AuteurTxt;
    @FXML TextField CategorieTxt;
    @FXML TextField QuantityTxt;
    public void Add() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddingBooks.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add a book");
        stage.showAndWait();
    }
    public void ConfirmAdd() throws NumberFormatException{
        MainB.addBook(new Livre(TitreTxt.getText(),AuteurTxt.getText(),CategorieTxt.getText(),Integer.parseInt(QuantityTxt.getText()),new Date()));
        if(stage.isShowing()){
            stage.close();
        }
    }

    //**************************Removing Bloc**************************
    @FXML MenuItem remove;
    @FXML TextField BookNameDelete;
    @FXML Button ConfirmRemove;
    public void Remove() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("RemovingBooks.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add a book");
        stage.show();
    }
    public void ConfirmRemove(){
        MainB.deleteABook(BookNameDelete.getText());
        if(stage.isShowing()){
            stage.close();
        }
    }

    //**************************Books Showing Bloc**************************
    @FXML Button showButton;
    public void showBooks(){
        MainB.showBooks();
    }

    //**************************Renting Bloc**************************
    public void Rent() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RentingBooks.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("rent a book");
        stage.showAndWait();
    }
    @FXML Button rentButton;
    @FXML TextField NomTxt;
    @FXML TextField AgeTxt;
    @FXML TextField TypeTxt;
    @FXML TextField RentingDaysTxt;
    @FXML TextField BookName;
    @FXML Button ConfirmRent;
    public void ConfirmRent() throws NumberFormatException{
        MainB.louer(new Costumers(NomTxt.getText(),Integer.parseInt(AgeTxt.getText()),TypeTxt.getText(),Integer.parseInt(RentingDaysTxt.getText())),BookName.getText());
        if(stage.isShowing()){
            stage.close();
        }
    }

    //**************************Historique Bloc**************************
    @FXML MenuItem rentingHistory;
    @FXML MenuItem Costumers;
    public void Costumers(){
        if(Bibliotheque.getCstmrs().size()!=0) {
            JOptionPane.showMessageDialog(null, Bibliotheque.getCstmrs());
        }else{
            JOptionPane.showMessageDialog(null,"there's no costumers for now","warning",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void RentingHistory(){
        if(Bibliotheque.getHistorique().size()!=0) {
            JOptionPane.showMessageDialog(null, Bibliotheque.getHistorique());
        }else{
            JOptionPane.showMessageDialog(null,"there's no History for now ","warning",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //
    @FXML MenuItem rmCostumer;
    public void RemoveCostumers() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RemoveCostumers.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle(" remove a Costumer");
        stage.showAndWait();
    }
    @FXML TextField NomC;
    @FXML TextField AgeC;
    @FXML Button ConfirmRm;
    public void ConfirmRm(){
        for(Costumers c : Bibliotheque.getCstmrs()){
            if(c.getNom().equals(NomC.getText())&&c.getAge()==Integer.parseInt(AgeC.getText())){
                for(Livre l : Bibliotheque.getBooks()){
                    if(l.getTitre().equals(c.getBook())){
                        l.setQuantity(l.getQuantity()+1);
                    }
                }
            }
        }
        Bibliotheque.getCstmrs().removeIf(c -> c.getNom().equals(NomC.getText())&& c.getAge()== Integer.parseInt(AgeC.getText()));
        stage.close();
    }
    //**************************About Bloc**************************
    public void About(){
        JOptionPane.showMessageDialog(null,"Written with Love & Java \nBy Benyamina","About",JOptionPane.INFORMATION_MESSAGE);
    }

}
