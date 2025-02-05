package com.example.cardview.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardview.Adapters.Adapter;
import com.example.cardview.Models.Postagem;
import com.example.cardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewPostagem;
    List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewPostagem = findViewById(R.id.recyclerViewPostagem);
//        define layout
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
//        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        recyclerViewPostagem.setLayoutManager(layoutManager);
        recyclerViewPostagem.setHasFixedSize(true);

//        gera Postagens
        geraPostagens();

//        define adapter
        Adapter adapter = new Adapter(postagens);
        recyclerViewPostagem.setAdapter(adapter);
    }

    public void geraPostagens() {
        Postagem p;
        p = new Postagem("Anderson Reis Nascimento", "Viagem dahora", R.drawable.imagem1);
        postagens.add(p);
        p = new Postagem("Andressa Reis Nascimento", "Viagem dahora", R.drawable.imagem2);
        postagens.add(p);
        p = new Postagem("Lielson da Silva Nascimento", "Viagem dahora", R.drawable.imagem3);
        postagens.add(p);
        p = new Postagem("Alexandra Reis Villas Boas", "Viagem dahora", R.drawable.imagem4);
        postagens.add(p);
    }
}