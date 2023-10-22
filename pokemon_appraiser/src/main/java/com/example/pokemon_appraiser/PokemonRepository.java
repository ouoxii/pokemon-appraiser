package com.example.pokemon_appraiser;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> {
    List<Pokemon> findByNameLike(String name);
}
