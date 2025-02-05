package com.example.passandodadosactivitys;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome, email;

    public String getNome() {
        return nome;
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
