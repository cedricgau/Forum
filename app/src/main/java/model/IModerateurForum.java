package model;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 14/02/2021.
 */
public interface IModerateurForum {
    String supprimerNouvelle( Nouvelle n);
    String bannirUnAbonne (Abonne a );
    int ajouterAbonne ( Abonne a);
    String listerAbonnes();
    String[] listerNouvelles();
}
