package com.example.recyclerview.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.Adapters.Adapter;
import com.example.recyclerview.Models.Filme;
import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

//        Listagem de filmes
        criarFilmes();

//        Configura adapter
        Adapter adapter = new Adapter(listaFilmes);

//        Configura recyclerview

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);//Melhora desempenho do adapter
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

//        Evento de click
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Click Curto filme "+filme.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Click Longo filme "+filme.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));

    }

    public void criarFilmes() {
        Filme filme;
        filme = new Filme("Harry potter 1", "ficção", "2000");
        listaFilmes.add(filme);
        filme = new Filme("Harry potter 2", "ficção", "2002");
        listaFilmes.add(filme);
        filme = new Filme("Harry potter 3", "ficção", "2004");
        listaFilmes.add(filme);
        filme = new Filme("Harry potter 4", "ficção", "2006");
        listaFilmes.add(filme);
        filme = new Filme("Harry potter 5", "ficção", "2008");
        listaFilmes.add(filme);
        filme = new Filme("Harry potter 6", "ficção", "2010");
        listaFilmes.add(filme);
        filme = new Filme("Harry potter 7", "ficção", "2012");
        listaFilmes.add(filme);
        filme = new Filme("Crepusculo 1", "ficção", "2005");
        listaFilmes.add(filme);
        filme = new Filme("Crepusculo 2", "ficção", "2005");
        listaFilmes.add(filme);
        filme = new Filme("Crepusculo 3", "ficção", "2007");
        listaFilmes.add(filme);
        filme = new Filme("Crepusculo 4", "ficção", "2009");
        listaFilmes.add(filme);
        filme = new Filme("Crepusculo 5", "ficção", "2011");
        listaFilmes.add(filme);

    }
}