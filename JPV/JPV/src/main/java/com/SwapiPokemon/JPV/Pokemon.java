package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private List<AuxMove> moves;
    private List<AbilitiesAux> abilities;
    private PokemonSpecies species;

    public Pokemon() {
    }

    public Pokemon(int id, String name, List<AuxMove> moves, List<AbilitiesAux> abilities, PokemonSpecies species) {
        this.id = id;
        this.name = name;
        this.moves = moves;
        this.abilities = abilities;
        this.species = species;
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

    public List<AbilitiesAux> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitiesAux> abilities) {
        this.abilities = abilities;
    }

    public PokemonSpecies getSpecies() {
        return species;
    }

    public void setSpecies(PokemonSpecies species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", moves=" + moves +
                ", abilities=" + abilities +
                ", species=" + species +
                '}';
    }

    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
