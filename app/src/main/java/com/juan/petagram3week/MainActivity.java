package com.juan.petagram3week;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.juan.petagram3week.adapter.PageAdapter;
import com.juan.petagram3week.fragment.RecyclerViewFragment;
import com.juan.petagram3week.fragment.fragmentPerfil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        agregarFab();
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBAr);
        setSupportActionBar(miActionBar);
        final ActionBar ab =getSupportActionBar();
        // .setDefaultDisplayHomeAsUpEnabled(true)
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        //ab.setTitle(R.string.titulo_toolbar);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        seTupViewPager();





    }


    //pone en orbita los fragments
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        //frangment que quiero en la primer tab
        fragments.add(new RecyclerViewFragment());

        //fragment que quiero en la segunda tab
        fragments.add(new fragmentPerfil());

        return fragments;

    }
    private void seTupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home); //icono en la tab 0
        tabLayout.getTabAt(1).setIcon(R.drawable.perfil); //icono en la tab 0

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_favs:
                Intent intent = new Intent(this, Mascotas_Favoritas.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                Intent intent2 = new Intent(this, ActivityAbout.class);
                startActivity(intent2);
                break;
            case R.id.mContacto:
                Intent intent3 = new Intent(this, ActivityContacto.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void agregarFab(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.miFab);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), ":)", Toast.LENGTH_LONG).show();

            }
        });
    }




}