package EdujiraiFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;

public class ProjectTestPage {
    private final SelenideElement sidebarBody = $x("//div[@class='aui-sidebar-body']").as("Боковая панель");
    private final SelenideElement switchFilter = $x("//button[@aria-label='Переключить фильтр']").as("Кнопка списка фильтров");
    private final SelenideElement allIssues = $x("//a[@data-item-id='allissues']").as("Фильтр 'Все задачи'");
    private final SelenideElement reportedByMe = $x("//a[@data-item-id='reportedbyme']").as("Фильтр 'Сообщенные мной'");
    private final SelenideElement tasksNumber = $x("//span/parent::div[@class='showing']").as("Число задач");
    private final SelenideElement newTaskButton = $x("//a[@id='create_link']").as("Кнопка создания новой задачи");
    private final SelenideElement newTaskHeader = $x("//h2[@title='Создание задачи']").as("Заголовок окна 'Создание задачи'");
    private final SelenideElement issueTypeField = $x("//input[@id='issuetype-field']").as("Поле ввода типа задачи");
    private final SelenideElement titleField = $x("//input[@id='summary']").as("Поле ввода темы");
    private final SelenideElement descriptionField = $x("//textarea[@id='description']").as("Поле ввода описания");
    private final SelenideElement fixVersions =
            $x("//select[@id='fixVersions']/child::option[contains(text(), 'Неизвестный')]").as("Исправить в версиях - 'Неизвестный'");
    private final SelenideElement versions =
            $x("//select[@id='versions']/child::option[contains(text(), 'Неизвестный')]").as("Затронуты версии - 'Неизвестный'");
    private final SelenideElement marking = $x("//textarea[@id='labels-textarea']").as("Поле ввода меток");
    private final SelenideElement environment = $x("//textarea[@id='environment']").as("Поле ввода окружения");
    private final SelenideElement importance = $x("//select[@class='select cf-select']").as("Выпадающий список 'Серьезность'");
    private final SelenideElement trivial = $x("//option[text()='S0 Тривиальный/Trivial']").as("Серьезность - 'S0 Тривиальный/Trivial'");
    private final SelenideElement createButton = $x("//input[@id='create-issue-submit']").as("Кнопка 'Создать'");
    private final SelenideElement closeButton = $x("//button[@class = 'aui-close-button']").as("Кнопка закрытия всплывающего уведомления");


    @Step("Проверка перехода в проект 'TEST'")
    public void checkInTest() {
        sidebarBody.shouldBe(Condition.visible);
    }

    @Step("Парсинг числа задач")
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

    @Step("Переключение фильтра на 'Все задачи'")
    public void switchToAllTasks() {
        switchFilter.click();
        allIssues.click();
    }

    @Step("Переключение фильтра на 'Сообщенные мной'")
    public void switchToReportedByMe() {
        switchFilter.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        reportedByMe.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    @Step("Создание новой задачи")
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

    @Step("Создание новой ошибки")
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
