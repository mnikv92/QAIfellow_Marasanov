package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProjectTestPage {
    private final SelenideElement sidebarBody = $x("//div[@class='aui-sidebar-body']");

    public ProjectTestPage checkInTest() {
        sidebarBody.shouldBe(Condition.visible);
        return this;
    }
}
