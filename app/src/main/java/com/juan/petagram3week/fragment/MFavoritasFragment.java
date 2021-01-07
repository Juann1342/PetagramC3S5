package com.juan.petagram3week.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.petagram3week.R;
import com.juan.petagram3week.adapter.MascotasFavoritasAdaptador;
import com.juan.petagram3week.pojo.Mascota;
import com.juan.petagram3week.presenter.MFavoritasPresenter;

import java.util.ArrayList;

public class MFavoritasFragment extends Fragment implements IMFavoritasFragmentView {
    private RecyclerView favoritos;
    private MFavoritasPresenter presenter;

    public MFavoritasFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_favoritas_mascotas, container, false);
        favoritos = (RecyclerView) v.findViewById(R.id.rvMascotasfavs);
        presenter = new MFavoritasPresenter(this, getContext());


        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        favoritos.setLayoutManager(llm);
    }

    @Override
    public MascotasFavoritasAdaptador crearAdaptador(ArrayList<Mascota> listaMascotasFavs) {
        MascotasFavoritasAdaptador adaptador  = new MascotasFavoritasAdaptador(listaMascotasFavs,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasFavoritasAdaptador adaptador) {
        favoritos.setAdapter(adaptador);

    }


}