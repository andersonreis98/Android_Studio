package com.example.fragments.Activits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.Fragments.ContatosFragment;
import com.example.fragments.Fragments.ConversasFragment;
import com.example.fragments.R;

public class MainActivity extends AppCompatActivity {

    Button buttonContatos,buttonConversas;

    ConversasFragment conversasFragment;
    ContatosFragment contatosFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tira elevação da action bar
        getSupportActionBar().setElevation(0);

        conversasFragment= new ConversasFragment();
        contatosFragment = new ContatosFragment();

        buttonContatos = findViewById(R.id.buttonContatos);
        buttonConversas = findViewById(R.id.buttonConversas);

//        configura objeto para fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo,conversasFragment);
        transaction.commit();

        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,conversasFragment);
                transaction.commit();
            }
        });
        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,contatosFragment);
                transaction.commit();
            }
        });




    }
}