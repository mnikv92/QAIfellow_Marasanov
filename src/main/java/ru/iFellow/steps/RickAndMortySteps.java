package ru.iFellow.steps;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.model.Character;
import ru.iFellow.api.episode.Episode;
import ru.iFellow.api.rickandmorty.RickAndMortyApi;
import ru.iFellow.constants.EnvConstants;

import java.util.*;


public class RickAndMortySteps {

    @Step("Получение списка персонажей с именем '{name}'")
    public JsonPath getListCharByName(String name) {

        String endpoint = "/character/?name=" + name;

        return RickAndMortyApi.getRequest(EnvConstants.RICKANDMORTY_URL, endpoint)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }

    @Step("Получение номера последнего эпизода из списка")
    public int getLastEpisodeIdFromChars(List<Map<String, List<String>>> characters) {

        Set<Integer> episodeIds = new TreeSet<>();

        for (Map<String, List<String>> charData : characters) {
            List<String> episodes = charData.get("episode");
            for (String episodeUrl : episodes) {
                episodeIds.add(extractNumber(episodeUrl));
            }
        }
        return Collections.max(episodeIds);
    }

    @Step("Получение последнего персонажа из эпизода")
    public int getLastCharFromEpisode(Episode episode) {
        List<String> characterUrls = episode.characters;
        List<Integer> characterIds = new ArrayList<>();
        for (String url : characterUrls) {
            characterIds.add(extractNumber(url));
        }
        return characterIds.get(characterIds.size() - 1);
    }

    @Step("Получение данных по ID")
    public <T> T getDataById(String resourcetype, int id, Class<T> responseType, int expectedStatusCode) {
        String endpoint = "/" + resourcetype + "/" + id;
        return RickAndMortyApi.getRequest(EnvConstants.RICKANDMORTY_URL, endpoint)
                .statusCode(expectedStatusCode)
                .extract()
                .body()
                .as(responseType);
    }

    @Step("Получение последнего числа в строке")
    public static int extractNumber(String text) {
        return Integer.parseInt(text.substring(text.lastIndexOf("/") + 1));
    }

    @Step("Сравнение персонажей по расе  и местоположению")
    public void compareCharacters(List<Map<String, List<String>>> characters, Character lastCharacter) {
        for (Map<String, List<String>> charData : characters) {

            Assertions.assertEquals(lastCharacter.getSpecies(), charData.get("species"));
            Assertions.assertNotEquals(lastCharacter.getLocation(), charData.get("location"));

        }
    }
}