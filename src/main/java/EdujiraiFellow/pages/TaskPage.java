package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class TaskPage {
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/child::span");
    private final SelenideElement fixInVersions = $x("//span[@class='shorten']/child::a");
    private final SelenideElement inProgress = $x("//a[@id='action_id_21']/child::span[text()='В работе']");
    private final SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']");
    private final SelenideElement done = $x("//span[text()='Выполнено']");

    public String parseStatus() {
        return taskStatus.shouldBe(Condition.visible).getText();
    }

    public String parseVersion() {
        return fixInVersions.shouldBe(Condition.visible).getText();
    }

    public TaskPage setInProgress() {
        inProgress.shouldBe(Condition.visible).click();
        return this;
    }

    public TaskPage setDone() {
        businessProcess.shouldBe(Condition.visible).click();
        done.shouldBe(Condition.visible).click();
        return this;
    }

}

