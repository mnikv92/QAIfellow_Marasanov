package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;


public class TaskPage {
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/child::span").as("Статус задачи");
    private final SelenideElement fixInVersions = $x("//span[@class='shorten']/child::a").as("Исправить в версиях");
    private final SelenideElement inProgress = $x("//a[@id='action_id_21']/child::span[text()='В работе']").as("Кнопка установки статуса 'В работе'");
    private final SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']").as("Выпадающий список 'Бизнес-процесс'");
    private final SelenideElement done = $x("//span[text()='Выполнено']").as("Кнопка 'Выполнено'");
    private final SelenideElement messageCloseButton = $x("//button[@class='aui-close-button']").as("Кнопка закрытия всплывающего уведомления");

    @Step("Парсинг статуса задачи")
    public String parseStatus() {
        return taskStatus.shouldBe(Condition.visible).getText();
    }

    @Step("Парсинг версии, в которой должно быть исправлено")
    public String parseVersion() {
        return fixInVersions.shouldBe(Condition.visible).getText();
    }

    @Step("Установить статус 'В работе'")
    public void setInProgress() {
        inProgress.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    @Step("Установить статус 'Выполнено'")
    public void setDone() {
        businessProcess.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        done.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    @Step("Закрыть всплывающее уведомление")
    public void closeMessage() {
        messageCloseButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}