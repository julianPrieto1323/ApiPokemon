package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

public class AbilitiesAux {
    private PokemonAbilities abiliy;

    public AbilitiesAux() {
    }

    public AbilitiesAux(PokemonAbilities abiliy) {
        this.abiliy = abiliy;
    }

    public PokemonAbilities getAbiliy() {
        return abiliy;
    }

    public void setAbiliy(PokemonAbilities abiliy) {
        this.abiliy = abiliy;
    }
    public String montarJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
