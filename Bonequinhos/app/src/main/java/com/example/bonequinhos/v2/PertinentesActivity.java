package com.example.bonequinhos.v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.bonequinhos.R;

public class PertinentesActivity extends AppCompatActivity {

    private FisicaFragment fisicaFragment;
    private JuridicaFragment juridicaFragment;
    private RadioGroup radioGroupFisicaJuridica;
    private Button buttonPertinentes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertinentes);

        buttonPertinentes = findViewById(R.id.buttonPertinentes);

        radioGroupFisicaJuridica = findViewById(R.id.radioV2FisicaJuridica);

        radioGroupFisicaJuridica.check(R.id.radioButtonV2Fisica);

        //        Istancia Fragmentos
        fisicaFragment = new FisicaFragment();
        juridicaFragment = new JuridicaFragment();

//        configura objeto para fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo, fisicaFragment);
        transaction.commit();

        radioGroupFisicaJuridica.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonV2Fisica) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameConteudo, fisicaFragment);
                    transaction.commit();
                }
                if (checkedId == R.id.radioButtonV2Juridica) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameConteudo, juridicaFragment);
                    transaction.commit();
                }
            }
        });
        buttonPertinentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EnderecoActivity.class));
            }
        });

    }
}