package com.example.pokemon_appraiser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class PokemonCrawler {
    private final WebDriver driver = new EdgeDriver();

    public Pokemon[] crawl(String string) {

        driver.get("https://pvpoke.com/rankings/all/" + string + "/overall/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        for (int i = 1; i <= 9; i++) {
            driver.findElement(By.cssSelector(".rank:nth-child(" + i + ") > .expand-label")).click();
            driver.findElement(By.cssSelector(".selected > .expand-label")).click();
            System.out.println("clicking...");
        }

        WebElement element = driver.findElement(By.className("rankings-container"));
        List<WebElement> elements = element.findElements(By.cssSelector("div[type-1][type-2][data]"));
        Pokemon[] pokemons = new Pokemon[9];

        for (int i = 0; i < 9; i++) {

            Document doc = Jsoup.parse(elements.get(i).getAttribute("innerHTML"));
            pokemons[i] = new Pokemon(
                    doc.select(".name").first().text(),
                    elements.get(i).getAttribute("type-1"),
                    elements.get(i).getAttribute("type-2"),
                    doc.select(".number").first().text(),
                    elements.get(i).findElement(By.className("moves")).getText(),
                    doc.select(".rating").first().text()
            );

            if (string.equals("1500")) {
                pokemons[i].setLeague("Great League");

            } else if (string.equals("2500")) {
                pokemons[i].setLeague("Ultra League");

            } else {
                pokemons[i].setLeague("Master League");
            }

            String[] array = RegexMatches.find(doc.select(".stat-row.rank-1 > .value").text());

            pokemons[i].setIv(array[0]);
            pokemons[i].setCp(array[1]);
        }

        driver.quit();

        return pokemons;
    }
}
