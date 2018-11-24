package Bibliotheque;

public class Costumers {
    private String nom;
    private int age;
    private String type;
    private int joursDeLocation;
    private String Book;

    public Costumers(){}

    public Costumers(String nom, int age, String type,int joursDeLocation) {
        this.nom = nom;
        this.age = age;
        this.type = type;
        this.joursDeLocation=joursDeLocation;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        nom = nom;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        age = age;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        type = type;
    }

    public int getJoursDeLocation() {
        return joursDeLocation;
    }
    public void setJoursDeLocation(int joursDeLocation) {
        this.joursDeLocation = joursDeLocation;
    }

    public String getBook() {
        return Book;
    }
    public void setBook(String book) {
        Book = book;
    }

    @Override
    public String toString() {
        return "Costumer :" +
                "nom :" + nom + '\'' +
                ", age :" + age +
                ", type :" + type + '\'' +
                ", joursDeLocation :" + joursDeLocation+ '\''+
                ", livre :" +Book +'\''+
                "\n";
    }
}
