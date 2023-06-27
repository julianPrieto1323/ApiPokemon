package org.vaadin.example;

import com.google.gson.Gson;
import com.googlecode.gentyref.TypeToken;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Service
public class GreetService implements Serializable {
    static String url = "http://localhost:8080/";
    public ArrayList<Request> getRequest() throws URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(url + "request")).GET().build();
        Gson gson = new Gson();
        String resultado = null;
        HttpResponse<String> respuesta = null;
        ArrayList<Request> listaTweets = new ArrayList<Request>();
        try {

            respuesta = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            resultado = respuesta.body();
            listaTweets = gson.fromJson(resultado, new TypeToken<ArrayList<Request>>(){}.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return listaTweets;
    }
    public ArrayList<Pokemon> getPokemons(Request request) throws URISyntaxException {
        Gson gson = new Gson();
        String jsonBody = gson.toJson(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(url + "pokemon"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        String resultado = null;
        ArrayList<Pokemon> listaTweets = new ArrayList<Pokemon>();

        try {
            HttpResponse<String> respuesta = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            resultado = respuesta.body();
            listaTweets = gson.fromJson(resultado, new TypeToken<ArrayList<Pokemon>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return listaTweets;
    }
    public static ArrayList<Pokemon> eliminarPokemon(int id) throws URISyntaxException, IOException {
        ArrayList<Pokemon> listaTweets = new ArrayList<Pokemon>();

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(url + "request?id=" + id))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Procesa la respuesta del backend
            int statusCode = httpResponse.statusCode();
            String responseBody = httpResponse.body();

            // Verifica el código de respuesta
            if (statusCode == 200) {
                // Utiliza Gson para convertir la respuesta JSON en una lista de tweets
                Gson gson = new Gson();
                listaTweets = gson.fromJson(responseBody, new TypeToken<ArrayList<Pokemon>>() {}.getType());

                // Aquí puedes realizar las operaciones necesarias con la lista de tweets
                System.out.println("El tweet se eliminó correctamente.");
                System.out.println("Lista de tweets actualizada: " + listaTweets);
            } else {
                System.out.println("Error al eliminar el tweet. Código de respuesta: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTweets;
    }

}
