package ru.iFellow.RickAndMortyTests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.steps.RickAndMortySteps;


public class RickAndMortyTest {

    private static final RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();
    String charName = "Morty Smith";

    @Test
    @DisplayName("Тест 'Rick and Morty' JUnit")
    public void getListCharName() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        rickAndMortySteps.getListCharByName(charName);
        rickAndMortySteps.getLastEpisodeIdFromChars();
        rickAndMortySteps.getLastCharFromEpisode();
        rickAndMortySteps.getCharacterById();
        rickAndMortySteps.compareCharacters();
    }
}
