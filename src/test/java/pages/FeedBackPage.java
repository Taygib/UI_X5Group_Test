package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FeedBackPage {
    private SelenideElement cookieConsent = $("div.cookie-consent__button-group"),
            feedback = $(".feedback").$(".feedback__content"),
            feedbackDescription = $(".feedback__description"),
            customSelect = $(".custom-select"),
            css1n9v7xy = $(".css-1n9v7xy"),
            selectListbox = $("#react-select-2-listbox"),
            cssdp7ulp = $(".css-dp7ulp"),
            hlfTable = $("div.hlf-table");

    private ElementsCollection feedbackContent = $$(".feedback__content"),
            buttonInner = $$(".button__inner");

    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void findFeedback(String feedBack) {
        feedback.hover();
        feedbackDescription.shouldHave(text(feedBack));
    }

    public void findAndClickRole(String fieldForRoles, String selectRoles) {
        customSelect.find(byText(fieldForRoles));
        css1n9v7xy.click();
        selectListbox.find(byText(selectRoles)).click();
    }

    public void checkRole(String role) {
        cssdp7ulp.shouldHave(text(role));
    }

    public void clickOnButton(String nameButton) {
        feedbackContent.find(text(nameButton)).hover();
        buttonInner.find(text(nameButton)).click();
    }

    public void clickOnCheckboxWhoIAm(String who) {
        hlfTable.find(byText(who)).click();
    }

    public void checkClickOnCheckbox(String WhoIAm) {
        hlfTable.find(byText(WhoIAm)).parent().$("[type=radio]").shouldBe(checked);
    }
}