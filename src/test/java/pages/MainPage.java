package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class MainPage {
    private SelenideElement
            buyerOuterContainer = $("div.buyer__outer-container"),
            corporateBlock = $("div.corporate-block"),
            cookieConsent = $("div.cookie-consent__button-group");

    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void clickOnPlanMenu(String text, String clickContentName) {
        buyerOuterContainer.find(byText(text)).hover();
        buyerOuterContainer.find(byText(clickContentName)).click();
        Selenide.back();
    }

    public void clickOnBuyingMenu(String text, String clickContentName) {
        buyerOuterContainer.find(byText(text)).hover();
        buyerOuterContainer.find(byText(clickContentName)).click();
        Selenide.back();
    }

    public void clickOnDeliveryMenu(String text, String clickContentName) {
        buyerOuterContainer.find(byText(text)).hover();
        buyerOuterContainer.find(byText(clickContentName)).click();
        Selenide.back();
    }

    public void clickOnServiceMenu(String text, String clickContentName) {
        buyerOuterContainer.find(byText(text)).hover();
        buyerOuterContainer.find(byText(clickContentName)).click();
        Selenide.back();
    }

    public void clickOnPartnersMenu(String text, String clickContentName) {
        corporateBlock.find(byText(text)).hover();
        corporateBlock.find(byText(clickContentName)).click();
        switchTo().window(0);
    }

    public void clickOnInvestorsMenu(String text, String clickContentName) {
        corporateBlock.find(byText(text)).hover();
        corporateBlock.find(byText(clickContentName)).click();
        Selenide.back();
    }
}