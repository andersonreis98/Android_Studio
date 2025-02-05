package com.example.bonequinhos.v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bonequinhos.R;

public class TermosActivity extends AppCompatActivity {

    TextView textViewLerTermos;
    Button buttonTermos;
    CheckBox checkBoxTermosLidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos);
        textViewLerTermos = findViewById(R.id.textViewLerTermos);
        buttonTermos = findViewById(R.id.buttonTermos);
        checkBoxTermosLidos = findViewById(R.id.checkBoxLerTermos);


        buttonTermos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxTermosLidos.isChecked()){
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Para ingressar no aplicativo é necessario aceitar os termos", Toast.LENGTH_LONG).show();
                }

            }
        });

        textViewLerTermos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LerTermosActivity.class));
            }
        });
    }
}