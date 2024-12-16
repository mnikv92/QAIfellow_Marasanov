package EdujiraiFellow;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class WebHooks {

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = Config.get("pageLoadStrategy");
        Configuration.browser = Config.get("browser");
        Configuration.timeout = Long.parseLong(Config.get("timeout"));

        Selenide.open(Config.get("app.url"));
        getWebDriver().manage().window().maximize();
    }
}
