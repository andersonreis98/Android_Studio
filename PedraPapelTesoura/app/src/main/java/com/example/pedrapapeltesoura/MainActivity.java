package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static int pedra = 0;
    private static int papel = 1;
    private static int tesoura = 2;
    ImageView imageSistema, imagePedra, imagePapel, imageTesoura;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSistema = findViewById(R.id.imageSistema);
        imagePedra = findViewById(R.id.imagePedra);
        imagePapel = findViewById(R.id.imagePapel);
        imageTesoura = findViewById(R.id.imageTesoura);
        textResultado = findViewById(R.id.textResultado);

        imagePedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada(pedra);
            }
        });
        imagePapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada(papel);
            }
        });
        imageTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada(tesoura);
            }
        });

    }

    void jogada(int jogada) {
        Random random = new Random();
        int jogadaSistema = random.nextInt(3);
        if (jogadaSistema == pedra) {
            imageSistema.setImageResource(R.drawable.pedra);
        }
        if (jogadaSistema == papel) {
            imageSistema.setImageResource(R.drawable.papel);
        }
        if (jogadaSistema == tesoura) {
            imageSistema.setImageResource(R.drawable.tesoura);
        }


        

        if (jogada == jogadaSistema) {
            textResultado.setText("Empate, Favor Jogar novamente!");
        }
        if (jogada == pedra) {
            if (jogadaSistema == tesoura) {
                textResultado.setText("Parabéns, você venceu!");
            }
            if (jogadaSistema == papel) {
                textResultado.setText("Que pena, você perdeu!");
            }

        }if (jogada == papel) {
            if (jogadaSistema == pedra) {
                textResultado.setText("Parabéns, você venceu!");
            }
            if (jogadaSistema == tesoura) {
                textResultado.setText("Que pena, você perdeu!");
            }
        }if (jogada == tesoura) {
            if (jogadaSistema == papel) {
                textResultado.setText("Parabéns, você venceu!");
            }
            if (jogadaSistema == pedra) {
                textResultado.setText("Que pena, você perdeu!");
            }
        }

    }

}