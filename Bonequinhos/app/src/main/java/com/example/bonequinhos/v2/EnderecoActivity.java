package com.example.bonequinhos.v2;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bonequinhos.Helpers.MaskEditUtil;
import com.example.bonequinhos.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EnderecoActivity extends AppCompatActivity {

    String stringUrl;

    private EditText editTextCEP, editTextRua, editTextNumero, editTextComplemento, editTextBairro, editTextCidade, editTextUF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);

        editTextCEP = findViewById(R.id.editTextEnderecoCEP);
        editTextRua = findViewById(R.id.editTextEnderecoRua);
        editTextNumero = findViewById(R.id.editTextEnderecoNumero);
        editTextComplemento = findViewById(R.id.editTextEnderecoComplemento);
        editTextBairro = findViewById(R.id.editTextEnderecoBairro);
        editTextCidade = findViewById(R.id.editTextEnderecoCidade);
        Button buttonEndereco = findViewById(R.id.buttonEndereco);

        buttonEndereco.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), EncerramentoActivity.class)));

        editTextCEP.addTextChangedListener(MaskEditUtil.mask(editTextCEP, "#####-###"));

        editTextCEP.setOnKeyListener((v, keyCode, event) -> {

            if (event.getAction() == KeyEvent.ACTION_DOWN) {

                if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (isOnline(getApplicationContext())) {

                        String texto = editTextCEP.getText().toString();
                        texto = texto.replaceAll("[^0-9]", "");
                        String cep = texto;
                        stringUrl = "https://viacep.com.br/ws/" + cep + "/json/";
                        new Thread(new MyRunnable()).start();
                    }

                    return true;
                }

            }
            return false;
        });

    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {

            runOnUiThread((Runnable) () -> {
                String stringUrlApi = stringUrl;
                InputStream inputStream;
                URL url;
                StringBuilder buffer = null;
                InputStreamReader inputStreamReader;
                try {
//                Convert texto em url
                    url = new URL(stringUrlApi);
//                cria conexão com API
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
//                Recebe dados encviados pela api
                    inputStream = conexao.getInputStream();
//                converte dados recebidos em byte para inputStreamReader
                    inputStreamReader = new InputStreamReader(inputStream);
//                convert o inputStream Reder em um array de Stringd
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    buffer = new StringBuilder();
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        buffer.append(linha);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert buffer != null;
                String s = buffer.toString();

                String logradouro;
                String bairro;
                String localidade;
                String uf;

                try {
                    JSONObject jsonObject = new JSONObject(s);
                    logradouro = jsonObject.getString("logradouro");
                    bairro = jsonObject.getString("bairro");
                    localidade = jsonObject.getString("localidade");
                    uf = jsonObject.getString("uf");

                    editTextRua.setText(logradouro);
                    editTextComplemento.setText("");
                    editTextBairro.setText(bairro);
                    editTextCidade.setText(localidade);
                    editTextUF.setText(uf);
                    editTextNumero.setText("");
                    editTextNumero.requestFocus();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected())
            return true;
        else
            return false;
    }

}