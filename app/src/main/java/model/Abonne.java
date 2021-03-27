package model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 26/03/2021.
 */
@Entity
public class Abonne{
    @PrimaryKey
    private int idAbonne;
    @ColumnInfo(name = "name_abon")
    private String name_abon;
    @ColumnInfo(name = "surname_abon")
    private String surname_abon;
    @ColumnInfo(name = "age_abon")
    private int age_abon;
    @ColumnInfo(name = "avertissement")
    private int avertissement;
    public static Forum<IAbonneForum> forum;

    public Abonne(String name_abon,String surname_abon,int age_abon) {
        setAge_abon(age_abon);
        setName_abon(name_abon);
        setSurname_abon(surname_abon);
    }


    public static Forum<IAbonneForum> getForum() {
        return forum;
    }

    public static void setForum(Forum<IAbonneForum> forum) {
        Abonne.forum = forum;
    }

    public String getName_abon() {
        return name_abon;
    }

    public void setName_abon(String name_abon) {
        this.name_abon = name_abon;
    }

    public String getSurname_abon() {
        return surname_abon;
    }

    public void setSurname_abon(String surname_abon) {
        this.surname_abon = surname_abon;
    }

    public int getAge_abon() {
        return age_abon;
    }

    public void setAge_abon(int age_abon) {
        this.age_abon = age_abon;
    }

    public int getAvertissement() {
        return avertissement;
    }


    public void setAvertissement(int avertissement) {
        this.avertissement += avertissement;
    }
    public int getIdAbonne() {return this.idAbonne;}

    public void setIdAbonne(final int idAbonne) {this.idAbonne = idAbonne; }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void creerNouvelle() {
        String subject="Nouvelle";
        String text="Texte du message";
        Nouvelle e = new Nouvelle(subject,text);
        forum.ajouterNouvelle(e);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void deposerNouvelle(Nouvelle nelle) {
        forum.deposerNouvelle(nelle);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String lireNouvelle(int i) {
        return forum.consulterNouvelle(i);
    }

    public void repondreNouvelle(Nouvelle nelle) {

    }


}
