package com.example.abas.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.abas.Fragments.EmAltaFragment;
import com.example.abas.Fragments.HomeFragment;
import com.example.abas.Fragments.InscricoesFragment;
import com.example.abas.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {
    SmartTabLayout smartTabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        smartTabLayout = findViewById(R.id.viewpagertab);
        viewPager = findViewById(R.id.viewpager);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                .add("Home", HomeFragment.class)
                .add("Inscrições", InscricoesFragment.class)
                .add("Em Alta", EmAltaFragment.class)
                .create()
        );
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

    }
}