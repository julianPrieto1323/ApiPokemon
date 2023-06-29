package com.SwapiPokemon.JPV;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller{
    DataHanding dataHanding = new DataHanding();
    JSON json = new JSON();
    String rutaPokemon = "pokemons.json";
    String rutaRequest = "requests.json";
    String rutaAbilities = "Habilidad.json";
    ArrayList<Request> listaRequest= new ArrayList<Request>();
    ArrayList<Habilidad> listaAbilities= new ArrayList<Habilidad>();
    ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();
    @PostMapping("/pokemon")
    public void getPokemon(@RequestBody Request request){
        if (json.LeerFicheroJson(rutaPokemon) != null){
            listaPokemon = json.LeerFicheroJson(rutaPokemon);
        }
        if (json.leerFicheroRequests(rutaRequest) != null){
            listaRequest = json.leerFicheroRequests(rutaRequest);
        }
        if (json.leerFicheroAbilities(rutaAbilities) != null){
            listaAbilities = json.leerFicheroAbilities(rutaAbilities);
        }
        if (request.getTipo().equals("pokemon")){
            listaRequest.add(request);
            json.escribirPeticion(listaRequest);
            Pokemon pokemon = dataHanding.mostrarPokemon(request);
            listaPokemon.add(pokemon);
            json.escribirUsers(listaPokemon);
        }
        }

    }
    @GetMapping("/request")
    public ArrayList<Request> getrequest(){
        ArrayList<Request> listaRequest = json.leerFicheroRequests(rutaRequest);
        return listaRequest;
    }
    @DeleteMapping("/request")
    public ArrayList<Request> eliminarRequest(@RequestParam int id){
        Request request1 = new Request(null, id);
        return dataHanding.eliminarRequest(request1);
    }

}
