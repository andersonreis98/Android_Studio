package com.example.bonequinhos.v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bonequinhos.Helpers.ValidarEmail;
import com.example.bonequinhos.R;

public class AcessoActivity extends AppCompatActivity {

    private ImageButton imageButtonSenha, imageButtonSenhaRepetir;
    private EditText editTextEmail, editTextEmailRepetir, editTextSenha, editTextSenhaRepetir;
    private Button buttonAcesso;

    boolean senhaIsVisivel = false;
    boolean senhaRepetirIsVisivel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_acesso);

        imageButtonSenha = findViewById(R.id.imageButtonV2Senha);
        imageButtonSenhaRepetir = findViewById(R.id.imageButtonV2SenhaRepete);

        editTextEmail = findViewById(R.id.editTextV2Email);
        editTextEmailRepetir = findViewById(R.id.editTextV2EmailRepete);
        editTextSenha = findViewById(R.id.editTextV2Senha);
        editTextSenhaRepetir = findViewById(R.id.editTextV2SenhaRepete);

        buttonAcesso = findViewById(R.id.buttonAcesso);


        imageButtonSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (senhaIsVisivel) {
                    senhaIsVisivel = false;
                    imageButtonSenha.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    editTextSenha.setTransformationMethod(new PasswordTransformationMethod());

                } else {
                    senhaIsVisivel = true;
                    imageButtonSenha.setImageResource(R.drawable.ic_baseline_visibility_24);
                    editTextSenha.setTransformationMethod(null);
                }
            }
        });
        imageButtonSenhaRepetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (senhaRepetirIsVisivel) {
                    senhaRepetirIsVisivel = false;
                    imageButtonSenhaRepetir.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    editTextSenhaRepetir.setTransformationMethod(new PasswordTransformationMethod());
                } else {
                    senhaRepetirIsVisivel = true;
                    imageButtonSenhaRepetir.setImageResource(R.drawable.ic_baseline_visibility_24);
                    editTextSenhaRepetir.setTransformationMethod(null);
                }
            }
        });

        buttonAcesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextSenha.getText().toString().isEmpty() && !editTextSenhaRepetir.getText().toString().isEmpty()) {
                    if (editTextSenha.getText().toString().equals(editTextSenhaRepetir.getText().toString())) {
                        if (!editTextEmail.getText().toString().isEmpty() &&
                                !editTextEmailRepetir.getText().toString().isEmpty()) {
                            if (editTextEmail.getText().toString().equals(editTextEmailRepetir.getText().toString())) {
                                if (ValidarEmail.isValidEmailAddressRegex(editTextEmail.getText().toString())) {

                                    startActivity(new Intent(getApplicationContext(), PertinentesActivity.class));

                                } else {
                                    Toast.makeText(getApplicationContext(), "Por favor inserir endereço de e-mail valido", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Por favor confirmar se ambos os campos e-mail estão iguais", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Por favor preencher ambos os campos e-mail", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Por favor confirmar se ambas as senhas estão iguais ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Por favor preencha ambos os campos senha", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}