 package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.buttonProgresso);
        textView = findViewById(R.id.textViewProgresso);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Escolhido: "+seekBar.getProgress());
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                a cada mudança de lugar
                textView.setText("Progresso: "+i+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                ao pressionar a barra
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                ao soltar a barra
            }
        });


    }
}