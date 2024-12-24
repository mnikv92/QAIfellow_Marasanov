package ru.iFellow.RickAndMortyTests;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.api.Specifications;
import ru.iFellow.model.Character;
import ru.iFellow.api.episode.Episode;
import ru.iFellow.constants.EnvConstants;
import ru.iFellow.steps.RickAndMortySteps;


import java.util.*;


public class RickAndMortyTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.RICKANDMORTY_URL);
        RestAssured.responseSpecification = Specifications.rickAndMortyBaseResponseSpecSuccess();
    }

    private static final RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();
    String charName = "Morty Smith";


    @Test
    @DisplayName("Запрос персонажей по имени 'Morty Smith'")
    public void getListCharName() {
        List<Map<String, List<String>>> listOfMortys = rickAndMortySteps.getListCharByName(charName).getList("results");
        int lastEpisodesId = rickAndMortySteps.getLastEpisodeIdFromChars(listOfMortys);
        Episode episode = rickAndMortySteps.getDataById("episode", lastEpisodesId, Episode.class, HttpStatus.SC_OK);
        int lastCharactersId = rickAndMortySteps.getLastCharFromEpisode(episode);
        Character lastCharacter = rickAndMortySteps.getDataById("character", lastCharactersId, Character.class, HttpStatus.SC_OK);
        rickAndMortySteps.compareCharacters(listOfMortys, lastCharacter);
    }
}
