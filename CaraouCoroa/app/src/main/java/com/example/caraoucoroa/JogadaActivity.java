package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class JogadaActivity extends AppCompatActivity {
    public final int cara = 0;
    public final int coroa = 1;

    ImageView imageView,imageViewJogada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogada);

        imageView = findViewById(R.id.imageViewVoltar);
        imageViewJogada = findViewById(R.id.imageViewJogada);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle dados = getIntent().getExtras();
        int jogada = dados.getInt("jogada");
        if(jogada==cara){
            imageViewJogada.setImageResource(R.drawable.moeda_cara);
        }else {
            imageViewJogada.setImageResource(R.drawable.moeda_coroa);
        }


    }
}