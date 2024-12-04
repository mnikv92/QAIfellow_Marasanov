package EdujiraiFellow;

import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends WebHooks {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final String login = "AT16";
    private final String password = "Qwerty123";


    @Test
    public void loginTest() {
        loginPage.loginIntoEdujira(login, password);
        dashboardPage.checkLogin();
    }
}
