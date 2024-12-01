package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;


public class TaskPage {
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/child::span");
    private final SelenideElement fixInVersions = $x("//span[@class='shorten']/child::a");
    private final SelenideElement inProgress = $x("//a[@id='action_id_21']/child::span[text()='В работе']");
    private final SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']");
    private final SelenideElement done = $x("//span[text()='Выполнено']");
    private final SelenideElement messageCloseButton = $x("//button[@class='aui-close-button']");

    public String parseStatus() {
        return taskStatus.shouldBe(Condition.visible).getText();
    }

    public String parseVersion() {
        return fixInVersions.shouldBe(Condition.visible).getText();
    }

    public void setInProgress() {
        inProgress.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public void setDone() {
        businessProcess.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        done.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public void closeMessage() {
        messageCloseButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

}

