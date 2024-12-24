package ru.iFellow.api.reqres;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.ValidatableResponse;
import ru.iFellow.api.user.User;

import static io.restassured.RestAssured.given;

public class ReqresApi extends BaseReqresApi {

    @Step("Создание пользователя через API. Endpoint: {endpoint}, Ожидаемый статус: {statusCode}")
    public ValidatableResponse createUser(User user, String endpoint, int statusCode) {
        return given()
                .filter(new AllureRestAssured())
                .body(user)
                .when()
                .post(endpoint)
                .then()
                .statusCode(statusCode);
    }
}
