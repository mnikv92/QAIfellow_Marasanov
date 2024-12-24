package ru.iFellow.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import ru.iFellow.api.reqres.ReqresApi;
import ru.iFellow.api.user.User;
import ru.iFellow.constants.EnvConstants;
import ru.iFellow.utils.MapperUtils;

public class ReqresSteps {

    private static final ReqresApi reqresApi = new ReqresApi();

    @Step("Чтение пользователя из файла")
    public User readUserFromFile(String filePath) {
        return MapperUtils.readFromFile(filePath, User.class);
    }

    @Step("Изменение имени и профессии пользователя")
    public User modifyUser(User user, String newName, String newJob) {
        user.setName(newName);
        user.setJob(newJob);
        return user;
    }

    @Step("Создание нового пользователя")
    public ValidatableResponse createNewUser(User user) {
        return reqresApi.createUser(user, EnvConstants.USER_URN, HttpStatus.SC_CREATED);
    }

}