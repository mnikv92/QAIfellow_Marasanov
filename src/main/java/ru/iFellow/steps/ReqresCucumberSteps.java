//package ru.iFellow.steps;
//
//import io.cucumber.java.ru.Дано;
//import io.cucumber.java.ru.Когда;
//import io.cucumber.java.ru.Тогда;
//import io.restassured.response.ValidatableResponse;
//import ru.iFellow.api.reqres.ReqresService;
//import ru.iFellow.api.user.User;
//
//import static org.hamcrest.Matchers.equalTo;
//
//public class ReqresCucumberSteps {
//
//    private static final ReqresService reqresService = new ReqresService();
//    private User user;
//    private ValidatableResponse response;
//
//    @Дано("^чтение пользователя из файла '(.*)'$")
//    public void readUserFromFile(String filePath) {
//        user = reqresService.prepareModifiedUser(filePath, null, null);
//    }
//
//    @Когда("^имя пользователя '(.*)' заменяем на '(.*)' и профессию заменяем на '(.*)'$")
//    public void modifyUser(String currentName, String newName, String newJob) {
//        user = reqresService.prepareModifiedUser(filePath, newName, newJob);
//    }
//
//    @Тогда("^создаем нового пользователя$")
//    public void createUser() {
//        response = reqresService.createUser(user);
//    }
//
//    @Тогда("^проверяем имя '(.*)' и профессию '(.*)'$")
//    public void verifyUserCreation(String expectedName, String expectedJob) {
//        response.body("name", equalTo(expectedName));
//        response.body("job", equalTo(expectedJob));
//    }
//}