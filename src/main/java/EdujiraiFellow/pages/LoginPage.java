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

    @Step("Авторизация в системе Edujira: логин - '{login}', пароль - '{password}'")
    public void loginIntoEdujira(String login, String password) {
        loginInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue(login);
        passwordInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue(password);
        loginButton.click();
    }
}