package dao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import model.AbonneInterface;
import model.Forum;
import model.ModeratorInterface;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 06/03/2021.
 */
public class DefaultData {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DefaultData(String nom_forum){
        // création du forum
        new Forum( nom_forum);

        //création d'un modérateur
        Moderator cedric = new Moderator("gautier","cedric",47);

        // création par défaut d'abonnés
        AbonneInterface.Abonne marcel = new AbonneInterface.Abonne("Dupont","Marcel",33);
        AbonneInterface.Abonne pierre = new AbonneInterface.Abonne("Martin","Pierre",22);
        AbonneInterface.Abonne nathalie = new AbonneInterface.Abonne("Morin","Nathalie",22);
        AbonneInterface.Abonne catherine = new AbonneInterface.Abonne("Charpentier","Catherine",55);

        // ajout des abonnés par défault

        cedric.ajouterAbonne(catherine);
        cedric.ajouterAbonne(marcel);
        cedric.ajouterAbonne(nathalie);
        cedric.ajouterAbonne(pierre);

        // creation par défaut de nouvelles

        Forum.Nouvelle a = new Forum.Nouvelle("Java ---", "C'est bien ? Java est une technique informatique développée initialement par Sun Microsystems puis acquise par Oracle suite au rachat de l'entreprise. Défini à l'origine comme un langage de programmation, Java a évolué pour devenir un ensemble cohérent d'éléments techniques et non techniques.");
        Forum.Nouvelle b = new Forum.Nouvelle("Interface ---", "Principe indispensable en Java, une interface dans le langage de programmation Java est un type abstrait qui est utilisé pour spécifier un comportement que les classes doivent implémenter. They are similar to protocols. Interfaces are declared using the interface keyword, and may only contain method signature and constant declarations.");
        Forum.Nouvelle c = new Forum.Nouvelle("Classe abstraite ---", "C'est une classe non instanciable, dès qu'une classe contient une méthode abstraite, elle doit elle aussi être déclarée abstraite, avec le modificateur abstract placé au début de son en-tête .");
        Forum.Nouvelle d = new Forum.Nouvelle("Classe concrète ---", "Les classes concrètes qui s'étendent une ou plusieurs classes abstraites (indirectement), doit obligatoirement fournir une implémentation pour toutes les méthodes abstraites existantes.");
        Forum.Nouvelle e = new Forum.Nouvelle("Spring ---", "En informatique, Spring est un framework open source pour construire et définir l'infrastructure d'une application Java3, dont il facilite le développement et les tests. En 2004, Rod Johnson a écrit le livre Expert One-on-One J2EE Design and Development4 qui explique les raisons de la création de Spring. Spring est considéré comme un conteneur dit « léger ». La raison de ce nommage est expliquée par Erik Gollot dans l’introduction du document Introduction au framework Spring5. Spring est effectivement un conteneur dit « léger », c’est-à-dire une infrastructure similaire à un serveur d'applications J2EE. Il prend donc en charge la création d’objets et la mise en relation d’objets par l’intermédiaire d’un fichier de configuration qui décrit les objets à fabriquer et les relations de dépendances entre ces objets. Le gros avantage par rapport aux serveurs d’application est qu’avec Spring, les classes n’ont pas besoin d’implémenter une quelconque interface pour être prises en charge par le framework (au contraire des serveurs d'applications J2EE et des EJBs). C’est en ce sens que Spring est qualifié de conteneur « léger ».");

        // nouvelles déposées par les abonnés

        marcel.deposerNouvelle(a);
        pierre.deposerNouvelle(b);
        nathalie.deposerNouvelle(c);
        catherine.deposerNouvelle(d);
        catherine.deposerNouvelle(e);
    }

    public static class Moderator{
            private String name_moder;
            private String surname_moder;
            private int age_moder;
            static Forum<ModeratorInterface.IModerateurForum> forum;




            public Moderator(String name_moder,String surname_moder, int age_moder) {
                setAge_moder(age_moder);
                setName_moder(name_moder);
                setSurname_moder(surname_moder);
            }


            public static Forum<ModeratorInterface.IModerateurForum> getForum() {
                return forum;
            }
            public static void setForum(Forum<ModeratorInterface.IModerateurForum> forum) {
                Moderator.forum = forum;

            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            public int ajouterAbonne(AbonneInterface.Abonne a) {
                forum.ajouterAbonne(a);
                return 0;
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            public String exclureAbonne(AbonneInterface.Abonne a) {
                if(a.getAvertissement()>2) {
                    forum.bannirUnAbonne(a);
                }else {
                    return "L'abonné doit être averti encore "+(3-a.getAvertissement())+" fois avant d'être banni";
                }

                return "";
            }
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void supprimerNouvelle(Forum.Nouvelle n) {
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

            public String avertir(AbonneInterface.Abonne a) {
                String mess = "Avertissement";
                a.setAvertissement(1);
               return "Abonné : "+a.getSurname_abon()+" "+a.getName_abon()+" , "+ mess+". Vous avez "+a.getAvertissement()+" avertissement(s)";
            }


        }
}
