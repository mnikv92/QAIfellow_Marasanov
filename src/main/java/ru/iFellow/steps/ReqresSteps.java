package ru.iFellow.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import ru.iFellow.api.reqres.ReqresApi;
import ru.iFellow.api.user.User;
import ru.iFellow.constants.EnvConstants;
import ru.iFellow.utils.MapperUtils;


public class ReqresSteps {

    private static final ReqresApi reqresApi = new ReqresApi();

    private User currentUser;

    @Step("Чтение пользователя из файла: '{filePath}'")
    @Дано("^чтение пользователя из файла '(.*)'$")
    public void readUserFromFile(String filePath) {
        this.currentUser = MapperUtils.readFromFile(filePath, User.class);
        Allure.addAttachment("User JSON", currentUser.toString());
    }

    @Step("Изменение имени на '{newName}' и профессии на '{newJob}'")
    @Когда("^изменяем имя пользователя на '(.*)' и профессию на '(.*)'$")
    public void modifyUser(String newName, String newJob) {
        currentUser.setName(newName);
        currentUser.setJob(newJob);
    }

    @Step("Создание нового пользователя")
    @Тогда("^создаем нового пользователя$")
    public ValidatableResponse createNewUser() {
        return reqresApi.createUser(currentUser, EnvConstants.USER_URN, HttpStatus.SC_CREATED);
    }
}
