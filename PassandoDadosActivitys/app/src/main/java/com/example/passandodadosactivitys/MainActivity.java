package com.example.passandodadosactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btEnviaDados);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SegundaActivity.class);

                Usuario usuario = new Usuario("Anderson","andersonreis98@gmail.com");


                i.putExtra("nome","anderson");
                i.putExtra("idade", 23);
                i.putExtra("objeto", usuario);

                startActivity(i);
            }
        });
    }
}