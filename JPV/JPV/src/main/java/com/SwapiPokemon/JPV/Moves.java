package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

public class Moves {
    private String name;
    private int id;
    private int accuracy;

    public Moves() {
    }

    public Moves(String name, int id, int accuracy) {
        this.name = name;
        this.id = id;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "Moves{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", accuracy=" + accuracy +
                '}';
    }
    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
