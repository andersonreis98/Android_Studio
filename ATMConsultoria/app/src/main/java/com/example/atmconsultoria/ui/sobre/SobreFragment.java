package com.example.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String descricao = "Em mais de 15 anos de existencia a ATM acumula experiencia em serviços de consultoria para empresas nacionais e multinacionaisde diversos portes, tendo atendido mais de 1000 empresas des de sua abertura";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");
        View aboutPage = new AboutPage(getActivity())
                .isRTL(false)
                .setDescription(descricao)
                .setImage(R.drawable.logo)

                .addGroup("Entre em Contato")
                .addEmail("teste@teste.com", "Envie o e-mail")
                .addWebsite("https://www.google.com.br", "Acesse nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("andersonreis98","Facebook")
                .addInstagram("andersonreis98","Instagram")
                .addYoutube("andersonreis98","Youtube")
                .addGitHub("andersonreis98","Linkedin")
                .addPlayStore("com.facebook.katana", "Doenloas App")
                .addItem(versao)
                .create();

//        return inflater.inflate(R.layout.fragment_sobre, container, false);
        return aboutPage;
    }
}