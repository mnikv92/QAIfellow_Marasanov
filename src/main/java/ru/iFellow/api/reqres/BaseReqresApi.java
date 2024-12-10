package ru.iFellow.api.reqres;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import ru.iFellow.api.Specifications;
import ru.iFellow.constants.EnvConstants;

public class BaseReqresApi {
    public BaseReqresApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.REQRES_URL);
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}