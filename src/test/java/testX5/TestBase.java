package testX5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.WorkPage;

public class TestBase {
    WorkPage workPage = new WorkPage();

    @BeforeAll
        static void beforeAll() {
        Configuration.browserSize = "1520x780";
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

}
