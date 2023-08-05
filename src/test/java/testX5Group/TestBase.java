package testX5Group;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.SelenoidConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

public class TestBase {
    private static SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class, System.getProperties());

    MainPage mainPage = new MainPage();
    HeaderSearchPage headerSearchPage = new HeaderSearchPage();
    MenuContainPage menuContainPage = new MenuContainPage();
    FeedBackPage feedBackPage = new FeedBackPage();
    ContactInformationPage contactInformationPage = new ContactInformationPage();
    TelegramPage telegramPage = new TelegramPage();
    VKPage vkPage = new VKPage();
    DzenPage dzenPage = new DzenPage();
    TenChatPage tenChatPage = new TenChatPage();

    static  boolean isRemote = Boolean.getBoolean("isRemote");

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1520x780");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");

        if (isRemote) {
            Configuration.remote = System.getProperty("selenoidRemote",
                    "https://" + config.login() + ":" + config.password() + "@" + config.url() + "/wd/hub");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
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