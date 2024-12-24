package ru.iFellow.api.reqres;

import io.restassured.response.ValidatableResponse;
import ru.iFellow.api.user.User;
import ru.iFellow.steps.ReqresSteps;

public class ReqresService {

    private final ReqresSteps reqresSteps = new ReqresSteps();

    public User prepareModifiedUser(String filePath, String newName, String newJob) {
        User user = reqresSteps.readUserFromFile(filePath);
        return reqresSteps.modifyUser(user, newName, newJob);
    }

    public ValidatableResponse createUser(User user) {
        return reqresSteps.createNewUser(user);
    }
}