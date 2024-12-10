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
}
