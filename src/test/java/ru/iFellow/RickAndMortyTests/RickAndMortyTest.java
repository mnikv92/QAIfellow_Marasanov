package ru.iFellow.RickAndMortyTests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.api.Specifications;
import ru.iFellow.api.character.Character;
import ru.iFellow.api.character.Location;
import ru.iFellow.api.episode.Episode;
import ru.iFellow.constants.EnvConstants;
import ru.iFellow.steps.RickAndMortySteps;


import java.util.*;

import static ru.iFellow.steps.RickAndMortySteps.extractNumber;

public class RickAndMortyTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.RICKANDMORTY_URL);
        RestAssured.responseSpecification = Specifications.rickAndMortyBaseResponseSpecSuccess();
    }

    private static final RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();
    String charName = "Morty Smith";
    int lastEpisodesId;
    int lastCharactersId;

    @Test
    @DisplayName("Запрос персонажей по имени 'Morty Smith'")
    public void checkListCharName() {
        List<Map<String, Character>> listOfMortys = rickAndMortySteps.getListCharByName(charName).getList("results");
        Set<Integer> episodesIds = new TreeSet<>();

        for (Map<String, Character> mortyData : listOfMortys) {
            List<String> episodeList = (List<String>) mortyData.get("episode");
            for (int j = 0; j < episodeList.size(); j++) {
                episodesIds.add(extractNumber(episodeList.get(j)));
            }
        }

        String lastEpisode = "https://rickandmortyapi.com/api/episode/" + Collections.max(episodesIds);
        lastEpisodesId = Collections.max(episodesIds);
        System.out.println("\nНомер последнего эпизода " + lastEpisode + "\n");

        Episode episode = rickAndMortySteps.getEpisodeById(lastEpisodesId);
        List<String> charactersList = episode.characters;
        List<Integer> charactersIds = new ArrayList<>();
        for (int i = 0; i < charactersList.size(); i++) {
            charactersIds.add(extractNumber(charactersList.get(i)));
        }
        lastCharactersId = charactersIds.get(charactersIds.size() - 1);
        System.out.println("\nID последнего персонажа в последнем эпизоде " + lastCharactersId + "\n");
        Character lastCharacter = rickAndMortySteps.getCharById(lastCharactersId);

        for (Map<String, Character> mortyData : listOfMortys) {
            Map<String, Location> mortysLocation = (Map<String, Location>) mortyData.get("location");
            Assertions.assertEquals(lastCharacter.getSpecies(), mortyData.get("species"));
            Assertions.assertNotEquals(lastCharacter.getLocation().getName(), mortysLocation.get("name"));
        }
    }
}