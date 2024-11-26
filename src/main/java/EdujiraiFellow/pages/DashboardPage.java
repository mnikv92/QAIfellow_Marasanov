package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {

    private final SelenideElement userOptions = $x("//li[@id='user-options']");
//    private final SelenideElement profileButton = $x("//a[@id='view_profile']");
    private final SelenideElement projectDroplist = $x("//a[@id='browse_link']");
    private final SelenideElement testButton = $x("//a[@id='admin_main_proj_link_lnk']");

    public DashboardPage checkLogin() {
        userOptions.should(Condition.exist);
        return this;
    }

    public void getIntoTest() {
        projectDroplist.click();
        testButton.click();
    }
}
