package com.SwapiPokemon.JPV;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller{
    DataHanding dataHanding = new DataHanding();
    @GetMapping("/pokemon")
    public Pokemon getPokemon(@RequestBody Request request){
        return dataHanding.mostrarPokemon(request);
    }
}
