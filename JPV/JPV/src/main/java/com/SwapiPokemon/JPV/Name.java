package com.SwapiPokemon.JPV;

public class Name {

    private String name;
    private NameApiResource<Language> language;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public NameApiResource<Language> getLanguage() {
        return language;
    }
    public void setLanguage(NameApiResource<Language> language) {
        this.language = language;
    }

}
