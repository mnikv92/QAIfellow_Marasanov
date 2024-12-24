package ru.iFellow.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.qameta.allure.Step;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.model.Character;
import ru.iFellow.api.episode.Episode;
import ru.iFellow.api.rickandmorty.RickAndMortyApi;
import ru.iFellow.constants.EnvConstants;

import java.util.*;

public class RickAndMortySteps {

    private List<Map<String, List<String>>> listOfMortys;
    private int lastEpisodeId;
    private Episode lastEpisode;
    private int lastCharacterId;
    private Character lastCharacter;

    @Step("Получение списка персонажей с именем '{name}'")
    @Дано("^список персонажей с именем '(.*)'$")

    public List<Map<String, List<String>>> getListCharByName(String name) {

        String endpoint = "/character/?name=" + name;

        listOfMortys = RickAndMortyApi.getRequest(EnvConstants.RICKANDMORTY_URL, endpoint)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath()
                .getList("results");

        return listOfMortys;
    }


    @Step("Получение номера последнего эпизода из списка")
    @Затем("^получаем ID последнего эпизода из списка$")
    public void getLastEpisodeIdFromChars() {
        Set<Integer> episodeIds = new TreeSet<>();
        for (Map<String, List<String>> charData : listOfMortys) {
            List<String> episodes = charData.get("episode");
            for (String episodeUrl : episodes) {
                episodeIds.add(extractNumber(episodeUrl));
            }
        }
        lastEpisodeId = Collections.max(episodeIds);
        lastEpisode = RickAndMortyApi.getRequest(EnvConstants.RICKANDMORTY_URL, "/episode/" + lastEpisodeId)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Episode.class);
    }


    @Step("Получение последнего персонажа из эпизода")
    @И("^получаем ID последнего персонажа из эпизода$")
    public void getLastCharFromEpisode() {
        List<String> characterUrls = lastEpisode.characters;
        List<Integer> characterIds = new ArrayList<>();
        for (String url : characterUrls) {
            characterIds.add(extractNumber(url));
        }
        lastCharacterId = characterIds.get(characterIds.size() - 1);
    }


    @Step("Получение данных по ID")
    @Затем("^получаем данные по ID персонажа$")
    public void getCharacterById() {
        lastCharacter = RickAndMortyApi.getRequest(EnvConstants.RICKANDMORTY_URL, "/character/" + lastCharacterId)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Character.class);
    }


    @Step("Сравнение персонажей по расе и местоположению")
    @И("^сравниваем персонажей по расе и местоположению$")
    public void compareCharacters() {
        for (Map<String, List<String>> charData : listOfMortys) {
            Assertions.assertEquals(lastCharacter.getSpecies(), charData.get("species"));
            Assertions.assertNotEquals(lastCharacter.getLocation(), charData.get("location"));
        }
    }

    public static int extractNumber(String text) {
        return Integer.parseInt(text.substring(text.lastIndexOf("/") + 1));
    }
}