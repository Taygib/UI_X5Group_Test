package testX5Group;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("Taygib")
public class ContactsTest extends TestBase {
    ContactInformationPage contactInformationPage = new ContactInformationPage();
    TelegramPage telegramPage = new TelegramPage();
    VKPage vkPage = new VKPage();
    DzenPage dzenPage = new DzenPage();
    TenChatPage tenChatPage = new TenChatPage();

    @Test
    @Tag("Group")
    @Tag("Contact")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка контактной информации")
    void contactInformationTest() {

        step("Открыть страницу", () -> {
            contactInformationPage.openPage("ru/", "Принять");
        });

        step("Проверка телефонных номеров", () -> {
            contactInformationPage.checkPhoneNumber("Корпоративный центр",
                    "+7 495 662 88 88", "+7 495 789 95 95");
        });

        step("Проверка Адреса", () -> {
            contactInformationPage.checkAddress("Адрес",
                    "119049, Россия, г. Москва, улица Коровий Вал, 5, стр. 1");
        });
    }

    @Test
    @Tag("Group")
    @Tag("Contact")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка страницы Telegram")
    void openTelegramTest() {

        step("Открыть страницу", () -> {
            telegramPage.openPage("ru/", "Принять");
        });

        step("Открыть Telegram X5 Group", () -> {
            telegramPage.clickOnTelegram("Telegram");
        });

        switchTo().window(1);

        step("Проверка открытой страницы Telegram", () -> {
            telegramPage.checkOpenTelegram("Новости X5 Group", "View in Telegram");
        });
    }

    @Test
    @Tag("Group")
    @Tag("Contact")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка страницы VK")
    void openVKTest() {

        step("Открыть страницу", () -> {
            vkPage.openPage("ru/", "Принять");
        });

        step("Открыть страницу VK X5 Group", () -> {
            vkPage.clickOnVK("VK");
        });

        switchTo().window(1);

        step("Проверка открытой страницы VK", () -> {
            vkPage.checkOpenVK("X5 Group");
        });
    }

    @Test
    @Tag("Group")
    @Tag("Contact")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка страницы Dzen")
    void openDzenTest() {

        step("Открыть страницу", () -> {
            dzenPage.openPage("ru/", "Принять");
        });

        step("Открыть страницу Dzen X5 Group", () -> {
            dzenPage.clickOnDzen("Dzen");
        });

        switchTo().window(1);

        step("Проверка открытой страницы Dzen", () -> {
            dzenPage.checkOpenDzen("X5 Group");
        });
    }

    @Test
    @Tag("Group")
    @Tag("Contact")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка страницы TenChat")
    void openTenChatTest() {

        step("Открыть страницу", () -> {
            tenChatPage.openPage("ru/", "Принять");
        });

        step("Открыть страницу TenChat X5 Group", () -> {
            tenChatPage.clickOnTenChat("TenChat");
        });

        step("Проверка открытой страницы TenChat", () -> {
            tenChatPage.checkOpenTenChat("X5 Group");
        });
    }
}