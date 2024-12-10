package ru.iFellow.steps;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import ru.iFellow.api.episode.Episode;
import ru.iFellow.api.rickandmorty.RickAndMortyApi;
import ru.iFellow.api.character.Character;


public class RickAndMortySteps {

    public JsonPath getListCharByName(String name) {
        JsonPath jsonPath = RickAndMortyApi.getCharByName(name)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
        return jsonPath;
    }

    public static int extractNumber(String text) {
        return Integer.parseInt(text.substring(text.lastIndexOf("/") + 1));
    }

    public Episode getEpisodeById(int episodeId) {
        Episode episode = RickAndMortyApi.getEpisodeById(episodeId)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Episode.class);
        return episode;
    }

    public Character getCharById(int charId) {
        Character character = RickAndMortyApi.getCharById(charId)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Character.class);
        return character;
    }
}
