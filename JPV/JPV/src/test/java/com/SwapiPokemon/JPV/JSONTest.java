package com.SwapiPokemon.JPV;

import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JSONTest {

    @org.junit.Test
    public void escribirUsers() {

        PokemonMove move = new PokemonMove("Impactrueno", "impactrueno.com");
        AuxMove auxMove = new AuxMove(move);
        ArrayList<AuxMove> listaMove = new ArrayList<AuxMove>();
        listaMove.add(auxMove);

        PokemonAbilities abilities = new PokemonAbilities("Escudo", "escudo.com");
        AbilitiesAux abilitiesAux = new AbilitiesAux(abilities);
        ArrayList<AbilitiesAux> listaAbilities = new ArrayList<AbilitiesAux>();
        listaAbilities.add(abilitiesAux);

        PokemonSpecies pokemonSpecies = new PokemonSpecies("Electrico", "electrico.com");

        Pokemon pokemon = new Pokemon(0, "Pickachu", listaMove, listaAbilities, pokemonSpecies);

        ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();

        listaPokemon.add(pokemon);

        JSON json = new JSON();

        if (json.buscarObjeto(pokemon, listaPokemon)){
            assertTrue(true);
        }else{
            fail("EL POKEMON NO SE HA AÑADIDO");
        }
    }
}