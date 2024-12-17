package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement loginInput = $x("//input[@id='login-form-username']").as("Поле логина");
    private final SelenideElement passwordInput = $x("//input[@id='login-form-password']").as("Поле пароля");
    private final SelenideElement loginButton = $x("//input[@value='Войти']").as("Кнопка 'Вход'");
    private final SelenideElement loginError = $x("//div[@id='usernameerror']").as("Сообщение о неверном логине или пароле");
    private final SelenideElement messageError = $x("//div[@class='aui-message aui-message-error']").as("Сообщение о неверном логине или пароле");

    @Step("Авторизация в системе Edujira: логин - '{login}', пароль - '{password}'")
    public void loginIntoEdujira(String login, String password) {

        loginInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys(login);
        passwordInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys(password);
        loginButton.click();
        sleep(1000);

        if (loginError.exists() | messageError.exists()) {
            sleep(1000);
            loginInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys(login);
            passwordInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys(password);
            loginButton.click();
        }
    }
}
