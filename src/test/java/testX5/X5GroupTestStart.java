package testX5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.ContentMenu;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.WorkPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class X5GroupTestStart {

    @Test
    @Tag("mainTest1")
    void mainPageTest() {

        //Configuration.browser = "opera";
       // Configuration.holdBrowserOpen = true;


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
    @Tag("Search1")
    void headerSearchTest() {

      //  Configuration.holdBrowserOpen = true;

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

    static Stream<Arguments> menuContain() {
        return Stream.of(
                Arguments.of(ContentMenu.Компания, List.of("История компании" + "\n" + "География" +
                        "\n" + "Деловая этика" + "\n" + "Стратегия устойчивого развития", "", "", "")),
                Arguments.of(ContentMenu.Партнерам, List.of("", "Добросовестное партнёрство" + "\n" + "Поставщикам"
                        + "\n" + "Сервисы для поставщиков" + "\n" + "Маркетинговые возможности" + "\n" + "Стать франчайзи"
                        + "\n" + "X5 Transport" + "\n" + "Операции с недвижимостью" + "\n" + "X5 Import" +
                        "\n" + "X5 Ready Food" + "\n" + "Закупки для собственных нужд X5 Group", "", "")),
                Arguments.of(ContentMenu.Инвесторам, List.of("", "", "Отчёты и результаты" + "\n"
                        + "Акции" + "\n" + "Долговые инструменты" + "\n" + "Корпоративное управление" +
                        "\n" + "Кредитные рейтинги" + "\n" + "Частным инвесторам" +
                        "\n" + "Календарь инвестора" + "\n" + "ESG", "")),
                Arguments.of(ContentMenu.Пресс, List.of("", "", "", "Пресс-релизы" + "\n" + "Интервью" +
                        "\n" + "Индекс «Пятёрочки»" + "\n" + "Фотобанк" + "\n" + "Фирменный стиль X5 Group" +
                        "\n" + "Контакты для прессы"))
        );
    }

    @MethodSource
    @ParameterizedTest
    @Tag("Menu1")
    void menuContain(

            ContentMenu contain,
            List<String> buttons
    ) {

       // Configuration.holdBrowserOpen = true;

        open("https://www.x5.ru/ru/");

        $(".header__content-menu").find(withText(contain.name())).hover();
        $$("ul.header__sub-menu-container").shouldHave(texts(buttons));

    }

    @Test
    @Tag("Feedback1")
    void FeedBackEmployee() {

       // Configuration.holdBrowserOpen = true;

        open("https://www.x5.ru/ru/");

        $("div.cookie-consent__button-group").find(byText("Принять")).click();

        $(".feedback").$(".feedback__content").hover();
        $(".custom-select").shouldHave(text("Выберите роль"));
        $(".css-1n9v7xy").click();
        $("#react-select-2-listbox").find(byText("Я сотрудник")).click();
        $$(".feedback__content").find(text("Далее")).hover();
        $$(".button__inner").find(text("Далее")).click();
        switchTo().window(1);
        $("div.hlf-table").find(byText("Я сотрудник")).click();
        sleep(500);
        $("div.hlf-table").find(byText("Я бывший сотрудник")).click();
        sleep(500);
        $("div.hlf-table").find(byText("Я не сотрудник")).click();


    }

}
