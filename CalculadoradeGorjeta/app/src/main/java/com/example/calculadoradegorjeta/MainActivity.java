package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextValor,editTextGorjeta,editTextTotal;
    SeekBar seekBarPorcentagem;
    TextView textViewPorcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor = findViewById(R.id.editValor);
        editTextGorjeta = findViewById(R.id.editGorjeta);
        editTextTotal = findViewById(R.id.editTotal);
        seekBarPorcentagem = findViewById(R.id.seekBarPorcentagem);
        textViewPorcentagem = findViewById(R.id.textViewPorcentagem);

        seekBarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                textViewPorcentagem.setText(i+"%");
                if(!(editTextValor.getText().toString().equals("") ||editTextValor.getText().toString().equals(null))) {
                    double valor = Double.parseDouble(editTextValor.getText().toString());
                    double porcentagem = Double.parseDouble(String.valueOf(seekBar.getProgress()));
                    double gorjeta = valor * (porcentagem / 100);

//                    Arredonda valor
                    editTextGorjeta.setText("R$ " + (Math.round(gorjeta)));

                    double total = gorjeta + valor;

//                    Limita a duas casas decimais
                    DecimalFormat df = new DecimalFormat("#.##");
                    editTextTotal.setText("R$ " + df.format(total));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Por favor insira um valor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}