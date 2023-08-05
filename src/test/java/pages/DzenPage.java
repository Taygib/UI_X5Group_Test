package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DzenPage {
    private SelenideElement cookieConsent = $("div.cookie-consent__button-group"),
            footer = $(".footer").$(".footer__nav"),
            layoutHeader = $(".desktop-channel-layout__header");

    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void clickOnDzen(String dzen) {
        footer.find(byText(dzen)).click();
    }

    public void checkOpenDzen(String x5Group) {
        layoutHeader.shouldHave(text(x5Group));
    }
}