package com.example.agendaminha.model;

public class Horario {
    private String hora;
    private String minuto;
    private boolean disponibilidade = true;
    private String idHora;

    public Horario(String hora, String minuto, boolean disponibilidade) {
        this.hora = hora;
        this.minuto = minuto;
        this.disponibilidade = disponibilidade;
    }
    public Horario(String hora, String minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public Horario() {
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getIdHora() {
        return idHora;
    }

    public void setIdHora(String idHora) {
        this.idHora = idHora;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "hora='" + hora + '\'' +
                ", minuto='" + minuto + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", idHora='" + idHora + '\'' +
                '}';
    }
}
