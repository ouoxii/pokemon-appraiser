package com.example.pokemon_appraiser;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("pokemons")
public class Pokemon implements Serializable {
    private String league;
    private String name;
    private String type1;
    private String type2;
    private String ranking;
    private String moves;
    private String rating;
    private String iv;
    private String cp;

    public Pokemon() {

    }

    public Pokemon(String name, String type1, String type2, String ranking, String moves, String rating) {
        this.name = name.endsWith("XL") ? name.substring(0, name.length() - 2) : name;
        this.type1 = type1;
        this.type2 = type2;
        this.ranking = ranking;
        this.moves = moves;
        this.rating = rating;
    }

    public Pokemon(Pokemon pokemon) {
        this.league = pokemon.getLeague();
        this.name = pokemon.getName();
        this.type1 = pokemon.getType1();
        this.type2 = pokemon.getType2();
        this.ranking = pokemon.getRanking();
        this.moves = pokemon.getMoves();
        this.rating = pokemon.getRating();
        this.iv = pokemon.getIv();
        this.cp = pokemon.getCp();
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "league='" + league + '\'' +
                ", name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", ranking='" + ranking + '\'' +
                ", moves='" + moves + '\'' +
                ", rating='" + rating + '\'' +
                ", iv='" + iv + '\'' +
                ", cp='" + cp + '\'' +
                '}';
    }
}
