package EdujiraiFellow.steps;

import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.ProjectTestPage;
import EdujiraiFellow.pages.TaskPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.ru.Затем;


public class NewBugSteps {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();
    private final TaskPage taskPage = new TaskPage();

    @Когда("^авторизуемся, вводя логин '(.*)' и пароль '(.*)' и нажимая кнопку входа")
    public void login(String login, String password) {
        loginPage.loginIntoEdujira(login, password);
    }

    @Тогда("^видим на верхней панели опции пользователя и список проектов")
    public void checkLogin() {
        dashboardPage.checkLogin();
    }

    @Затем("^переходим в проект TEST, выбрав его из списка")
    public void getIntoTest() {
        dashboardPage.getIntoTest();
    }

    @И("^видим боковую панель со списком заведенных задач")
    public void checkInTest() {
        projectTestPage.checkInTest();
    }

    @Тогда("^создаем новый баг. Тип задачи: '(.*)', Заголовок: '(.*)', Описание: '(.*)', Метки: '(.*)', Окружение: '(.*)'")
    public void addNewBug(String taskType, String taskTitle, String taskDescription, String marks, String env) {
        projectTestPage.createNewBug(taskType, taskTitle, taskDescription, marks, env);
        taskPage.closeMessage();
    }

    @Затем("^переключаем фильтр на 'Сообщенные мной'")
    public void switchToMyTasks() {
        projectTestPage.switchToReportedByMe();
    }

    @И("^оказываемся на странице последней открытой нами задачи. Ставим статус задачи 'В работе'")
    public void setInWork() {
        taskPage.setInProgress();
//        taskPage.closeMessage();
    }
    @И("^отмечаем задачу как выполненную")
    public void setFinished() {
        taskPage.setDone();
//        taskPage.closeMessage();
    }
    @Затем("^убеждаемся, что статус задачи 'ГОТОВО'")
}
