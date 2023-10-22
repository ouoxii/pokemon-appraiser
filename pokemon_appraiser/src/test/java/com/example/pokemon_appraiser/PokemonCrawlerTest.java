package com.example.pokemon_appraiser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PokemonCrawlerTest {
    @Autowired
    private PokemonService service;

    @Test
    void crawlTest() {

        service.deleteAllPokemons();

        for (String string : new String[] {"1500", "2500", "10000"}) {

            PokemonCrawler crawler = new PokemonCrawler();

            for (Pokemon pokemon : crawler.crawl(string)) {
                service.createPokemon(pokemon);
                System.out.println("create " + pokemon);
            }
        }
    }
}
