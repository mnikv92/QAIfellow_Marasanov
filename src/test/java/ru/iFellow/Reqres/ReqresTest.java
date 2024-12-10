package ru.iFellow.Reqres;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.api.Specifications;
import ru.iFellow.api.user.User;
import ru.iFellow.constants.EnvConstants;
import ru.iFellow.steps.ReqresSteps;

import static org.hamcrest.Matchers.equalTo;

public class ReqresTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.REQRES_URL);
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }

    private static final ReqresSteps reqresSteps = new ReqresSteps();
    private static final String filePath = "src/test/resources/user.json";
    private static final String newName = "Tomato";
    public static final String newJob = "Eat maket";

    @Test
    @DisplayName("Создание пользователя")
    public void checkUserId() {
        User newUser = reqresSteps.readUserFromFile(filePath);
        User modifiedUser = reqresSteps.modifyUser(newUser, newName, newJob);

        ValidatableResponse response = reqresSteps.createNewUser(modifiedUser);
        response.statusCode(HttpStatus.SC_CREATED);

        response.body("name", equalTo(newName));
        response.body("job", equalTo(newJob));
    }
}