package EdujiraiFellow;

import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.ProjectTestPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksNumberTest extends WebHooks {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();

    private final String login = Config.get("login");
    private final String password = Config.get("password");
    private final String taskType = "Задача";
    private final String taskTitle = "Задача для проверки, потом удалить";
    private final String taskDescription = "Описание задачи";


//    @Test
    public void tasksNumberCounter() {
        loginPage.loginIntoEdujira(login, password);
        dashboardPage.checkLogin();
        dashboardPage.getIntoTest();
        projectTestPage.checkInTest();
        projectTestPage.switchToAllTasks();
        Selenide.refresh();
        Integer oldTaskNumber = projectTestPage.parseTasksNumber();
        projectTestPage.createNewTask(taskType, taskTitle, taskDescription);
        Selenide.refresh();
        Integer newTaskNumber = projectTestPage.parseTasksNumber();
        assertEquals(oldTaskNumber + 1, newTaskNumber);
    }


}
