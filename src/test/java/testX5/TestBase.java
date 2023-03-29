package testX5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

public class TestBase {
    MainPage mainPage = new MainPage();
    HeaderSearchPage headerSearchPage = new HeaderSearchPage();
    MenuContainPage menuContainPage = new MenuContainPage();
    FeedBackPage feedBackPage = new FeedBackPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("brSize", "1520x780");
        Configuration.browserVersion = System.getProperty("brVersion", "100.0");
        Configuration.remote = System.getProperty("selenoidRemote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.x5.ru/");
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}