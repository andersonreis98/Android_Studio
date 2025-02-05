package com.example.firebaseapp;

public class Produto {
    private String descricao;
    private String marca;
    private double preco;

    public Produto(String descricao, String marca, double preco) {
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
