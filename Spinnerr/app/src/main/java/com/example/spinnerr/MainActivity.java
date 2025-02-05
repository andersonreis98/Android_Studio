package com.example.spinnerr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerEstados;
    String[] estados = new String[]{
            "SP", "MT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerEstados = findViewById(R.id.spinnerEstados);
        carregarDadosSpinner();
    }
    void carregarDadosSpinner(){

        //Configura spinner de estados
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,
                estados
        );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinnerEstados.setAdapter( adapter );

    }
}