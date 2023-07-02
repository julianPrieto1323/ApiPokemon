package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Habilidad {
    private int id;
    private String name;
    private ArrayList<AuxPokemon> pokemon;

    public Habilidad() {
    }

    public Habilidad(int id, String name, ArrayList<AuxPokemon> pokemon) {
        this.id = id;
        this.name = name;
        this.pokemon = pokemon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<AuxPokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList<AuxPokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pokemon=" + pokemon +
                '}';
    }

    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
