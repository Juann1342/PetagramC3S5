package com.juan.petagram3week.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.petagram3week.R;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritasAdaptador extends RecyclerView.Adapter<MascotasFavoritasAdaptador.MascotasFavoritasViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotasFavoritasAdaptador(ArrayList<Mascota> mascotas, Activity activity){

        this.mascotas = mascotas;
        this.activity  = activity;
    }


    @NonNull
    @Override
    public MascotasFavoritasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotasFavoritasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasFavoritasViewHolder mascotasFavoritasViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotasFavoritasViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotasFavoritasViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotasFavoritasViewHolder.tvLike.setText(String.valueOf(mascota.getRating()));
    }


    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista.
     return mascotas.size();
    }


    public static class MascotasFavoritasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageView imgLike;
        private TextView tvLike;


        public MascotasFavoritasViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
            imgLike     = (ImageView) itemView.findViewById(R.id.imgHueso);
            tvLike      = (TextView) itemView.findViewById(R.id.tvRatingCV);


        }


    }
}




