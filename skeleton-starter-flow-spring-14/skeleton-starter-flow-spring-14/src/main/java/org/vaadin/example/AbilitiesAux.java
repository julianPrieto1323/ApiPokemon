package org.vaadin.example;

import com.google.gson.Gson;

public class AbilitiesAux {
    private PokemonAbilities ability;

    public AbilitiesAux() {
    }

    public AbilitiesAux(PokemonAbilities ability) {
        this.ability = ability;
    }

    public PokemonAbilities getAbility() {
        return ability;
    }

    public void setAbility(PokemonAbilities ability) {
        this.ability = ability;
    }
    public String montarJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
