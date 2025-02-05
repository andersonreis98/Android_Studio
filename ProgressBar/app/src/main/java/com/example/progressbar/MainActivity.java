package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBarCircular, progressBarHorizontal;
    Button button;
    int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarCircular = findViewById(com.example.progressbar.R.id.progressBarCircular);
        progressBarHorizontal = findViewById(com.example.progressbar.R.id.progressBarHorizontal);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBarCircular.setVisibility(View.VISIBLE);

//                ProgressBar Horizontal
                progresso = progresso + 1;
                progressBarHorizontal.setProgress(progresso);

//                ProgressBar Circular
                progressBarCircular.setVisibility(View.VISIBLE);

                if(progresso==10){
                    progressBarCircular.setVisibility(View.GONE);
                }

            }
        });
    }
}