package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {

    private final SelenideElement userOptions = $x("//li[@id='user-options']");
    private final SelenideElement projectDroplist = $x("//a[@id='browse_link']");
    private final SelenideElement testButton = $x("//a[@id='admin_main_proj_link_lnk']");
    private final SelenideElement quickSearch = $x("//input[@id='quickSearchInput']");
    private final SelenideElement searchList =
            $x("//img[@class='quick-search-item-image']/following-sibling::span[@class='quick-search-item-title']");


    public DashboardPage checkLogin() {
        userOptions.should(Condition.exist);
        return this;
    }

    public void getIntoTest() {
        projectDroplist.click();
        testButton.click();
    }

    public DashboardPage quickSearch(String request) {
        quickSearch.click();
        quickSearch.sendKeys(request);
        searchList.shouldBe(Condition.visible).click();
        return this;
    }
}
