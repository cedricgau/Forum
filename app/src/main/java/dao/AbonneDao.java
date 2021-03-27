package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import model.Abonne;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 26/03/2021.
 */
@Dao
public interface AbonneDao {
    //@Query("SELECT * FROM Abonne WHERE idAbonne = :idAbonne")
    //LiveData<List<Abonne>> getItems(int idAbonne);

   // @Insert
    //long insertItem(Abonne item);

    //@Update
    //int updateItem(Abonne abonne);

   // @Query("DELETE FROM Abonne WHERE idAbonne = :idAbonne")
    //int deleteItem(int idAbonne);
}
