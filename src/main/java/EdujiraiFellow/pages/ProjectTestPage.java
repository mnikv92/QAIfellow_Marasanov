package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;

public class ProjectTestPage {
    private final SelenideElement sidebarBody = $x("//div[@class='aui-sidebar-body']");
    private final SelenideElement switchFilter = $x("//button[@aria-label='Переключить фильтр']");
    private final SelenideElement allIssues = $x("//a[@data-item-id='allissues']");
    private final SelenideElement reportedByMe = $x("//a[@data-item-id='reportedbyme']");
    private final SelenideElement tasksNumber = $x("//span/parent::div[@class='showing']");
    private final SelenideElement newTaskButton = $x("//a[@id='create_link']");
    private final SelenideElement newTaskHeader = $x("//h2[@title='Создание задачи']");
    private final SelenideElement issueTypeField = $x("//input[@id='issuetype-field']");
    private final SelenideElement titleField = $x("//input[@id='summary']");
    private final SelenideElement descriptionField = $x("//textarea[@id='description']");
    private final SelenideElement fixVersions =
            $x("//select[@id='fixVersions']/child::option[contains(text(), 'Неизвестный')]");
    private final SelenideElement versions =
            $x("//select[@id='versions']/child::option[contains(text(), 'Неизвестный')]");
    private final SelenideElement marking = $x("//textarea[@id='labels-textarea']");
    private final SelenideElement environment = $x("//textarea[@id='environment']");
    private final SelenideElement importance = $x("//select[@class='select cf-select']");
    private final SelenideElement trivial = $x("//option[text()='S0 Тривиальный/Trivial']");
    private final SelenideElement createButton = $x("//input[@id='create-issue-submit']");
    private final SelenideElement closeButton = $x("//button[@class = 'aui-close-button']");


    public void checkInTest() {
        sidebarBody.shouldBe(Condition.visible);
    }

    public Integer parseTasksNumber() {
        String text = tasksNumber.shouldBe(Condition.visible, Duration.ofSeconds(20)).getText();
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers.get(numbers.size() - 1);
    }

    public void switchToAllTasks() {
        switchFilter.click();
        allIssues.click();
    }

    public void switchToReportedByMe() {
        switchFilter.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        reportedByMe.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public void createNewTask(String taskType, String taskTitle, String taskDescription) {
        newTaskButton.click();
        newTaskHeader.shouldBe(Condition.visible);
        issueTypeField.shouldBe(Condition.visible).click();
        issueTypeField.shouldBe(Condition.visible).sendKeys(taskType);
        titleField.shouldBe(Condition.visible).sendKeys(taskTitle);
        descriptionField.shouldBe(Condition.visible).sendKeys(taskDescription);
        createButton.click();
        closeButton.shouldBe(Condition.visible).click();
        Selenide.refresh();
    }

    public void createNewBug(String taskType, String taskTitle, String taskDescription, String env, String marks) {
        newTaskButton.click();
        newTaskHeader.shouldBe(Condition.visible);
        issueTypeField.shouldBe(Condition.visible).click();
        issueTypeField.shouldBe(Condition.visible).sendKeys(taskType);
        titleField.shouldBe(Condition.visible).sendKeys(taskTitle);
        descriptionField.shouldBe(Condition.visible).sendKeys(taskDescription);
        fixVersions.shouldBe(Condition.visible).click();
        marking.shouldBe(Condition.visible).click();
        marking.shouldBe(Condition.visible).sendKeys(marks);
        marking.sendKeys(Keys.RETURN);
        environment.sendKeys(env);
        versions.shouldBe(Condition.visible).click();
        importance.shouldBe(Condition.visible).click();
        trivial.shouldBe(Condition.visible).click();
        createButton.shouldBe(Condition.visible).click();
        closeButton.shouldBe(Condition.visible).click();
    }
}
