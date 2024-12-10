package ru.iFellow.api.rickandmorty;

import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;

public class RickAndMortyApi extends BaseRickAndMortyApi {
    private static final String CHARACTER_URN = "/character";
    private static final String EPISODE_URN = "/episode";


    public static ValidatableResponse getCharByName(String name) {
        return given()
                .when()
                .get(CHARACTER_URN + "/?name=" + name)
                .then();
    }

    public static ValidatableResponse getEpisodeById(int episodeId) {
        return given()
                .when()
                .get(EPISODE_URN + "/" + episodeId)
                .then();
    }

    public static ValidatableResponse getCharById(int CharacterId) {
        return given()
                .when()
                .get(CHARACTER_URN + "/" + CharacterId)
                .then();
    }
}
