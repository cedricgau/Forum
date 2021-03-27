package model;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 14/02/2021.
 */
public interface IAbonneForum {

    boolean ajouterNouvelle(Nouvelle n);
    String consulterNouvelle( int i);
    void repondreNouvelle( int i );
    void deposerNouvelle(Nouvelle n);

}