package ru.iFellow.api.rickandmorty;

import ru.iFellow.api.Specifications;
import ru.iFellow.constants.EnvConstants;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

public abstract class BaseRickAndMortyApi {
    public BaseRickAndMortyApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.RICKANDMORTY_URL);
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
