package testX5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.WorkPage;

public class TestBase {
    WorkPage workPage = new WorkPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1520x880";
    }

}
