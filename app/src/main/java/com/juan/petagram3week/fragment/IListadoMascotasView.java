package com.juan.petagram3week.fragment;

import com.juan.petagram3week.adapter.MascotaAdaptador;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;

public interface IListadoMascotasView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
