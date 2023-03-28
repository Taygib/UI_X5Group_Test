package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HeaderSearchPage {

    public void openPage() {
        open("ru/");
        sleep(500);
        $("div.cookie-consent__button-group").find(byText("Принять")).click();
        $("div.hero-main__logo").find(byText("Выбор в пользу будущего"));
    }

    public void searchFromMainPage(String value) {
        $("div.header-search").click();
        $(".header-search__term").click();
        $(".header-search__term").setValue(value).pressEnter();

    }

    public void searchFromResultPage(String value) {
        $(".search-form__clear-btn").click();
        $(".search-form__term").setValue(value);
    }

    public void searchFromResultPageView(String value) {
        $(".search-form__type-cnt").find(byText(value)).click();

    }

    public void searchResult() {
        $("div.search-form__buttons").find(byText("Найти")).click();
    }

    public void goToMainPage() {
        $(".header__logo").click();
    }
}
