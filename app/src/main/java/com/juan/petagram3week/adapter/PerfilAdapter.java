package com.juan.petagram3week.adapter;

import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.petagram3week.R;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder> {
    public PerfilAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    //mi lista
    ArrayList<Mascota> mascotas;
    Activity activity;


    @NonNull

    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //le da vida al layout cardview
        //indicamos cual es el layout qe esta reciclando el recyclerview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_img_perfil, parent, false);
        return new PerfilViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onBindViewHolder(@NonNull PerfilViewHolder perfilViewHolder, int position) {

        //pasamos la lista de contactos
        //seteamos los valores
        Mascota mascota = mascotas.get(position);
        perfilViewHolder.imgFoto.setImageResource(mascota.getFoto());
        perfilViewHolder.tvRatingCV.setText(mascota.getRating());


    }

    public int getItemCount() { //cantidad de elementos qe contiene mi lista
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvRatingCV;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingCV);
        }
    }
}
