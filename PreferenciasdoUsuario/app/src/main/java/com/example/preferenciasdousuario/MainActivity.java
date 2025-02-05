package com.example.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonSalvar;
    EditText editText;
    TextView textViewNome;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSalvar = findViewById(R.id.button);
        editText = findViewById(R.id.editTextNome);
        textViewNome = findViewById(R.id.textViewUsuario);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);//nome do arquivo, 0=privado,1 =outros APP's podem acessar
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Preencha o capo nome", Toast.LENGTH_SHORT).show();
                } else {
                    String nome = editText.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textViewNome.setText("Olá, " + nome);
                }
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
//        Valida se temos preferencias
        if (sharedPreferences.contains("nome")) {
            String nome = sharedPreferences.getString("nome", "Olá, usuário não definido");
            textViewNome.setText("Olá, " + nome);
        } else {
            textViewNome.setText("Olá, usuário não definido");
        }
    }
}