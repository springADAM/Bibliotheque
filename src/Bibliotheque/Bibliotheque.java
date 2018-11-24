package Bibliotheque;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;

public class Bibliotheque extends Thread{

    private static ArrayList<Livre> books = new ArrayList<>() ;
    private static ArrayList<Costumers> cstmrs = new ArrayList<>();
    private static ArrayList<String> Historique = new ArrayList<>();

    public void deleteABook(String BookName){
            books.removeIf(b-> b.getTitre().equals(BookName));
    }
    public void showBooks(){
        if(books.size()!=0) {
            JOptionPane.showMessageDialog(null, books, "La Liste des Livres", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"there is no book currently :)");
        }
    }
    public void addBook(Livre l){books.add(l);}
    private boolean Available(String nom){
        boolean rtrn = false;
        for(Livre x : books){
            if(x.getTitre().equals(nom)){
                JOptionPane.showMessageDialog(null,x,"It's Available",JOptionPane.INFORMATION_MESSAGE);
                rtrn= true;
            }
        }
        if(!rtrn){
            JOptionPane.showMessageDialog(null,"Sorry this Book doesn't exist :(","warning",JOptionPane.INFORMATION_MESSAGE);
        }
        return rtrn ;
    }

    public void louer(Costumers c , String l ){
        cstmrs.add(c);
        if(Available(l)){
            for(Livre x :books) {
                if(x.getTitre().equals(l)&&x.getQuantity()!=0) {
                    JOptionPane.showMessageDialog(null, "Dear :" + c.getNom() + " thanks for your loyalty\nEnjoy Reading", "Enjoy Reading", JOptionPane.INFORMATION_MESSAGE);
                    Historique.add(c+ " Book : "+l+" \nDate de location : "+ new Date().toString()+"\n");
                    x.setQuantity(x.getQuantity()-1);
                    c.setBook(l);
                }else{
                    if(x.getQuantity()==0){
                        JOptionPane.showMessageDialog(null,"Sorry we run out of this book","Sorry",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }

    @Override
    public void run(){
        //noinspection InfiniteLoopStatement
        while(true) {
            System.out.println("thread is running");
            ListIterator<Costumers> iterator = cstmrs.listIterator();
                while (iterator.hasNext()) {
                        Costumers c = iterator.next();
                    c.setJoursDeLocation(c.getJoursDeLocation() - 1);
                    if (c.getJoursDeLocation() <= 0) {
                        if (JOptionPane.showConfirmDialog(null, c.getNom() + " Didn't return the book .. i think you should call the cops ", "Warning", JOptionPane.YES_NO_OPTION) == 0) {
                            try {
                                JOptionPane.showMessageDialog(null, "i'll remind you again in 30 s", "Reminder", JOptionPane.INFORMATION_MESSAGE);
                                sleep(30000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,"then you should remove the costumer manually","Message",JOptionPane.INFORMATION_MESSAGE);
                        }
                }
            }
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Livre> getBooks() {
        return books;
    }

    public static void setBooks(ArrayList<Livre> books) {
        books = books;
    }

    public static ArrayList<Costumers> getCstmrs() {
        return cstmrs;
    }

    public static void setCstmrs(ArrayList<Costumers> cstmrs) {
        cstmrs = cstmrs;
    }

    public static ArrayList<String> getHistorique() {
        return Historique;
    }

    public static void setHistorique(ArrayList<String> historique) {
        Historique = historique;
    }
}
