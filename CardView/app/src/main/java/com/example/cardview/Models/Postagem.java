package com.example.cardview.Models;

public class Postagem {
    String nomeUsuario,postagem;
    int imagem;

    public Postagem() {
    }

    public Postagem(String nomeUsuario, String postagem, int imagem) {
        this.nomeUsuario = nomeUsuario;
        this.postagem = postagem;
        this.imagem = imagem;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
