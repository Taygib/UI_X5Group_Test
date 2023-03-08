package testX5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class X5GroupTest {

    @Test
    @Tag("mainTest")
    void mainPageTest() {

        Configuration.holdBrowserOpen = true;

        open("https://www.x5.ru/ru/");
        $("div.cookie-consent__button-group").find(byText("Принять")).click();

        $("div.hero-main__logo").find(byText("Выбор в пользу будущего"));

        //Планирование
        $("div.buyer__outer-container").find(byText("Найти рецепт и подобрать ингредиенты")).hover();
        $("div.buyer__outer-container").find(byText("Планирование")).click();
        Selenide.back();

        //Покупка
        $("div.buyer__outer-container").find(byText("Купить продукты и товары для дома " +
                "в магазине")).hover();
        $("div.buyer__outer-container").find(byText("Покупка")).click();
        Selenide.back();

        //Доставка
        $("div.buyer__outer-container").find(byText("Заказать продукты и готовые блюда с доставкой" +
                " на дом")).hover();
        $("div.buyer__outer-container").find(byText("Доставка")).click();
        Selenide.back();

        //Сервисы
        $("div.buyer__outer-container").find(byText("Дополнительные сервисы для комфортных " +
                "и выгодных покупок")).hover();
        $("div.buyer__outer-container").find(byText("Сервисы")).click();
        Selenide.back();


        //Партнерам
        $("div.corporate-block").find(byText("Как получить доступ к миллионам клиентов по всей " +
                "стране и другие возможности сотрудничества")).hover();
        $("div.corporate-block").find(byText("Партнерам")).click();
        switchTo().window(0);


        //Инвесторам
        $("div.corporate-block").find(byText("Темпы роста, развитие форматов и цифровых бизнесов " +
                "и другие данные для оценки эффективности компании")).hover();
        $("div.corporate-block").find(byText("Инвесторам")).click();
        Selenide.back();
        switchTo().window(1).close();

    }
    @Test
    @Tag("Search")
    void headerSearchTest() {

        Configuration.holdBrowserOpen = true;

        open("https://www.x5.ru/ru/");
        $("div.cookie-consent__button-group").find(byText("Принять")).click();

        $("div.hero-main__logo").find(byText("Выбор в пользу будущего"));

        //Поиск
        //Поиск из главной стр
        $("div.header-search").click();
        $(".header-search__term").click();
        $(".header-search__term").setValue("география").pressEnter();
        $(".search-form__clear-btn").click();
        //поиск из раздела Результаты
        $(".search-form__term").setValue("X5 Group");
        $(".search-form__type-cnt").find(byText("по дате")).click();
        $("div.search-form__buttons").find(byText("Найти")).click();
        $(".header__logo").click();

    }



}
