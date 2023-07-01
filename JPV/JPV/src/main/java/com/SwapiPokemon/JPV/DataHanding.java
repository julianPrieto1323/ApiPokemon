package com.SwapiPokemon.JPV;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataHanding {
    String urlApi = "https://pokeapi.co/api/v2/%s/%s";
    String url = "http://localhost:8080";
    JSON json = new JSON();
    String rutaPokemon = "pokemons.json";
    String rutaRequest = "requests.json";

    public Pokemon mostrarPokemon(Request params){
        Pokemon pokemon = null;

        String peopleUrl = String.format(urlApi, params.getTipo(), params.getId());

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(peopleUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();

            Gson gson = new Gson();
            pokemon = gson.fromJson(jsonData, Pokemon.class);

        } catch (URISyntaxException e) {
            System.out.println("Error al crear la request: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return pokemon;
    }
    public ArrayList<Request> eliminarRequest(Request request){
        ArrayList<Request> lisaRequest = json.leerFicheroRequests(rutaRequest);

        for (int i = 0; i < lisaRequest.size(); i++){
            if (lisaRequest.get(i).getId() == request.getId()){
                lisaRequest.remove(i);
                json.escribirPeticion(lisaRequest);
            }
        }
        return lisaRequest;
    }
    public Habilidad mostrarHabilidad(Request params){
        Habilidad habilidad = null;

        String peopleUrl = String.format(urlApi, params.getTipo(), params.getId());

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(peopleUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();

            Gson gson = new Gson();
            habilidad = gson.fromJson(jsonData, Habilidad.class);

        } catch (URISyntaxException e) {
            System.out.println("Error al crear la request: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return habilidad;
    }
    public Berry mostrarBerry(Request params){
        Berry berry = null;

        String peopleUrl = String.format(urlApi, params.getTipo(), params.getId());

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(peopleUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();
            Gson gson = new Gson();
            berry = gson.fromJson(jsonData, Berry.class);

        } catch (URISyntaxException e) {
            System.out.println("Error al crear la request: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return berry;
    }
    public Moves mostrarMoves(Request params){
        Moves moves = null;

        String peopleUrl = String.format(urlApi, params.getTipo(), params.getId());

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(peopleUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();
            Gson gson = new Gson();
            moves = gson.fromJson(jsonData, Moves.class);

        } catch (URISyntaxException e) {
            System.out.println("Error al crear la request: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return moves;
    }
    public Generations mostrarGeneration(Request params){
        Generations generations = null;

        String peopleUrl = String.format(urlApi, params.getTipo(), params.getId());

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(peopleUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();
            Gson gson = new Gson();
            generations = gson.fromJson(jsonData, Generations.class);

        } catch (URISyntaxException e) {
            System.out.println("Error al crear la request: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return generations;
    }
}
