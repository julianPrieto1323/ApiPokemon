package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

import java.util.ArrayList;

public class PokemonMove {
    private NameApiResource<Moves> move;

    public PokemonMove() {
    }

    public PokemonMove(NameApiResource<Moves> move) {
        this.move = move;
    }

    public NameApiResource<Moves> getMove() {
        return move;
    }

    public void setMove(NameApiResource<Moves> move) {
        this.move = move;
    }
    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
