package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement loginInput = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordInput = $x("//input[@id='login-form-password']");
    private final SelenideElement loginButton = $x("//input[@value='Войти']");
    private final SelenideElement loginError = $x("//div[@id='usernameerror']");

    public void loginIntoEdujira(String login, String password) {
        loginInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys(login);
        passwordInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys(password);
        loginButton.click();

        if (loginError.exists()) {
            sleep(2000);
            loginInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys(login);
            passwordInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys(password);
            loginButton.click();
        }
    }
}
