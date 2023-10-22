package com.example.pokemon_appraiser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository repository;

    public void deleteAllPokemons() {
        repository.deleteAll();
    }

    public void createPokemon(Pokemon pokemon) {
        repository.insert(new Pokemon(pokemon));
    }

    public List<Pokemon> findPokemonByNameLike(String name) {
        return repository.findByNameLike(name);
    }
}
