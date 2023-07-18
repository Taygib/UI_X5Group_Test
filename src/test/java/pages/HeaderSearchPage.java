package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HeaderSearchPage {
    private SelenideElement cookieConsent = $("div.cookie-consent__button-group"),
            headerSearch = $("div.header-search"),
            headerSearchTerm = $(".header-search__term"),
            searchResultsList = $(".search-results__list"),
            searchFormClearBtn = $(".search-form__clear-btn"),
            searchFormTerm = $(".search-form__term"),
            searchType = $(".search-form__type-cnt"),
            searchFormButtons = $("div.search-form__buttons"),
            headerLogo = $(".header__logo");


    public void openPage(String language, String acceptcookie) {
        open(language);
        cookieConsent.find(byText(acceptcookie)).click();
    }

    public void searchFromMainPage(String search) {
        headerSearch.click();
        headerSearchTerm.click();
        headerSearchTerm.setValue(search).pressEnter();
    }

    public void checkSearch(String textSearch) {
        searchResultsList.shouldHave(text(textSearch));
    }

    public void searchFromResultPage(String fromResult) {
        searchFormClearBtn.click();
        searchFormTerm.setValue(fromResult);
    }

    public void searchFromResultPageView(String view) {
        searchType.find(byText(view)).click();
    }

    public void searchResult(String buttonFind) {
        searchFormButtons.find(byText(buttonFind)).click();
    }

    public void goToMainPage() {
        headerLogo.click();
    }
}