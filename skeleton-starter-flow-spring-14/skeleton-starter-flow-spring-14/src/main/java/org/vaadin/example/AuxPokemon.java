package org.vaadin.example;

import com.google.gson.Gson;

public class AuxPokemon {
    private Pokemon pokemon;

    public AuxPokemon() {
    }

    public AuxPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
