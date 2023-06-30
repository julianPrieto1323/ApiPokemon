package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

public class AuxMove {
    private PokemonMove move;

    public AuxMove() {
    }

    public AuxMove(PokemonMove move) {
        this.move = move;
    }

    public PokemonMove getMove() {
        return move;
    }

    public void setMove(PokemonMove move) {
        this.move = move;
    }
    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
