package dao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import model.Forum;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 28/03/2021.
 */
public class ForumDao {


    private String nom_forum;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ForumDao(String nomfor) {
        setNom_forum(nomfor);
        new Forum(nom_forum);
    }

    public String getNom_forum() {
        return this.nom_forum;
    }

    public void setNom_forum(final String nom_forum) {
        this.nom_forum = nom_forum;
    }
}
