package cedric.gautier.ced_forum;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;


import dao.DatabaseManager;
import dao.DefaultData;
import model.Abonne;
import model.Moderator;
import model.Nouvelle;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 28/02/2021.
 */
public class activity_main extends Activity {
    private DatabaseManager databaseManager;
    private Button moderator,abonne;
    private EditText name;
    private String nom;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        databaseManager = new DatabaseManager( this );

        databaseManager.insertA( "Dupont","Marcel",33,0);
        databaseManager.insertA( "Martin","Pierre",22,0);
        databaseManager.insertA( "Morin","Nathalie",22,0);
        databaseManager.insertA( "Charpentier","Catherine",55,0);

        databaseManager.insertM("gautier","cedric",47);

        databaseManager.insertN("Java ---", "C’est bien ? Java est une technique informatique développée initialement par Sun Microsystems puis acquise par Oracle suite au rachat de l’entreprise. Défini à l’origine comme un langage de programmation, Java a évolué pour devenir un ensemble cohérent d’éléments techniques et non techniques.");

        databaseManager.insertN("Interface ---", "Principe indispensable en Java, une interface dans le langage de programmation Java est un type abstrait qui est utilisé pour spécifier un comportement que les classes doivent implémenter. They are similar to protocols. Interfaces are declared using the interface keyword, and may only contain method signature and constant declarations.");
        databaseManager.insertN("Classe abstraite ---", "C’est une classe non instanciable, dès qu’une classe contient une méthode abstraite, elle doit elle aussi être déclarée abstraite, avec le modificateur abstract placé au début de son en-tête .");
        databaseManager.insertN("Classe concrète ---", "Les classes concrètes qui s’étendent une ou plusieurs classes abstraites (indirectement), doit obligatoirement fournir une implémentation pour toutes les méthodes abstraites existantes.");
        databaseManager.insertN("Spring ---", "En informatique, Spring est un framework open source pour construire et définir l’infrastructure d’une application Java3, dont il facilite le développement et les tests. En 2004, Rod Johnson a écrit le livre Expert One-on-One J2EE Design and Development4 qui explique les raisons de la création de Spring. Spring est considéré comme un conteneur dit « léger ». La raison de ce nommage est expliquée par Erik Gollot dans l’introduction du document Introduction au framework Spring5. Spring est effectivement un conteneur dit « léger », c’est-à-dire une infrastructure similaire à un serveur d’applications J2EE. Il prend donc en charge la création d’objets et la mise en relation d’objets par l’intermédiaire d’un fichier de configuration qui décrit les objets à fabriquer et les relations de dépendances entre ces objets. Le gros avantage par rapport aux serveurs d’application est qu’avec Spring, les classes n’ont pas besoin d’implémenter une quelconque interface pour être prises en charge par le framework (au contraire des serveurs d’applications J2EE et des EJBs). C’est en ce sens que Spring est qualifié de conteneur « léger ».");


        databaseManager.close();


        moderator = (Button) findViewById(R.id.moderator_btn);
        abonne = (Button) findViewById(R.id.abonne_btn);
        name = (EditText) findViewById(R.id.name_txt);

        new DefaultData("THE FORUM");

        moderator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(activity_main.this, model.ModeratorInterface.class));
            }
        });
        abonne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_main.this, model.AbonneInterface.class);
                i.putExtra("nom",name.getText().toString());
                startActivityForResult(i,RESULT_OK);
            }
        });



    }
}
