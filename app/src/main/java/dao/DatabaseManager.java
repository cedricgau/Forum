package dao;

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
import java.util.ArrayList;
import java.util.List;

import model.Abonne;
import model.Moderator;
import model.Nouvelle;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Forum.db";
    private static final int DATABASE_VERSION = 2;

    public DatabaseManager( Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table Abonne ("
                + "    idAbonne integer primary key autoincrement,"
                + "    name_abon text not null,"
                + "    surname_abon text not null,"
                + "    age_abon integer not null,"
                + "    avertissement integer not null"
                + ")";
        String strSql2 = "create table Moderateur ("
                + "    idAbonne integer primary key autoincrement,"
                + "    name_moder text not null,"
                + "    surname_moder text not null,"
                + "    age_moder integer not null"
                + ")";
        String strSql3 = "create table Nouvelle ("
                + "    idAbonne integer primary key autoincrement,"
                + "    subject text not null,"
                + "    text text not null,"
                + "    dateCreation Date not null"
                + ")";

        db.execSQL( strSql );
        db.execSQL( strSql2 );
        db.execSQL( strSql3 );

        Log.i( "DATABASE", "onCreate invoked" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String strSql = "alter table T_Scores add column ...";
//        String strSql = "drop table T_Scores";
//        db.execSQL( strSql );
//        this.onCreate( db );
        Log.i( "DATABASE", "onUpgrade invoked" );
    }

    public void insertA( String name, String surname,int age,int aver ) {
        /*name = name.replace( "'", "''" );
        surname = surname.replace( "'", "''" );*/
        String strSql = "insert into Abonne (name_abon, surname_abon,age_abon, avertissement) values ('"+ name + "','"+ surname + "', " + age + ", " + aver + ")";
        this.getWritableDatabase().execSQL( strSql );
        Log.i( "DATABASE", "insertScore invoked" );
    }
    public void insertM( String name, String surname,int age) {
        name = name.replace( "'", "''" );
        surname = surname.replace( "'", "''" );
        String strSql2 = "insert into Moderateur (name_moder, surname_moder,age_moder) values ('"+ name + "','"+ surname + "'," + age+")";
        this.getWritableDatabase().execSQL( strSql2 );
        Log.i( "DATABASE", "insertScore invoked" );
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertN(String sub, String txt) {
        /*sub = sub.replace( "'", "''" );
        txt = txt.replace( "'", "''" );*/
        String strSql3 = "insert into Nouvelle (subject, text,dateCreation) values ('"+ sub + "','"+ txt + "','" + Date.valueOf(String.valueOf(LocalDate.now()))+"')";
        this.getWritableDatabase().execSQL( strSql3 );
        Log.i( "DATABASE", "insertScore invoked" );
    }



}


