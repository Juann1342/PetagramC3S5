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

import com.juan.petagram3week.db.ConstructorMascotas;
import com.juan.petagram3week.pojo.Mascota;
import com.juan.petagram3week.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    //mi lista
    ArrayList<Mascota> mascotas;
    Activity activity;

    @NonNull

    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //le da vida al layout cardview
        //indicamos cual es el layout qe esta reciclando el recyclerview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {

        //pasamos la lista de contactos
        //seteamos los valores
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingCV.setText(mascota.getRating());

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvRatingCV.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
            }
        });

    }

    public int getItemCount() { //cantidad de elementos qe contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvRatingCV;
        private ImageButton btnLike;
        //declaro todos los view que tengo en el card view

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
