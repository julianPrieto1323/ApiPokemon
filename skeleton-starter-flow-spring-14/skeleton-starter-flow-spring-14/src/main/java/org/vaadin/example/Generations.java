package org.vaadin.example;

import com.google.gson.Gson;

import java.util.List;

public class Generations {
    private int id;
    private String name;
    private List<PokemonMove> moves;
    private List<PokemonSpecies> pokemon_species;

    public Generations() {
    }

    public Generations(int id, String name, List<PokemonMove> moves, List<PokemonSpecies> pokemon_species) {
        this.id = id;
        this.name = name;
        this.moves = moves;
        this.pokemon_species = pokemon_species;
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

    public List<PokemonMove> getMoves() {
        return moves;
    }

    public void setMoves(List<PokemonMove> moves) {
        this.moves = moves;
    }

    public List<PokemonSpecies> getPokemon_species() {
        return pokemon_species;
    }

    public void setPokemon_species(List<PokemonSpecies> pokemon_species) {
        this.pokemon_species = pokemon_species;
    }
    public String montarJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
