package com.example.requisicaohttpretrofit.Api;


import com.example.requisicaohttpretrofit.Model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);

}
