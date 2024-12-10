package ru.iFellow.steps;

import io.restassured.response.ValidatableResponse;
import ru.iFellow.api.reqres.ReqresApi;
import ru.iFellow.api.user.User;
import ru.iFellow.utils.MapperUtils;

public class ReqresSteps {

    private static final ReqresApi reqresApi = new ReqresApi();

    public User readUserFromFile(String filePath) {
        return MapperUtils.readFromFile(filePath, User.class);
    }

    public User modifyUser(User user, String newName, String newJob) {
        user.setName(newName);
        user.setJob(newJob);
        return user;
    }

    public ValidatableResponse createNewUser(User user) {
        return reqresApi.createUser(user);
    }
}

