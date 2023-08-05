package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TelegramPage {
    private SelenideElement cookieConsent = $("div.cookie-consent__button-group"),
            footer = $(".footer").$(".footer__nav"),
            tgmePage = $(".tgme_page");

    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void clickOnTelegram(String telegram) {
        footer.find(byText(telegram)).click();
    }

    public void checkOpenTelegram(String newsX5Group, String viewTelegram) {
        tgmePage.shouldHave(text(newsX5Group), text(viewTelegram));
    }
}