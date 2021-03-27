package dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 26/03/2021.
 */
@Dao
public interface ForumDao {

        //@Insert(onConflict = OnConflictStrategy.REPLACE)
        //void createUser(User user);

       //@Query("SELECT * FROM User WHERE id = :userId")
        //LiveData<User> getUser(long userId);
}
