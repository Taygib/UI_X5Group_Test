package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;


public class WorkPage {

    private SelenideElement
            buyerOuterContainer = $("div.buyer__outer-container"),
            corporateBlock = $("div.corporate-block");

    public void openOnlyPage() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.x5.ru/");
        open("ru/");
    }

    public void openPage() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.x5.ru/");
        open("ru/");
        sleep(500);
        $("div.cookie-consent__button-group").find(byText("Принять")).click();
        $("div.hero-main__logo").find(byText("Выбор в пользу будущего"));
    }

    public void planMenu() {
        buyerOuterContainer.find(byText("Найти рецепт и подобрать ингредиенты")).hover();
        buyerOuterContainer.find(byText("Планирование")).click();
        Selenide.back();


    }

    public void buyingMenu() {
        buyerOuterContainer.find(byText("Купить продукты и товары для дома " +
                "в магазине")).hover();
        buyerOuterContainer.find(byText("Покупка")).click();
        Selenide.back();
    }

    public void deliveryMenu() {
        buyerOuterContainer.find(byText("Заказать продукты и готовые блюда с доставкой" +
                " на дом")).hover();
        buyerOuterContainer.find(byText("Доставка")).click();
        Selenide.back();
    }

    public void serviceMenu() {
        buyerOuterContainer.find(byText("Дополнительные сервисы для комфортных " +
                "и выгодных покупок")).hover();
        buyerOuterContainer.find(byText("Сервисы")).click();
        Selenide.back();
    }

    public void partnersMenu() {
        corporateBlock.find(byText("Как получить доступ к миллионам клиентов по всей " +
                "стране и другие возможности сотрудничества")).hover();
        corporateBlock.find(byText("Партнерам")).click();
        sleep(1500);
        switchTo().window(0);
    }

    public void investorsMenu() {
        corporateBlock.find(byText("Темпы роста, развитие форматов и цифровых бизнесов " +
                "и другие данные для оценки эффективности компании")).hover();
        corporateBlock.find(byText("Инвесторам")).click();
        Selenide.back();
        // switchTo().window(1).close();
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

    public void parameterMenu(String value, List<String> value1) {
        $(".header__content-menu").find(withText(value)).hover();
        $$("ul.header__sub-menu-container").shouldHave(texts(value1));
    }

    public void clickOnSelectRole() {
        $(".feedback").$(".feedback__content").hover();
        $(".custom-select").shouldHave(text("Выберите роль"));
        $(".css-1n9v7xy").click();
        sleep(500);
    }

    public void clickOnEmployee() {
        $("#react-select-2-listbox").find(byText("Я сотрудник")).click();
    }

    public void clickOnEmployeeAndNext() {
        $$(".feedback__content").find(text("Далее")).hover();
        $$(".button__inner").find(text("Далее")).click();
    }

    public void whoIAm(String value) {
        $("div.hlf-table").find(byText(value)).click();
    }
}
