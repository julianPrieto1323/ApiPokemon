package com.SwapiPokemon.JPV;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller{
    DataHanding dataHanding = new DataHanding();
    JSON json = new JSON();
    String rutaPokemon = "pokemon.json";
    String rutaRequest = "request.json";
    ArrayList<Request> listaRequest= new ArrayList<Request>();
    ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();
    @GetMapping("/pokemon")
    public Pokemon getPokemon(@RequestBody Request request){
        if (json.LeerFicheroJson(rutaPokemon) != null){
            listaPokemon = json.LeerFicheroJson(rutaPokemon);
        }
        if (json.leerFicheroRequests(rutaRequest) != null){
            listaRequest = json.leerFicheroRequests(rutaRequest);
        }
        listaRequest.add(request);
        json.escribirPeticion(listaRequest);
        Pokemon pokemon = dataHanding.mostrarPokemon(request);
        listaPokemon.add(pokemon);
        json.escribirUsers(listaPokemon);
        return pokemon;
    }
}
