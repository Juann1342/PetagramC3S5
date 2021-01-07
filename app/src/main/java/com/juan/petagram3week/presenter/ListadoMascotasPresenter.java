package com.juan.petagram3week.presenter;

import android.content.Context;

import com.juan.petagram3week.db.ConstructorMascotas;
import com.juan.petagram3week.fragment.IListadoMascotasView;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;

public class ListadoMascotasPresenter implements IListadoMascotasPresenter {
    private IListadoMascotasView iListadoMascotasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public ListadoMascotasPresenter(IListadoMascotasView iListadoMascotasView, Context context) {
    this.iListadoMascotasView = iListadoMascotasView;
    this.context = context;
    obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
    constructorMascotas = new ConstructorMascotas(context);
    mascotas = constructorMascotas.obtenerDatos();
    mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
    iListadoMascotasView.inicializarAdaptadorRV(iListadoMascotasView.crearAdaptador(mascotas));
    iListadoMascotasView.generarLinearLayoutVertical();
    }
}
