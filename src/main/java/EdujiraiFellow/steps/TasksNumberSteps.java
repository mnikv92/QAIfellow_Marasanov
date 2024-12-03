package EdujiraiFellow.steps;

import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.ProjectTestPage;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.ru.Затем;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksNumberSteps {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();

    @Когда("^вводим логин '(.*)' и пароль '(.*)' и нажимаем кнопку входа")
    public void login(String login, String password) {
        loginPage.loginIntoEdujira(login, password);
    }

    @Тогда("^видим опции пользователя и список проектов")
    public void checkLogin() {
        dashboardPage.checkLogin();
    }

    @Затем("^выбираем в списке проект TEST")
    public void getIntoTest() {
        dashboardPage.getIntoTest();
    }

    @Тогда("^боковая панель со списком задач становится видна")
    public void checkInTest() {
        projectTestPage.checkInTest();
    }

    @Затем("^переключаем фильтр на 'Все задачи'")
    public void switchToAllTasks() {
        projectTestPage.switchToAllTasks();
        Selenide.refresh();
    }

    Integer oldNum;

    @И("^фиксируем количество задач в счетчике")
    public void parseOldTasksNumber() {
        Integer oldTaskNumber = projectTestPage.parseTasksNumber();
        oldNum = oldTaskNumber;
    }

    @Затем("^создаем новую задачу. Тип: '(.*)', тема: '(.*)', описание: '(.*)'")
    public void newTask(String taskType, String taskTitle, String taskDescription) {
        projectTestPage.createNewTask(taskType, taskTitle, taskDescription);
        Selenide.refresh();
    }

    Integer newNum;

    @И("^фиксируем новое количество задач в счетчике")
    public void parseNewTasksNumber() {
        Integer newTaskNumber = projectTestPage.parseTasksNumber();
        newNum = newTaskNumber;
    }

    @Затем("^сравниваем количество задач. Должно стать на 1 больше")
    public void compareNumbers() {
        assertEquals(oldNum + 1, newNum);
    }
}
