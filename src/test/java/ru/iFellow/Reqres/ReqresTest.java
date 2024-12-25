package ru.iFellow.Reqres;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.steps.ReqresSteps;

import static org.hamcrest.Matchers.equalTo;

public class ReqresTest {

    private static final ReqresSteps reqresSteps = new ReqresSteps();
    private static final String filePath = "src/test/resources/user.json";
    private static final String newName = "Tomato";
    public static final String newJob = "Eat maket";

    @Test
    @DisplayName("Создание пользователя")
    public void checkUserId() {

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        reqresSteps.readUserFromFile(filePath);
        reqresSteps.modifyUser(newName, newJob);

        ValidatableResponse response = reqresSteps.createNewUser();

        response.body("name", equalTo(newName));
        response.body("job", equalTo(newJob));

        attachResponse("Response Body", response.extract().asPrettyString());
    }

    @Attachment(value = "{name}", type = "application/json")
    public static String attachResponse(String name, String responseBody) {
        return responseBody;
    }
}
