package com.example.pokemon_appraiser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @Autowired
    PokemonService service;

    @GetMapping
    public List<Pokemon> getPokemons(@RequestParam(value = "pokemon") String name) {
        return service.findPokemonByNameLike(name);
    }
}
