package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class MainPage {
    private SelenideElement
            buyerOuterContainer = $("section.block--main-container"),
            corporateBlock = $("div.corporate-block"),
            cookieConsent = $("div.cookie-consent__button-group"),
            slidePlanning = $("[data-slide=planning]"),
            slideShopping = $("[data-slide=shopping]").$(".buyer-slider-content-item__icon-items"),
            slideDelivery = $("[data-slide=delivery]").$(".buyer-slider-content-item__icon-items"),
            slideServices = $("[data-slide=services]").$(".buyer-slider-content-item__icon-items"),
            blockHeader = $(".block-header__heading"),
            calendarHeader = $(".calendar__header");


    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void clickOnPlanMenu(String text, String clickContentName) {
        buyerOuterContainer.find(byText(text)).hover();
        buyerOuterContainer.find(byText(clickContentName)).click();
    }

    public void checkClickOnPlan(String FoodRu) {
        slidePlanning.shouldHave(text(FoodRu));
        Selenide.back();
    }

    public void clickOnBuyingMenu(String text, String clickContentName) {
        buyerOuterContainer.find(byText(text)).hover();
        buyerOuterContainer.find(byText(clickContentName)).click();
    }

    public void checkClickOnBuying(String crossroads, String pyaterochka, String chizhik, String krasnyYar, String Slata) {
        slideShopping.shouldHave(text(crossroads), text(pyaterochka), text(chizhik), text(krasnyYar), text(Slata));
        Selenide.back();
    }

    public void clickOnDeliveryMenu(String text, String clickContentName) {
        buyerOuterContainer.find(byText(text)).hover();
        buyerOuterContainer.find(byText(clickContentName)).click();
    }

    public void checkClickOnDelivery(String vprok, String crossroads, String pyaterochka, String lotOfSalmon) {
        slideDelivery.shouldHave(text(vprok), text(crossroads), text(pyaterochka), text(lotOfSalmon));
        Selenide.back();
    }

    public void clickOnServiceMenu(String text, String clickContentName) {
        buyerOuterContainer.find(byText(text)).hover();
        buyerOuterContainer.find(byText(clickContentName)).click();
    }

    public void checkClickOnService(String x5ID, String x5Bank, String x5Club, String x5Pack, String x5Post) {
        slideServices.shouldHave(text(x5ID), text(x5Bank), text(x5Club), text(x5Pack), text(x5Post));
        Selenide.back();
    }

    public void clickOnPartnersMenu(String text, String clickContentName) {
        corporateBlock.find(byText(text)).hover();
        corporateBlock.find(byText(clickContentName)).click();

    }

    public void checkClickOnPartners(String Suppliers) {
        blockHeader.find(byText(Suppliers));
        switchTo().window(0);
    }

    public void clickOnInvestorsMenu(String text, String clickContentName) {
        corporateBlock.find(byText(text)).hover();
        corporateBlock.find(byText(clickContentName)).click();

    }

    public void checkClickOnInvestors(String investors) {
        calendarHeader.hover();
        calendarHeader.shouldHave(text(investors));
        Selenide.back();
    }
}