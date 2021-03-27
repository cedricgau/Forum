package model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 26/03/2021.
 */
public class Nouvelle {
    private String subject;
    private String text;
    private LocalDate dateCreation;
    private Forum<IAbonneForum> forum;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public  Nouvelle(String subject, String text) {
        setSubject(subject);
        setText(text);
        setDateCreation(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()));

    }


    public Forum<IAbonneForum> getForum() {
        return forum;
    }


    public void setForum(Forum<IAbonneForum> forum) {
        this.forum = forum;
    }


    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public LocalDate getDateCreation() {
        return dateCreation;
    }


    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }


}