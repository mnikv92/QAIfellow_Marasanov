package ru.iFellow;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class WebHooks {

    @BeforeEach
    public void initListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }

//    @AfterEach
//    public void closeBrowser() {
//        Selenide.closeWebDriver();
//    }
}