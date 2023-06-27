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
    static String url = "http://localhost:8081/";
    public ArrayList<Animal> getTweets() throws URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(url + "Zoo")).GET().build();
        Gson gson = new Gson();
        String resultado = null;
        HttpResponse<String> respuesta = null;
        ArrayList<Animal> listaTweets = new ArrayList<Animal>();
        try {

            respuesta = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            resultado = respuesta.body();
            listaTweets = gson.fromJson(resultado, new TypeToken<ArrayList<Animal>>(){}.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return listaTweets;
    }
    public static ArrayList<Animal> anhadirForm(Animal animal) throws IOException {
        ArrayList<Animal> listaTweetsActualizada = new ArrayList<Animal>();
        Gson g = new Gson();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url + "Zoo");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        String jsonpasado = animal.montarJSON();
        StringEntity stringEntity = new StringEntity(jsonpasado);
        request.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(request);
        String respuestaActual = new BasicResponseHandler().handleResponse(response);

        listaTweetsActualizada = g.fromJson(respuestaActual, new com.google.gson.reflect.TypeToken<ArrayList<Animal>>() {
        }.getType());

        return listaTweetsActualizada;
    }
    public static ArrayList<Animal> eliminarTweet(int id) throws URISyntaxException, IOException {
        ArrayList<Animal> listaTweets = new ArrayList<Animal>();

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(url + "Zoo?id=" + id))
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
                listaTweets = gson.fromJson(responseBody, new TypeToken<ArrayList<Animal>>() {}.getType());

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

    public ArrayList<Animal> editarTweet(Animal animal) throws IOException {
        ArrayList<Animal> listaTweetsActualizada = new ArrayList<Animal>();
        Gson g = new Gson();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut(url + "Zoo");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        String jsonpasado = animal.montarJSON();
        StringEntity stringEntity = new StringEntity(jsonpasado);
        request.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(request);
        String respuestaActual = new BasicResponseHandler().handleResponse(response);

        listaTweetsActualizada = g.fromJson(respuestaActual, new com.google.gson.reflect.TypeToken<ArrayList<Animal>>() {
        }.getType());

        return listaTweetsActualizada;
    }
}
