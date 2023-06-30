package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private List<AuxMove> moves;

    public Pokemon() {
    }

    public Pokemon(int id, String name, ArrayList<AuxMove> moves) {
        this.id = id;
        this.name = name;
        this.moves = moves;
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

    public List<AuxMove> getMoves() {
        return moves;
    }

    public void setMoves(List<AuxMove> moves) {
        this.moves = moves;
    }

    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
