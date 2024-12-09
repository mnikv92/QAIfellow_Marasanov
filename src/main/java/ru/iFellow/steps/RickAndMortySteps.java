package ru.iFellow.steps;

import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import ru.iFellow.api.rickandmorty.RickAndMortyApi;
import ru.iFellow.api.character.Character;
import ru.iFellow.constants.CharacterStatus;

import java.util.List;


public class RickAndMortySteps {

    RickAndMortyApi rickAndMortyApi = new RickAndMortyApi();

    public Character getCharByName(String name, CharacterStatus status) {
        Character character = RickAndMortyApi.getFindByName(name)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Character.class);
        return character;
    }


    public JsonPath getListCharByName(String name) {
        JsonPath jsonPath = RickAndMortyApi.getFindByName(name)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
        return jsonPath;
    }


}
