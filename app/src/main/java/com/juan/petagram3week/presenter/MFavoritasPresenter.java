package com.juan.petagram3week.presenter;

import android.content.Context;

import com.juan.petagram3week.db.ConstructorMascotas;
import com.juan.petagram3week.fragment.IMFavoritasFragmentView;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;

public class MFavoritasPresenter implements IMFavoritasPresenter {
    private IMFavoritasFragmentView iFavoritas;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> listaMascotasFavs;

    public MFavoritasPresenter(IMFavoritasFragmentView iFavoritas, Context context) {
        this.iFavoritas = iFavoritas;
        this.context = context;
        obtenerMascotasFBaseDatos();
    }

    @Override
    public void obtenerMascotasFBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        listaMascotasFavs = constructorMascotas.obtenerDatosFav();
        mostrarMascotasFRV();
    }

    @Override
    public void mostrarMascotasFRV() {
        iFavoritas.inicializarAdaptadorRV(iFavoritas.crearAdaptador(listaMascotasFavs));
        iFavoritas.generarLinearLayoutVertical();
    }
}
