package model;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 14/02/2021.
 */
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.DefaultData;


@RequiresApi(api = Build.VERSION_CODES.O)
public class Forum<E> implements ModeratorInterface.IAbonneForum, ModeratorInterface.IModerateurForum {

    private LocalDate dateCreation;
    private static String dateformater;
    public static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MM yyyy");
    private static String name_forum;
    private static List<Nouvelle> tabnouv = new ArrayList<>();
    private static List<AbonneInterface.Abonne> tababon = new ArrayList<>();



    public Forum(String name_forum) {
        setName_forum(name_forum);
        setDateCreation();
        DefaultData.Moderator.setForum(new Forum<ModeratorInterface.IModerateurForum>(name_forum,dateformater));
        AbonneInterface.Abonne.setForum(new Forum<ModeratorInterface.IAbonneForum>(name_forum,dateformater));
    }
    public Forum(String nomduforum, String dateformater) {

    }
    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public static void setDateCreation() {
        LocalDate date = LocalDate.now();
        dateformater = date.format(df);
    }
    public String getName_forum() {
        return name_forum;
    }
    public void setName_forum(String name_forum) {
        Forum.name_forum = name_forum;
    }
    public List<Nouvelle> getTabnouv() {
        return tabnouv;
    }
    public void setTabnouv(List<Nouvelle> tabnouv) {
        Forum.tabnouv = tabnouv;
    }
    public List<AbonneInterface.Abonne> getTababon() {
        return tababon;
    }
    public void setTababon(List<AbonneInterface.Abonne> tababon) {
        Forum.tababon = tababon;
    }


    @Override
    public boolean ajouterNouvelle(Nouvelle n) {
        if ( n!=null) {
            tabnouv.add(n);
            return true;
        }else {
            return false;
        }

    }@Override
    public int ajouterAbonne(AbonneInterface.Abonne a) {
        if ( a!=null) {
            tababon.add(a);
            return 1;
        }else {
            return 0;
        }

    }@Override
    public String bannirUnAbonne(AbonneInterface.Abonne a) {
        if ( a!=null) {
            tababon.remove(a);
            return a.getSurname_abon()+" "+a.getName_abon()+" a été banni";
        }else {
            return"Aucun abonné banni";
        }


    }
    @Override
    public String consulterNouvelle(int i) {
        return tabnouv.get(i).getSubject()+tabnouv.get(i).getText();
    }
    @Override
    public String listerAbonnes() {
        Iterator<AbonneInterface.Abonne> it = tababon.iterator();
        String list="\n";
        while(it.hasNext()) {
            AbonneInterface.Abonne b = it.next();
            list+=b.getName_abon()+" "+b.getSurname_abon()+" "+b.getAge_abon()+" ans\n";
        }
       return "Les abonnés sont :\n "+list;



    }@Override
    public void repondreNouvelle(int i) {


    }@Override
    public String supprimerNouvelle(Nouvelle n) {
        if ( n!=null) {
            tabnouv.remove(n);
            return "La nouvelle"+n.getSubject()+" "+n.getText()+" a été supprimée";

        }else {
            return "Aucune nouvelle supprimée";

        }
    }

    public String[] listerNouvelles() {
        String[] list = new String[tabnouv.size()];
        int u = 0;
        for(Nouvelle o : tabnouv) {
            list[u] = o.getSubject()+"--"+o.getText()+ "-----" + o.getDateCreation()+"\n";
            u++;
        }
        return list;
    }
    @Override
    public void deposerNouvelle(Nouvelle n) {
        this.ajouterNouvelle(n);

    }


    /**
     * Created by Cedric GAUTIER - AFPA TP's on 14/02/2021.
     */
    public static class Adresse {

        private int numero_rue;
        private String nom_rue;
        private int codePostal;
        private String ville;



        public Adresse(int i, String string, int j, String string2) {
            this.numero_rue=i;
            this.nom_rue=string;
            this.codePostal=j;
            this.ville=string2;
            // JOptionPane.showMessageDialog(null,i+", "+string+", "+j+" "+string2, " Adresse à "+string2.toString(), 1);

        }

        public String toString() {
            return numero_rue+", "+nom_rue+", "+codePostal+" "+ville;

        }

        public Adresse() {
            // TODO Auto-generated constructor stub
        }



        public int getNuméro_rue() {
            return numero_rue;
        }
        public void setNuméro_rue(int numéro_rue) {
            this.numero_rue = numéro_rue;
        }
        public String getNom_rue() {
            return nom_rue;
        }
        public void setNom_rue(String nom_rue) {
            this.nom_rue = nom_rue;
        }
        public int getCodePostal() {
            return codePostal;
        }
        public void setCodePostal(int codePostal) {
            this.codePostal = codePostal;
        }
        public String getVille() {
            return ville;
        }
        public void setVille(String ville) {
            this.ville = ville;
        }




    }

    public static class Nouvelle {
        private String subject;
        private String text;
        private LocalDate dateCreation;
        private Forum<ModeratorInterface.IAbonneForum> forum;


        @RequiresApi(api = Build.VERSION_CODES.O)
        public  Nouvelle(String subject, String text) {
            setSubject(subject);
            setText(text);
            setDateCreation(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()));

        }


        public Forum<ModeratorInterface.IAbonneForum> getForum() {
            return forum;
        }


        public void setForum(Forum<ModeratorInterface.IAbonneForum> forum) {
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
}