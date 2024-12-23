package ru.iFellow.steps;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import ru.iFellow.api.episode.Episode;
import ru.iFellow.api.rickandmorty.RickAndMortyApi;
import ru.iFellow.api.character.Character;
import ru.iFellow.constants.EnvConstants;


public class RickAndMortySteps {

    public JsonPath getListCharByName(String name) {

        String endpoint = "/character/?name=" + name;

        return RickAndMortyApi.getRequest(EnvConstants.RICKANDMORTY_URL, endpoint)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }

    public static int extractNumber(String text) {
        return Integer.parseInt(text.substring(text.lastIndexOf("/") + 1));
    }

    public Episode getEpisodeById(int episodeId) {

        String endpoint = "/episode/" + episodeId;

        return RickAndMortyApi.getRequest(EnvConstants.RICKANDMORTY_URL, endpoint)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Episode.class);
    }

    public Character getCharById(int charId) {

        String endpoint = "/character/" + charId;

        return RickAndMortyApi.getRequest(EnvConstants.RICKANDMORTY_URL, endpoint)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Character.class);
    }
}