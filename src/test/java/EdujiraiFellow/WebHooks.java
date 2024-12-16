package EdujiraiFellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class WebHooks {

    @BeforeEach
    public void initBrowser() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        Configuration.pageLoadStrategy = Config.get("pageLoadStrategy");
        Configuration.browser = Config.get("browser");
        Configuration.timeout = Long.parseLong(Config.get("timeout"));

        Selenide.open(Config.get("app.url"));
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
