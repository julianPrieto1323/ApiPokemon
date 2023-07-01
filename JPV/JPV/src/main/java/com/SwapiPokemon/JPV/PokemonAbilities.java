package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

public class PokemonAbilities {
    private String name;
    private String url;

    public PokemonAbilities() {
    }

    public PokemonAbilities(String name, String url) {
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

    @Override
    public String toString() {
        return "PokemonAbilities{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public String JSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
