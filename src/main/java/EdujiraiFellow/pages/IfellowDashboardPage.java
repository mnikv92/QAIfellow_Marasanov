package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class IfellowDashboardPage {

    private final SelenideElement userList = $x("//li[@id='user-options']");
    private final SelenideElement profileButton = $x("//a[@id='view_profile']");
    private final SelenideElement projectDroplist = $x("//a[@id='browse_link']");
    private final SelenideElement testButton = $x("//a[@id='admin_main_proj_link_lnk']");

    public IfellowDashboardPage checkLogin() {
        userList.shouldBe(Condition.visible);
        return this;
    }
}
