package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class IfellowLoginPage {

    private final SelenideElement loginInput = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordInput = $x("//input[@id='login-form-password']");
    private final SelenideElement loginButton = $x("//input[@value='Войти']");

    public void loginIntoEdujira(String login, String password) {
        loginInput.shouldBe(Condition.visible).sendKeys(login);
        passwordInput.shouldBe(Condition.visible).sendKeys(password);
        loginButton.click();

    }
}
