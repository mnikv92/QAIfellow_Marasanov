package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {

    private final SelenideElement userPicture = $x("//img[contains(@alt, 'Пользовательский профиль для')]").as("Аватар пользователя");
    private final SelenideElement projectDroplist = $x("//a[@id='browse_link']").as("Выпадающий список проектов");
    private final SelenideElement testButton = $x("//a[@id='admin_main_proj_link_lnk']").as("Кнопка перехода на проект 'TEST'");
    private final SelenideElement quickSearch = $x("//input[@id='quickSearchInput']").as("Поле быстрого поиска");
    private final SelenideElement searchList = $x("//img[@class='quick-search-item-image']/following-sibling::span[@class='quick-search-item-title']").as("Объект 'TestSeleniumATHomework' в поле быстрого поиска");

    @Step("Проверка авторизации")
    public void checkLogin() {
        userPicture.should(Condition.exist);
    }

    @Step("Переход в проект 'TEST'")
    public void getIntoTest() {
        projectDroplist.click();
        testButton.click();
    }

    @Step("Быстрый поиск")
    public void quickSearch(String request) {
        quickSearch.click();
        quickSearch.sendKeys(request);
        searchList.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }
}