package com.example.requisicaohttpretrofit.Api;

import com.example.requisicaohttpretrofit.Model.Foto;
import com.example.requisicaohttpretrofit.Model.Postagem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DataService {
    @GET("/photos")
    Call<List<Foto>> recuperaFotos();

    @GET("/posts")
    Call<List<Postagem>> recuperaPostagens();

    @POST("/posts")
    Call<Postagem> salvarPostagem(@Body Postagem postagem);

//   para API's que retornam respostas que não estão não no formato json como xml
    @FormUrlEncoded
    @POST("/posts")
    Call<Postagem> salvarPostagem(
            @Field("userId") String userID,
            @Field("title") String title,
            @Field("body") String body
    );
    //    atualiza toda a postagem
    @PUT("/posts/{id}")
    Call<Postagem> atualizaPostagem(@Path("id") int id,@Body Postagem postagem);

//    atualiza somente os dados que não estiverem nulos
    @PATCH("/posts/{id}")
    Call<Postagem> atualizaPostagemPath(@Path("id") int id,@Body Postagem postagem);

    @DELETE
    Call<Void> deletaPostagem(@Path("id") int id);


}
