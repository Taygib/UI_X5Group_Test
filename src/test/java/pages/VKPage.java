package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VKPage {
    private SelenideElement cookieConsent = $("div.cookie-consent__button-group"),
            footer = $(".footer").$(".footer__nav"),
            groupInfo = $(".redesigned-group-info");

    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void clickOnVK(String vk) {
        footer.find(byText(vk)).click();
    }

    public void checkOpenVK(String x5Group) {
        groupInfo.shouldHave(text(x5Group));
    }
}