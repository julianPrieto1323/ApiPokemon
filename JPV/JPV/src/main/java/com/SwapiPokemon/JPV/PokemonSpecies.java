package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

public class PokemonSpecies {
    private String name;
    private String url;

    public PokemonSpecies() {
    }

    public PokemonSpecies(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String montarJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
