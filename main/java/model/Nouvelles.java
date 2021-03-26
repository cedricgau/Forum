package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cedric.gautier.ced_forum.R;

/**
 * Created by Cedric GAUTIER - AFPA TP's on 06/03/2021.
 */
public class Nouvelles extends RecyclerView.Adapter<Nouvelles.NouvelleTenue> {

    String data1[],data2[],data3[];
    Context mContext;
    int images[];

    public Nouvelles(Context ct, String s1[], String s2[], String s3[], int img[]){
        mContext=ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        images = img;
    }
    @NonNull
    @Override
    public NouvelleTenue onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.the_rows,parent,false);
        return new NouvelleTenue(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NouvelleTenue holder, int position) {
    holder.titre_nouvelle.setText(data1[position]);
    holder.texte_nouvelle.setText(data2[position]);
    holder.date_nouvelle.setText("Message posté le : "+data3[position]);
    holder.mImageView.setImageResource(images[position]);
    holder.texte_nouvelle.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(mContext,"Interface de la Nouvelle : "+data1[position]+" , en cours de construction !",Toast.LENGTH_SHORT).show();
        }
    });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class NouvelleTenue extends RecyclerView.ViewHolder{
        TextView titre_nouvelle,texte_nouvelle,date_nouvelle;
        ImageView mImageView;


        public NouvelleTenue(@NonNull View itemView){
            super(itemView);
            titre_nouvelle = itemView.findViewById(R.id.titre_nouvelle);
            texte_nouvelle = itemView.findViewById(R.id.texte_nouvelle);
            date_nouvelle = itemView.findViewById(R.id.date_nouvelle);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }
}
