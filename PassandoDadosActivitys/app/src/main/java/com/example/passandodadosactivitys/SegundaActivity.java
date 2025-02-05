package com.example.passandodadosactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SegundaActivity extends AppCompatActivity {
    TextView textViewNome,textViewIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        textViewIdade = findViewById(R.id.textIdade);
        textViewNome = findViewById(R.id.textNome);

        Bundle dados = getIntent().getExtras();

        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        textViewNome.setText(usuario.getNome());
        textViewIdade.setText(usuario.getEmail());

    }
}