package com.juan.petagram3week;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.juan.petagram3week.R;
import com.juan.petagram3week.adapter.MascotaAdaptador;
import com.juan.petagram3week.adapter.PageAdapter;
import com.juan.petagram3week.fragment.MFavoritasFragment;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;

public class Mascotas_Favoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    public MascotaAdaptador adaptador;
    private RecyclerView listaMascotasFavs;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas__favoritas);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarF);
        setSupportActionBar(miActionBar);
        final ActionBar ab =getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewPagerFavs);
        setUpViewPager();




    }

      private ArrayList<Fragment> agregarFragments() {

          ArrayList<Fragment> fragments = new ArrayList<>();

          fragments.add(new MFavoritasFragment());


          return fragments;
      }

    private void setUpViewPager() {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

    }
}
