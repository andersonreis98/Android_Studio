package com.example.compbas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button,buttonLimpar;
    private EditText edNome,edEmail;
    private TextView textView;
    private CheckBox checkBoxBranco,checkBoxVerde, checkBoxVermelho;
    private RadioButton radioButtonMasculino,radioButtonFeminino;
    private RadioGroup radioGroupSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        edNome = findViewById(R.id.editNome);
        edEmail = findViewById(R.id.editEmail);
        textView = findViewById(R.id.textView);

        //        CheckBox
        checkBoxBranco = findViewById(R.id.checkBoxBranco);
        checkBoxVerde = findViewById(R.id.checkBoxVerde);
        checkBoxVermelho = findViewById(R.id.checkBoxVermelho);

        //       RadioButton
        radioButtonFeminino = findViewById(R.id.radioButtonFeminino);
        radioButtonMasculino = findViewById(R.id.radioButtonMasculino);
        radioGroupSexo = findViewById(R.id.radioGroupSex);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edNome.getText().toString();
                String email = edEmail.getText().toString();
                textView.setText("nome: "+nome+" e-mail: "+email);
                checkbox();
                radioButton();
            }
        });
        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edNome.setText("");
                edEmail.setText("");
                textView.setText("Resultado");
                checkBoxBranco.setChecked(false);
                checkBoxVerde.setChecked(false);
                checkBoxVermelho.setChecked(false);
            }
        });

    }
    void checkbox(){
        if(checkBoxBranco.isChecked()){
            textView.setText(textView.getText().toString()+" Checkbox Branco selecionado ");
        }
        if(checkBoxVermelho.isChecked()){
            textView.setText(textView.getText().toString()+" Checkbox Vermelho selecionado ");
        }
        if(checkBoxVerde.isChecked()){
            textView.setText(textView.getText().toString()+" Checkbox Verde selecionado" );
        }
    }
    void radioButton(){
        if (radioButtonMasculino.isChecked()){
            textView.setText(textView.getText().toString()+" Radio sexo masculino selecionado ");
        }
        if (radioButtonFeminino.isChecked()){
            textView.setText(textView.getText().toString()+" Radio sexo feminino selecionado ");
        }

//        radioGroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if(i == R.id.radioButtonFeminino){
//                    textView.setText(textView.getText().toString()+" Radio sexo feminino selecionado ");
//                }if(i == R.id.radioButtonMasculino){
//                    textView.setText(textView.getText().toString()+" Radio sexo masculino selecionado ");
//                }
//            }
//        });

    }
}