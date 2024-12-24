package ru.iFellow.api.reqres;

import io.restassured.response.ValidatableResponse;
import ru.iFellow.api.user.User;

import static io.restassured.RestAssured.given;

public class ReqresApi extends BaseReqresApi {


    public ValidatableResponse createUser(User user, String endpoint, int statusCode) {
        return given()
                .body(user)
                .when()
                .post(endpoint)
                .then()
                .statusCode(statusCode);
    }
}
