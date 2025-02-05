package com.example.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.minhasanotacoes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private EditText editText;
    private AnotacaoPreferencias anotacaoPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        anotacaoPreferencias = new AnotacaoPreferencias(getApplicationContext());

        editText = findViewById(R.id.editTextTextMultiLine2);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                editTextTexto = findViewById(R.id.editTextTextMultiLine2);
                String texto = "";

                if (editText.getText().toString().equals("") || editText.getText().toString().equals(null)) {
                    texto = "";
                } else {
                    texto = editText.getText().toString();
                }

                if (texto.equals("")) {
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                } else {
                    anotacaoPreferencias.salvarAnotação(texto);
                    Snackbar.make(view, "Anotação salva com sucesso", Snackbar.LENGTH_LONG).show();
                }
            }
        });
//        RECUPERA ANOTAÇÃO

        String nota = anotacaoPreferencias.recuperaAnotacao();
        if (!nota.equals("")) {
            editText.setText(nota);
        }
    }

}