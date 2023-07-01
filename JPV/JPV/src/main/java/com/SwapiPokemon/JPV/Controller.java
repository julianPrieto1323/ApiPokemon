package com.SwapiPokemon.JPV;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class Controller{
    DataHanding dataHanding = new DataHanding();
    JSON json = new JSON();
    String rutaPokemon = "pokemons.json";
    String rutaRequest = "requests.json";
    String rutaAbilities = "Habilidad.json";
    String rutaberries = "berries.json";
    String rutaMoves = "moves.json";
    String rutaGenerations = "generations.json";
    String rutaTipoRequest = "tipoRequest.json";
    ArrayList<Generations> listaGenerations = new ArrayList<Generations>();
    ArrayList<Moves> listaMoves = new ArrayList<Moves>();
    ArrayList<Berry> listaBerries= new ArrayList<Berry>();
    ArrayList<Request> listaRequest= new ArrayList<Request>();
    ArrayList<Habilidad> listaAbilities= new ArrayList<Habilidad>();
    ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();
    @PostMapping("/pokemon")
    public Object getPokemon(@RequestBody Request request){
        Object object = new Object();
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
        if (json.leerFciheroMoves(rutaMoves) != null){
            listaMoves = json.leerFciheroMoves(rutaMoves);
        }
        if (json.LeerFicheroGenerations(rutaGenerations) != null){
            listaGenerations = json.LeerFicheroGenerations(rutaGenerations);
        }
        switch (request.getTipo().toLowerCase()){
            case "pokemon":
                listaRequest.add(request);
                json.escribirPeticion(listaRequest);
                Pokemon pokemon = dataHanding.mostrarPokemon(request);
                listaPokemon.add(pokemon);
                json.escribirUsers(listaPokemon);
                object = pokemon;
                break;
            case "ability":
                listaRequest.add(request);
                json.escribirPeticion(listaRequest);
                Habilidad habilidad = dataHanding.mostrarHabilidad(request);
                listaAbilities.add(habilidad);
                json.escribirAbilities(listaAbilities);
                object = habilidad;
                break;
            case "berry":
                listaRequest.add(request);
                json.escribirPeticion(listaRequest);
                Berry berry = dataHanding.mostrarBerry(request);
                listaBerries.add(berry);
                json.escribirBerries(listaBerries);
                object = berry;
                break;
            case "move":
                listaRequest.add(request);
                json.escribirMoves(listaMoves);
                Moves moves = dataHanding.mostrarMoves(request);
                listaMoves.add(moves);
                json.escribirMoves(listaMoves);
                object = moves;
                break;
            case "generation":
                listaRequest.add(request);
                json.escribirMoves(listaMoves);
                Generations generation = dataHanding.mostrarGeneration(request);
                listaGenerations.add(generation);
                json.escribirGenerations(listaGenerations);
                object = generation;
                break;
        }
        return object;
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
    @GetMapping("/requestTodas")
    public ArrayList<Request> getrequestTodas(){
        ArrayList<Request> listaRequest = json.leerFicheroRequests(rutaTipoRequest);
        return listaRequest;
    }
}
