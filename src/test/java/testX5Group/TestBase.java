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

import java.util.Map;

public class TestBase {
    private static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class, System.getProperties());

    protected static boolean isRemote = Boolean.getBoolean("isRemote");

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1520x780");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");

        if (isRemote) {
            Configuration.remote = "https://" + selenoidConfig.login() + ":" + selenoidConfig.password() +
                    "@" + selenoidConfig.url() + "/wd/hub";

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
        if (isRemote) {
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }
}