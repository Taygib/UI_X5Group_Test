package testX5Group;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FeedBackPage;

import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

@Owner("Taygib")
public class FeedBackEmployeeTest extends TestBase {
    FeedBackPage feedBackPage = new FeedBackPage();

    @Test
    @Tag("Group")
    @Tag("Feedback")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кликабельности чекбоксов в разделе Обратная связь")
    void feedBackEmployeeTest() {

        String role = "Я сотрудник";

        step("Открыть страницу", () -> {
            feedBackPage.openPage("ru/", "Принять");
        });

        step("Выбрать роль", () -> {

            step("Проверка названия раздела =Обратная связь=", () -> {
                feedBackPage.findFeedback("Обратная связь");
            });

            step("Найти и выбрать роль", () -> {
                feedBackPage.findAndClickRole("Выберите роль", role);
            });

            step("Проверка выбора роли =" + role + "=", () -> {
                feedBackPage.checkRole(role);
            });

            step("Нажать на кнопку =Далее=", () -> {
                feedBackPage.clickOnButton("Далее");
            });
        });

        switchTo().window(1);

        step("Выбрать пункт =Я сотрудник=", () -> {
            feedBackPage.clickOnCheckboxWhoIAm("Я сотрудник");

            step("Проверка выбранного пункта =Я сотрудник=", () -> {
                feedBackPage.checkClickOnCheckbox("Я сотрудник");
            });
        });

        step("Выбрать пункт =Я бывший сотрудник=", () -> {
            feedBackPage.clickOnCheckboxWhoIAm("Я бывший сотрудник");

            step("Проверка выбранного пункта =Я бывший сотрудник=", () -> {
                feedBackPage.checkClickOnCheckbox("Я бывший сотрудник");
            });
        });

        step("Выбрать пункт =Я не сотрудник=", () -> {
            feedBackPage.clickOnCheckboxWhoIAm("Я не сотрудник");

            step("Проверка выбранного пункта =Я не сотрудник=", () -> {
                feedBackPage.checkClickOnCheckbox("Я не сотрудник");
            });
        });
    }
}