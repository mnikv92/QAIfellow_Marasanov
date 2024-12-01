package EdujiraiFellow;

import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.ProjectTestPage;
import EdujiraiFellow.pages.TaskPage;
import org.junit.jupiter.api.Test;


public class NewBugTest extends WebHooks {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();
    private final TaskPage taskPage = new TaskPage();

    private final String login = "AT16";
    private final String password = "Qwerty123";
    private final String taskType = "Ошибка";
    private final String taskTitle = "Ошибка для проверки, потом удалить";
    private final String taskDescription = "Описание ошибки";
    private final String marks = "QA_school";
    private final String env = "Test";

    @Test
    public void newBugMaker() {
        loginPage.loginIntoEdujira(login, password);
        dashboardPage.checkLogin();
        dashboardPage.getIntoTest();
        projectTestPage.checkInTest();
        projectTestPage.createNewBug(taskType, taskTitle, taskDescription, marks, env);
        projectTestPage.switchToReportedByMe();
        taskPage.setInProgress();
        taskPage.closeMessage();
        taskPage.setDone();
        taskPage.closeMessage();

    }

//    @Test
//    public void newBugMaker2() {
//        loginPage.loginIntoEdujira(login, password);
//        dashboardPage.checkLogin();
//        dashboardPage.getIntoTest();
//        projectTestPage.checkInTest();
//        projectTestPage.createNewBug(taskType, taskTitle, taskDescription, marks, env);
//        projectTestPage.switchToReportedByMe();
//        taskPage.setInProgress();
//        taskPage.closeMessage();
//        taskPage.setDone();
//        taskPage.closeMessage();
//    }

}
