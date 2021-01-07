package com.juan.petagram3week.fragment;

import com.juan.petagram3week.adapter.MascotasFavoritasAdaptador;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;

public interface IMFavoritasFragmentView {
    public void generarLinearLayoutVertical();
    public MascotasFavoritasAdaptador crearAdaptador(ArrayList<Mascota> listaMascotasF);
    public void inicializarAdaptadorRV(MascotasFavoritasAdaptador adaptador);
}
