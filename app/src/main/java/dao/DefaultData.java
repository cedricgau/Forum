package dao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import model.Abonne;
import model.AbonneInterface;
import model.Forum;
import model.Moderator;
import model.ModeratorInterface;
import model.Nouvelle;

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
        Abonne marcel = new Abonne("Dupont","Marcel",33);
        Abonne pierre = new Abonne("Martin","Pierre",22);
        Abonne nathalie = new Abonne("Morin","Nathalie",22);
        Abonne catherine = new Abonne("Charpentier","Catherine",55);

        // ajout des abonnés par défault

        cedric.ajouterAbonne(catherine);
        cedric.ajouterAbonne(marcel);
        cedric.ajouterAbonne(nathalie);
        cedric.ajouterAbonne(pierre);

        // creation par défaut de nouvelles

       Nouvelle a = new Nouvelle("Java ---", "C'est bien ? Java est une technique informatique développée initialement par Sun Microsystems puis acquise par Oracle suite au rachat de l'entreprise. Défini à l'origine comme un langage de programmation, Java a évolué pour devenir un ensemble cohérent d'éléments techniques et non techniques.");
        Nouvelle b = new Nouvelle("Interface ---", "Principe indispensable en Java, une interface dans le langage de programmation Java est un type abstrait qui est utilisé pour spécifier un comportement que les classes doivent implémenter. They are similar to protocols. Interfaces are declared using the interface keyword, and may only contain method signature and constant declarations.");
        Nouvelle c = new Nouvelle("Classe abstraite ---", "C'est une classe non instanciable, dès qu'une classe contient une méthode abstraite, elle doit elle aussi être déclarée abstraite, avec le modificateur abstract placé au début de son en-tête .");
        Nouvelle d = new Nouvelle("Classe concrète ---", "Les classes concrètes qui s'étendent une ou plusieurs classes abstraites (indirectement), doit obligatoirement fournir une implémentation pour toutes les méthodes abstraites existantes.");
        Nouvelle e = new Nouvelle("Spring ---", "En informatique, Spring est un framework open source pour construire et définir l'infrastructure d'une application Java3, dont il facilite le développement et les tests. En 2004, Rod Johnson a écrit le livre Expert One-on-One J2EE Design and Development4 qui explique les raisons de la création de Spring. Spring est considéré comme un conteneur dit « léger ». La raison de ce nommage est expliquée par Erik Gollot dans l’introduction du document Introduction au framework Spring5. Spring est effectivement un conteneur dit « léger », c’est-à-dire une infrastructure similaire à un serveur d'applications J2EE. Il prend donc en charge la création d’objets et la mise en relation d’objets par l’intermédiaire d’un fichier de configuration qui décrit les objets à fabriquer et les relations de dépendances entre ces objets. Le gros avantage par rapport aux serveurs d’application est qu’avec Spring, les classes n’ont pas besoin d’implémenter une quelconque interface pour être prises en charge par le framework (au contraire des serveurs d'applications J2EE et des EJBs). C’est en ce sens que Spring est qualifié de conteneur « léger ».");

        // nouvelles déposées par les abonnés

        marcel.deposerNouvelle(a);
        pierre.deposerNouvelle(b);
        nathalie.deposerNouvelle(c);
        catherine.deposerNouvelle(d);
        catherine.deposerNouvelle(e);
    }


}
