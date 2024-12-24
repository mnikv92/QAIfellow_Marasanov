package ru.iFellow.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
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
    @Дано("^чтение пользователя из файла '(.*)'")
    public User readUserFromFile(String filePath) {
        User user = MapperUtils.readFromFile(filePath, User.class);
        Allure.addAttachment("User JSON", user.toString());
        return user;
    }

    @Step("Изменение имени на '{newName}' и профессии на '{newJob}'")
    @Когда("^изменяем имя пользователя и профессию на '(.*)' и '(.*)'$")
    public User modifyUser(User user, String newName, String newJob) {
        user.setName(newName);
        user.setJob(newJob);
        return user;
    }

    @Step("Создание нового пользователя")
    @Тогда("^создаем нового пользователя")
    public ValidatableResponse createNewUser(User user) {
        return reqresApi.createUser(user, EnvConstants.USER_URN, HttpStatus.SC_CREATED);
    }

    @Attachment(value = "{name}", type = "application/json")
    public static String attachJson(String name, String JsonContent) {
        return JsonContent;
    }
}