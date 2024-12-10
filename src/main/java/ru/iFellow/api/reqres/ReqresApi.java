package ru.iFellow.api.reqres;

import io.restassured.response.ValidatableResponse;
import ru.iFellow.api.user.User;

import static io.restassured.RestAssured.given;

public class ReqresApi extends BaseReqresApi {

    private static final String USER_URN = "/users";

    public ValidatableResponse createUser(User user) {
        return given()
                .when().body(user)
                .post(USER_URN)
                .then();
    }

    public ValidatableResponse getUserId(int id) {
        return given()
                .when()
                .get(USER_URN + "/" + id)
                .then();
    }

    public ValidatableResponse updateUser(int id, User user) {
        return given()
                .body(user)
                .when()
                .put(USER_URN + "/" + id)
                .then();
    }
}
