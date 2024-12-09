package ru.iFellow.api.rickandmorty;

import io.restassured.response.Response;
import ru.iFellow.api.character.Character;
import io.restassured.response.ValidatableResponse;
import ru.iFellow.constants.CharacterStatus;


import static io.restassured.RestAssured.given;

public class RickAndMortyApi extends BaseRickAndMortyApi {
    private static final String CHARACTER_URN = "/character";

    public ValidatableResponse getCharId(int id) {
        return given()
                .when()
                .get(CHARACTER_URN + "/" + id)
                .then();
    }


//    public static Response getFindByName(String charName) {
//        return given()
//                .queryParam("name", charName)
//                .when()
//                .get(CHARACTER_URN)
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
//    }

//    public static ValidatableResponse getFindByName(String name, CharacterStatus status) {
//        return given()
//                .when()
//                .get(CHARACTER_URN + "/?name=" + name + "&status=" + status)
//                .then();
//    }
    public static ValidatableResponse getFindByName(String name) {
        return given()
                .when()
                .get(CHARACTER_URN + "/?name=" + name)
                .then();
    }


}
