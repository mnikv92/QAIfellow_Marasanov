package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

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
    private final SelenideElement tasksNumber = $x("//span/parent::div[@class='showing']");
    private final SelenideElement newTaskButton = $x("//a[@id='create_link']");
//    private final SelenideElement createMenu = $x("//li[@id='create-menu']");
//    private final SelenideElement openDialWindow = $x("//button[@original-title='Открыть в диалоговом окне']");
    private final SelenideElement newTaskHeader = $x("//h2[@title='Создание задачи']");
//    private final SelenideElement issueTypeSelect = $x("//div[@id='issuetype-single-select']");
    private final SelenideElement issueTypeField = $x("//input[@id='issuetype-field']");
    private final SelenideElement titleField = $x("//input[@id='summary']");
    private final SelenideElement createButton = $x("//input[@id='create-issue-submit']");
    private final SelenideElement closeButton = $x("//button[@class = 'aui-close-button']");
//    private final SelenideElement
//    private final SelenideElement
//    private final SelenideElement
//    private final SelenideElement
//    private final SelenideElement
//    private final SelenideElement

    public final String taskType = "Задача";
    public final String taskTitle = "Задача для проверки, потом удалить";

    private final SelenideElement textAreaSummary = $x("//textarea[@name='summary']");

    public ProjectTestPage checkInTest() {
        sidebarBody.shouldBe(Condition.visible);
        return this;
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

    public ProjectTestPage switchToAllTasks() {
        switchFilter.click();
        allIssues.click();
        return this;
    }

    public ProjectTestPage createNewTask() {
        newTaskButton.click();
        newTaskHeader.shouldBe(Condition.visible);
        issueTypeField.shouldBe(Condition.visible).sendKeys(taskType);
        titleField.shouldBe(Condition.visible).sendKeys(taskTitle);
        createButton.click();
        closeButton.shouldBe(Condition.visible).click();
        return this;
    }
}
