package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

public class Request {
    private String tipo;
    private int id;

    public Request() {
    }

    public Request(String tipo, int id) {
        this.tipo = tipo;
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Request{" +
                "tipo='" + tipo + '\'' +
                ", id=" + id +
                '}';
    }
    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
