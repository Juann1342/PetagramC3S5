package com.juan.petagram3week.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.petagram3week.R;
import com.juan.petagram3week.adapter.MascotaAdaptador;
import com.juan.petagram3week.pojo.Mascota;
import com.juan.petagram3week.presenter.ListadoMascotasPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IListadoMascotasView {
    ArrayList<Mascota> mascotas;
    public MascotaAdaptador adaptador;
    //declaro recycler view
    private RecyclerView listaMascotas;
    private  ListadoMascotasPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_recyclerview, container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new ListadoMascotasPresenter(this, getContext());
        return v;
    }



  /*  public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Pilo", R.drawable.pet1,"5",01));
        mascotas.add(new Mascota("Luki",R.drawable.pet2,"4",02));
        mascotas.add(new Mascota("Fuxy",R.drawable.pet3,"2",03));
        mascotas.add(new Mascota("Pyt",R.drawable.pet4,"3",04));
        mascotas.add(new Mascota("Shampy",R.drawable.pet5,"4",05));
    }
*/
    @Override
    public void generarLinearLayoutVertical() {
        //defino de que forma quiero mostrar el recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}

