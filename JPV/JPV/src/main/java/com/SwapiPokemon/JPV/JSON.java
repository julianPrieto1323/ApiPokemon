package com.SwapiPokemon.JPV;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSON {
    public static ArrayList<Pokemon> LeerFicheroJson(String ruta){
        //En esta clase se lee el fichero JSON de menores de 60
        ArrayList <Pokemon> listaJSON = new ArrayList<Pokemon>();
        try {
            //Creamos el objeto Gson
            Gson gson = new Gson();

            // Creamos el reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Usamos la libreria Gson para leer el fichero Json e introducirlo en un arraylist
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<Pokemon>>() {}.getType());
            System.out.println("FICHERO users.json LEIDO CORRECTAMENTE");

            //Cerramos el reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }
    public void escribirUsers(ArrayList<Pokemon> lista){
        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            Writer writer = new FileWriter("pokemons.json");
            try {
                gson.toJson(lista, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Request> leerFicheroRequests(String ruta){
        //En esta clase se lee el fichero JSON de menores de 60
        ArrayList <Request> listaJSON = new ArrayList<Request>();
        try {
            //Creamos el objeto Gson
            Gson gson = new Gson();

            // Creamos el reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Usamos la libreria Gson para leer el fichero Json e introducirlo en un arraylist
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<Request>>() {}.getType());
            System.out.println("FICHERO users.json LEIDO CORRECTAMENTE");

            //Cerramos el reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }

    public void escribirPeticion(ArrayList<Request> lista){
        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            Writer writer = new FileWriter("requests.json");
            try {
                gson.toJson(lista, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void escribirAbilities(ArrayList<Habilidad> lista){
        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            Writer writer = new FileWriter("Habilidad.json");
            try {
                gson.toJson(lista, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void escribirBerries(ArrayList<Berry> lista){
        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            Writer writer = new FileWriter("berries.json");
            try {
                gson.toJson(lista, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void escribirMoves(ArrayList<Moves> lista){
        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            Writer writer = new FileWriter("moves.json");
            try {
                gson.toJson(lista, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Habilidad> leerFicheroAbilities(String ruta){
        //En esta clase se lee el fichero JSON de menores de 60
        ArrayList <Habilidad> listaJSON = new ArrayList<Habilidad>();
        try {
            //Creamos el objeto Gson
            Gson gson = new Gson();

            // Creamos el reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Usamos la libreria Gson para leer el fichero Json e introducirlo en un arraylist
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<Habilidad>>() {}.getType());
            System.out.println("FICHERO users.json LEIDO CORRECTAMENTE");

            //Cerramos el reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }
    public static ArrayList<Berry> leerFicheroBerries(String ruta){
        //En esta clase se lee el fichero JSON de menores de 60
        ArrayList <Berry> listaJSON = new ArrayList<Berry>();
        try {
            //Creamos el objeto Gson
            Gson gson = new Gson();

            // Creamos el reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Usamos la libreria Gson para leer el fichero Json e introducirlo en un arraylist
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<Berry>>() {}.getType());
            System.out.println("FICHERO users.json LEIDO CORRECTAMENTE");

            //Cerramos el reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }
    public static ArrayList<Moves> leerFciheroMoves(String ruta){
        //En esta clase se lee el fichero JSON de menores de 60
        ArrayList <Moves> listaJSON = new ArrayList<Moves>();
        try {
            //Creamos el objeto Gson
            Gson gson = new Gson();

            // Creamos el reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Usamos la libreria Gson para leer el fichero Json e introducirlo en un arraylist
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<Moves>>() {}.getType());
            System.out.println("FICHERO users.json LEIDO CORRECTAMENTE");

            //Cerramos el reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }
}
