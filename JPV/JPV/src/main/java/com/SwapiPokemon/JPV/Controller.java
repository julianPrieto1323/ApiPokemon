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
    String rutaberries = "berries.json";
    ArrayList<Berry> listaBerries= new ArrayList<Berry>();
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
        if (json.leerFicheroBerries(rutaberries) != null){
            listaBerries = json.leerFicheroBerries(rutaberries);
        }
        if (request.getTipo().equals("pokemon")){
            listaRequest.add(request);
            json.escribirPeticion(listaRequest);
            Pokemon pokemon = dataHanding.mostrarPokemon(request);
            listaPokemon.add(pokemon);
            json.escribirUsers(listaPokemon);
        }else if(request.getTipo().equals("ability")){
            listaRequest.add(request);
            json.escribirPeticion(listaRequest);
            Habilidad habilidad = dataHanding.mostrarHabilidad(request);
            listaAbilities.add(habilidad);
            json.escribirAbilities(listaAbilities);
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
