package com.example.agendaminha.model;

public class Agendamento {
    private Horario horario;
    private String id_usuario;
    private String id_sala;


    public Agendamento() {
    }

    public Agendamento(Horario horario, String id_usuario, String id_sala) {
        this.horario = horario;
        this.id_usuario = id_usuario;
        this.id_sala = id_sala;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_sala() {
        return id_sala;
    }

    public void setId_sala(String id_sala) {
        this.id_sala = id_sala;
    }
}
