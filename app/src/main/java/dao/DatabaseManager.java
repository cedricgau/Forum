package dao;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Abonne;
import model.Forum;
import model.Moderator;
import model.Nouvelle;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Forum.db";
    private static final int DATABASE_VERSION = 2;

    public DatabaseManager( Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(SQLiteDatabase db) {
        creaBase(db);
        Log.i( "DATABASE", "onCreate invoked" );
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String strSql = "alter table Abonne add column ...";
        // destruction des anciennes tables

        String strSql = "drop table Abonne";
        String strSql2 = "drop table Nouvelle";
        String strSql3 = "drop table Moderateur";

        db.execSQL( strSql );
        db.execSQL( strSql2 );
        db.execSQL( strSql3 );
        this.onCreate(db);

        Log.i( "DATABASE", "onUpgrade invoked" );
    }

    public void insertA( String name, String surname,int age,int aver ) {

        String strSql = "insert into Abonne (name_abon, surname_abon,age_abon, avertissement) values ('"+ name + "','"+ surname + "', " + age + ", " + aver + ")";
        this.getWritableDatabase().execSQL( strSql );
        Log.i( "DATABASE", "insertScore invoked" );
    }
    public void insertM( String name, String surname,int age) {

        String strSql2 = "insert into Moderateur (name_moder, surname_moder,age_moder) values ('"+ name + "','"+ surname + "'," + age+")";
        this.getWritableDatabase().execSQL( strSql2 );
        Log.i( "DATABASE", "insertScore invoked" );
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertN(String sub, String txt) {

        String strSql3 = "insert into Nouvelle (subject, text,dateCreation) values ('"+ sub + "','"+ txt + "','" + Date.valueOf(String.valueOf(LocalDate.now()))+"')";
        this.getWritableDatabase().execSQL( strSql3 );
        Log.i( "DATABASE", "insertScore invoked" );

    }




    public void creaBase(SQLiteDatabase db) {


        // creation des tables

        String strSql4 = "create table Abonne ("
                + "    idAbonne integer primary key autoincrement,"
                + "    name_abon text not null,"
                + "    surname_abon text not null,"
                + "    age_abon integer not null,"
                + "    avertissement integer not null"
                + ")";
        String strSql5 = "create table Moderateur ("
                + "    idAbonne integer primary key autoincrement,"
                + "    name_moder text not null,"
                + "    surname_moder text not null,"
                + "    age_moder integer not null"
                + ")";
        String strSql6 = "create table Nouvelle ("
                + "    idAbonne integer primary key autoincrement,"
                + "    subject text not null,"
                + "    text text not null,"
                + "    dateCreation Date not null"
                + ")";

        db.execSQL(strSql4);
        db.execSQL(strSql5);
        db.execSQL(strSql6);
    }
        @RequiresApi(api = Build.VERSION_CODES.O)
        public void idGeneric(){

        // creation d'un Forum dans la base

        // création d'un modérateur dans la base

        insertM("gautier","cedric",47);

        // création de pseudos abonnés dans la base

        insertA( "Dupont","Marcel",33,0);
        insertA( "Martin","Pierre",22,0);
        insertA( "Morin","Nathalie",22,0);
        insertA( "Charpentier","Catherine",55,0);

        // création de pseudos nouvelles dans la base

        insertN("Java ---", "C’est bien ? Java est une technique informatique développée initialement par Sun Microsystems puis acquise par Oracle suite au rachat de l’entreprise. Défini à l’origine comme un langage de programmation, Java a évolué pour devenir un ensemble cohérent d’éléments techniques et non techniques.");
        insertN("Interface ---", "Principe indispensable en Java, une interface dans le langage de programmation Java est un type abstrait qui est utilisé pour spécifier un comportement que les classes doivent implémenter. They are similar to protocols. Interfaces are declared using the interface keyword, and may only contain method signature and constant declarations.");
        insertN("Classe abstraite ---", "C’est une classe non instanciable, dès qu’une classe contient une méthode abstraite, elle doit elle aussi être déclarée abstraite, avec le modificateur abstract placé au début de son en-tête .");
        insertN("Classe concrète ---", "Les classes concrètes qui s’étendent une ou plusieurs classes abstraites (indirectement), doit obligatoirement fournir une implémentation pour toutes les méthodes abstraites existantes.");
        insertN("Spring ---", "En informatique, Spring est un framework open source pour construire et définir l’infrastructure d’une application Java3, dont il facilite le développement et les tests. En 2004, Rod Johnson a écrit le livre Expert One-on-One J2EE Design and Development4 qui explique les raisons de la création de Spring. Spring est considéré comme un conteneur dit « léger ». La raison de ce nommage est expliquée par Erik Gollot dans l’introduction du document Introduction au framework Spring5. Spring est effectivement un conteneur dit « léger », c’est-à-dire une infrastructure similaire à un serveur d’applications J2EE. Il prend donc en charge la création d’objets et la mise en relation d’objets par l’intermédiaire d’un fichier de configuration qui décrit les objets à fabriquer et les relations de dépendances entre ces objets. Le gros avantage par rapport aux serveurs d’application est qu’avec Spring, les classes n’ont pas besoin d’implémenter une quelconque interface pour être prises en charge par le framework (au contraire des serveurs d’applications J2EE et des EJBs). C’est en ce sens que Spring est qualifié de conteneur « léger ».");

        // fermeture de la database Forum


        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        public void init() {

            // récupération d'un Modérateur de la base Forum

            String strSQL7 = " Select * from Moderateur";
            Cursor cursor = this.getReadableDatabase().rawQuery(strSQL7,null);
            cursor.moveToNext();
            Moderator cedric = new Moderator(cursor.getString(2), cursor.getString(3), cursor.getInt(4));

            
             // récupération et ajout des Abonnés de la base Forum

            String strSQL8 = " Select * from Abonne";
            cursor = this.getReadableDatabase().rawQuery(strSQL8,null);
            while(cursor.moveToNext()){
                cedric.ajouterAbonne(new Abonne(cursor.getString(2), cursor.getString(3), cursor.getInt(4)));
                cursor.moveToNext();
            }
            
            Abonne autre = null;
            String strSQL9 = " Select * from Nouvelle";
            cursor = this.getReadableDatabase().rawQuery(strSQL9,null);
            while(cursor.moveToNext()){
                autre.deposerNouvelle(new Nouvelle(cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
           cursor.close();

        }
    }


