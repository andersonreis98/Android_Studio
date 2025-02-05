package com.example.bonequinhos.v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bonequinhos.R;
import com.example.bonequinhos.v2.Precos.PrecoEmpresarialFragment;
import com.example.bonequinhos.v2.Precos.PrecoFreeFragment;
import com.example.bonequinhos.v2.Precos.PrecoIndividualFragment;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private Button buttonEntrar;
    private EditText editTextLogin;
    private EditText editTextSenha;
    private int fragAtual;
    private List<Fragment> fragments;
    private ImageButton imageButtonSenha;
    private ImageView imageViewBerfore;
    private ImageView imageViewNext;
    private PrecoEmpresarialFragment precoEmpresarialFragment;
    private PrecoFreeFragment precoFreeFragment;
    private PrecoIndividualFragment precoIndividualFragment;
    private ProgressBar progressBar;
    private boolean senhaIsVisivel;
    private TextView textViewRecuperaSenha;
    private FirebaseAuth usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        componentes
        buttonEntrar = findViewById(R.id.buttonEntrar);
        textViewRecuperaSenha = findViewById(R.id.textViewRecuperaSenha);
        editTextLogin = findViewById(R.id.editTextLoginEmail);
        editTextSenha = findViewById(R.id.editTextLoginSenha);
        imageButtonSenha = findViewById(R.id.imageButtonVerSenha);
        progressBar = findViewById(R.id.progressBarSignIn);
        imageViewBerfore = findViewById(R.id.imageViewOfertaBerfore);
        imageViewNext = findViewById(R.id.imageViewOfertaNext);

//        fragments
        precoFreeFragment = new PrecoFreeFragment();
        precoIndividualFragment = new PrecoIndividualFragment();
        precoEmpresarialFragment = new PrecoEmpresarialFragment();

//        popula array fragments
        fragments.add(precoFreeFragment);
        fragments.add(precoIndividualFragment);
        fragments.add(precoEmpresarialFragment);

//        configura fragment
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.framePrecos, fragments.get(fragAtual));
        beginTransaction.commit();

//        ações dos botoes
        imageButtonSenha.setOnClickListener(v -> {
        });
        textViewRecuperaSenha.setOnClickListener(v -> {
        });
        buttonEntrar.setOnClickListener(v -> {
        });
        imageViewNext.setOnClickListener(v -> {
        });
        imageViewBerfore.setOnClickListener(v -> {
        });

//        automatiza ofertas
        new Thread(new MyRunnable()).start();
    }

    public LoginActivity() {
        this.usuario = FirebaseAuth.getInstance();
        this.fragments = new ArrayList<Fragment>();
        this.fragAtual = 0;
        this.senhaIsVisivel = false;
    }

    public void signIn() {
        buttonEntrar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        if (!Patterns.EMAIL_ADDRESS.matcher(editTextLogin.getText().toString()).matches()) {
            editTextLogin.setError((CharSequence) "E-mail invalido");
            progressBar.setVisibility(View.INVISIBLE);
            buttonEntrar.setVisibility(View.VISIBLE);
        }
        if (editTextLogin.getText().toString().trim().isEmpty()) {
            editTextLogin.setError((CharSequence) "Preencher campo e-mail");
            progressBar.setVisibility(View.INVISIBLE);
            buttonEntrar.setVisibility(View.VISIBLE);
        }
        if (editTextSenha.getText().toString().isEmpty()) {
            editTextSenha.setError((CharSequence) "Preencher campo senha");
            progressBar.setVisibility(View.INVISIBLE);
            buttonEntrar.setVisibility(View.VISIBLE);
        } else {
            usuario.signInWithEmailAndPassword(editTextLogin.getText().toString(), editTextSenha.getText().toString())
                    .addOnCompleteListener(v -> {
                    })
                    .addOnFailureListener(v -> {
                    });
        }
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                runOnUiThread((Runnable) new Runnable() {
                    @Override
                    public void run() {
                        if (fragAtual != fragments.size() - 1) {
                            fragAtual++;
                        } else {
                            fragAtual = 0;
                        }
                        try {
                            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                            beginTransaction.replace(R.id.framePrecos, fragments.get(fragAtual));
                            beginTransaction.commit();
                        } catch (Exception ex) {
                        }
                    }
                });
            }
        }
    }
}
