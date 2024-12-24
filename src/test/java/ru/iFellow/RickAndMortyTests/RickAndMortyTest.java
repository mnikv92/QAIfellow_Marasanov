package ru.iFellow.RickAndMortyTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.steps.RickAndMortySteps;


public class RickAndMortyTest {

    private static final RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();
    String charName = "Morty Smith";

    @Test
    @DisplayName("Тест 'Rick and Morty' JUnit")
    public void getListCharName() {
        rickAndMortySteps.getListCharByName(charName);
        rickAndMortySteps.getLastEpisodeIdFromChars();
        rickAndMortySteps.getLastCharFromEpisode();
        rickAndMortySteps.getCharacterById();
        rickAndMortySteps.compareCharacters();
    }
}
