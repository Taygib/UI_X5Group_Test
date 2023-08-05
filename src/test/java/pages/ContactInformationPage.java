package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactInformationPage {
    private SelenideElement cookieConsent = $("div.cookie-consent__button-group"),
            footer = $(".footer");

    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void checkPhoneNumber(String CorporateCenter, String firstPhoneNumber, String secondPhoneNumber) {
        footer.find(byText(CorporateCenter)).hover();
        footer.shouldHave(text(firstPhoneNumber));
        footer.shouldHave(text(secondPhoneNumber));
    }

    public void checkAddress(String address, String addressName) {
        footer.find(byText(address)).hover();
        footer.shouldHave(text(addressName));
    }
}