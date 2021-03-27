package model;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import cedric.gautier.ced_forum.R;
import dao.DefaultData;


public class AbonneInterface extends Activity {

    private TextView abonne;
    private RecyclerView mRecyclerView;
    private String s[],s1[],s2[],s3[];
    int images[] = {R.drawable.index,R.drawable.index2,R.drawable.index3,R.drawable.index4,R.drawable.index5};

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_abonne_interface);


        abonne = (TextView) findViewById(R.id.abonne_txt);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        //création d'un modérateur
       Moderator cedric = new Moderator("gautier","cedric",47);
        s=cedric.afficherLesNouvelles();
        s1= new String[s.length];
        s2= new String[s.length];
        s3= new String[s.length];
        int k=0;
        for(String i : s){
            String j[] = i.split("-----");
            s1[k] = j[0];
            s2[k] = j[1];
            s3[k] = j[2];
            k++;
        }



        //Titre de bienvenu
        abonne.setText("Bienvenu "+ getIntent().getStringExtra("nom").toUpperCase() +" dans ce forum");

        //création des nouvelles
        //Nouvelle a = new Nouvelle("Java ---", "C'est bien ? Java est une technique informatique développée initialement par Sun Microsystems puis acquise par Oracle suite au rachat de l'entreprise. Défini à l'origine comme un langage de programmation, Java a évolué pour devenir un ensemble cohérent d'éléments techniques et non techniques.");


        NouvelleInterface listeNouvelles = new NouvelleInterface(this,s1,s2,s3,images);
        mRecyclerView.setAdapter(listeNouvelles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // nouvelles déposées par les abonnés
        //catherine.deposerNouvelle(d);

        //marcel.creerNouvelle();

        // Le modérateur supprime une nouvelle
        //cedric.supprimerNouvelle(d);

        // Modérateur affiche les nouvelles
        // builder.setMessage(cedric.afficherLesNouvelles()).show();

        // Un abonné lit une nouvelle
        // builder.setMessage(marcel.lireNouvelle(2)).show();
    }



}