package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAnterior, buttonProximo;
    PrimeiroFragment primeiroFragment;
    SegundoFragment segundoFragment;
    TerceiroFragment terceiroFragment;
    List<Fragment> fragments = new ArrayList<>();
    int fragAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAnterior = findViewById(R.id.button);
        buttonProximo = findViewById(R.id.button2);

        primeiroFragment = new PrimeiroFragment();
        segundoFragment = new SegundoFragment();
        terceiroFragment = new TerceiroFragment();

        fragments.add(primeiroFragment);
        fragments.add(segundoFragment);
        fragments.add(terceiroFragment);

        //        configura objeto para fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo, fragments.get(fragAtual));
        transaction.commit();


        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragAtual != fragments.size() - 1) {
                    fragAtual++;
                } else {
                    fragAtual = 0;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, fragments.get(fragAtual));
                transaction.commit();

            }
        });
        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragAtual != 0) {
                    fragAtual--;
                } else {
                    fragAtual = fragments.size() - 1;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, fragments.get(fragAtual));
                transaction.commit();
            }
        });

        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();

    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {

            while (true) {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (fragAtual != fragments.size() - 1) {
                            fragAtual++;
                        } else {
                            fragAtual = 0;
                        }

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameConteudo, fragments.get(fragAtual));
                        transaction.commit();
                    }
                });

            }
        }

    }
}

