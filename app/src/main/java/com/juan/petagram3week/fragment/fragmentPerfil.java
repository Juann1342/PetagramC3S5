package com.juan.petagram3week.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juan.petagram3week.R;
import com.juan.petagram3week.adapter.MascotaAdaptador;
import com.juan.petagram3week.adapter.PerfilAdapter;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;


public class fragmentPerfil extends Fragment {
    ArrayList<Mascota> masc;
    public PerfilAdapter adapt;
    //declaro recycler view
    private RecyclerView listaMasc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaMasc = (RecyclerView) v.findViewById(R.id.rvPerfilM);

        //defino de que forma quiero mostrar el recyclerview
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        listaMasc.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        adapt = new PerfilAdapter(masc, getActivity());
        listaMasc.setAdapter(adapt);
    }

    public void inicializarListaMascotas(){
        masc = new ArrayList<Mascota>();
        masc.add(new Mascota("Petaco", R.drawable.petp1,"5",00));
        masc.add(new Mascota("Petaco",R.drawable.petp2,"2",01));
        masc.add(new Mascota("Petaco",R.drawable.petp3,"3",02));
        masc.add(new Mascota("Petaco",R.drawable.pet5,"4",03));
        masc.add(new Mascota("Petaco",R.drawable.petp4,"3",04));
        masc.add(new Mascota("Petaco",R.drawable.pet2,"4",05));

    }
}