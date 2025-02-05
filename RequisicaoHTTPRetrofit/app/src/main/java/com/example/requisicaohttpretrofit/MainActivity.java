package com.example.requisicaohttpretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.requisicaohttpretrofit.Api.CEPService;
import com.example.requisicaohttpretrofit.Api.DataService;
import com.example.requisicaohttpretrofit.Model.CEP;
import com.example.requisicaohttpretrofit.Model.Foto;
import com.example.requisicaohttpretrofit.Model.Postagem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private Retrofit retrofit;
    private List<Foto> listFotos = new ArrayList<>();
    private List<Postagem> listPostagens = new ArrayList<>();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textResultado);
        button = findViewById(R.id.buttonResultado);

        String cep = "05664015";
//        String stringUrl = "https://viacep.com.br/ws/";
        String stringUrl = "https://jsonplaceholder.typicode.com/";
        retrofit = new Retrofit.Builder()
                .baseUrl(stringUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                recuperacepRetrofit();
    //            recuperaListaRetrofit();
//                salvaPostagem();
//                atualizarPostagem();
                removerPostagem();
            }
        });


    }


    public void recuperaListaRetrofit() {
        DataService service = retrofit.create(DataService.class);
//        Call<List<Foto>> call = service.recuperaFotos();
        Call<List<Postagem>> call = service.recuperaPostagens();
        call.enqueue(new Callback<List<Postagem>>() {
            @Override
            public void onResponse(Call<List<Postagem>> call, Response<List<Postagem>> response) {
                if (response.isSuccessful()) {
                    listPostagens = response.body();
                    for (int i = 0; i < listPostagens.size(); i++) {
                        Postagem postagem = listPostagens.get(i);
                        Log.d("fotoRecuperada", postagem.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Postagem>> call, Throwable t) {

            }
        });


    }

    public void recuperacepRetrofit() {

        CEPService cepService = retrofit.create(CEPService.class);
        Call<CEP> call = cepService.recuperarCEP("05664015");
        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if (response.isSuccessful()) {
                    CEP cep = response.body();
                    textView.setText(cep.getLogradouro() + " / " + cep.getCep());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });
    }

    public void salvaPostagem() {

//        Postagem postagem = new Postagem("1234","Titulo da Postagem","Corpo da Postagem");
//        Postagem postagem = new Postagem("1234","Titulo da Postagem","Corpo da Postagem");

        DataService service = retrofit.create(DataService.class);
//        Call<Postagem> call = service.salvarPostagem(postagem);
        Call<Postagem> call = service.salvarPostagem("1234", "Titulo da Postagem", "Corpo da Postagem");

        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if (response.isSuccessful()) {
                    Postagem postagemResposta = response.body();
                    textView.setText(
                            " codigo: " + response.code() +
                                    " id: " + postagemResposta.getId() +
                                    " titulo: " + postagemResposta.getTitle()
                    );
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });
    }

    public void atualizarPostagem() {
        DataService service = retrofit.create(DataService.class);

//        Postagem postagem = new Postagem("1234", "Titulo da Postagem", "Corpo da Postagem");
        Postagem postagem = new Postagem();
        postagem.setBody("teste");
        Call<Postagem> call = service.atualizaPostagemPath(2, postagem);
        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if (response.isSuccessful()) {
                    Postagem postagemResposta = response.body();
                    textView.setText(
                            " codigo: " + response.code() +
                                    " id: " + postagemResposta.getId() +
                                    " Userid: " + postagemResposta.getUserId() +
                                    " titulo: " + postagemResposta.getTitle() +
                                    " body : " + postagemResposta.getBody()
                    );
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });
    }
    public void removerPostagem(){
        DataService service = retrofit.create(DataService.class);
        Call<Void> call = service.deletaPostagem(2);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    textView.setText("Status"+response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}