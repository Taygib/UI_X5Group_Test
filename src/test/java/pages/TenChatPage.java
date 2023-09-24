package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TenChatPage {
    private SelenideElement cookieConsent = $("div.cookie-consent__button-group"),
            footer = $(".footer").$(".footer__nav"),
            tcBreakWord = $(".tc-break-word");

    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void clickOnTenChat(String tenChat) {
        footer.find(byText(tenChat)).click();
    }

    public void checkOpenTenChat(String x5Group) {
        tcBreakWord.shouldHave(text(x5Group));
    }
}