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
public class Moderator{
    @PrimaryKey
    private int idModerator;
    @ColumnInfo(name = "name_moder")
    private String name_moder;
    @ColumnInfo(name = "surname_moder")
    private String surname_moder;
    @ColumnInfo(name = "age_moder")
    private int age_moder;
    static Forum<IModerateurForum> forum;




    public Moderator(String name_moder,String surname_moder, int age_moder) {
        setAge_moder(age_moder);
        setName_moder(name_moder);
        setSurname_moder(surname_moder);
    }


    public static Forum<IModerateurForum> getForum() {
        return forum;
    }
    public static void setForum(Forum<IModerateurForum> forum) {
        Moderator.forum = forum;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int ajouterAbonne(Abonne a) {
        forum.ajouterAbonne(a);
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String exclureAbonne(Abonne a) {
        if(a.getAvertissement()>2) {
            forum.bannirUnAbonne(a);
        }else {
            return "L'abonné doit être averti encore "+(3-a.getAvertissement())+" fois avant d'être banni";
        }

        return "";
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void supprimerNouvelle(Nouvelle n) {
        forum.supprimerNouvelle(n);

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String afficherLesAbonnes() {
        return forum.listerAbonnes();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String[] afficherLesNouvelles() {
        return forum.listerNouvelles();
    }

    public String getName_moder() {
        return name_moder;
    }
    public void setName_moder(String name_moder) {
        this.name_moder = name_moder;
    }
    public String getSurname_moder() {
        return surname_moder;
    }
    public void setSurname_moder(String surname_moder) {
        this.surname_moder = surname_moder;
    }
    public int getAge_moder() {
        return age_moder;
    }
    public void setAge_moder(int age_moder) {
        this.age_moder = age_moder;
    }

    public String avertir(Abonne a) {
        String mess = "Avertissement";
        a.setAvertissement(1);
        return "Abonné : "+a.getSurname_abon()+" "+a.getName_abon()+" , "+ mess+". Vous avez "+a.getAvertissement()+" avertissement(s)";
    }
    public int getIdModerator() {
        return this.idModerator;
    }

    public void setIdModerator(final int idModerator) {
        this.idModerator = idModerator;
    }


}