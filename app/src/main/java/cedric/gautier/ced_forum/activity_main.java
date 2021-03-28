package cedric.gautier.ced_forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;


import dao.DatabaseManager;
import dao.ForumDao;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 28/02/2021.
 */
public class activity_main extends Activity {

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

        moderator = (Button) findViewById(R.id.moderator_btn);
        abonne = (Button) findViewById(R.id.abonne_btn);
        name = (EditText) findViewById(R.id.name_txt);



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
