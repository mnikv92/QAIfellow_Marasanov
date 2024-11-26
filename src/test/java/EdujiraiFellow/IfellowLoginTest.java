package EdujiraiFellow;

import EdujiraiFellow.pages.IfellowDashboardPage;
import EdujiraiFellow.pages.IfellowLoginPage;
import org.junit.jupiter.api.Test;

public class IfellowLoginTest extends WebHooks {

    private final IfellowLoginPage ifellowLoginPage = new IfellowLoginPage();
    private final IfellowDashboardPage ifellowDashboardPage = new IfellowDashboardPage();
    private final String login = "AT16";
    private final String password = "Qwerty123";

    @Test
    public void loginTest() {
        ifellowLoginPage.loginIntoEdujira(login, password);
        ifellowDashboardPage.checkLogin();
    }
}
