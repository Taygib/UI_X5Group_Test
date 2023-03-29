package testX5;

import data.ContentMenu;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class X5GroupTest extends TestBase {

    @Test
    @Tag("Group")
    @Tag("mainTest")
    void mainPageTest() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Открыть раздел планирование", () -> {
            mainPage.planMenu();
        });

        step("Открыть раздел покупка", () -> {
            mainPage.buyingMenu();
        });

        step("Открыть раздел доставка", () -> {
            mainPage.deliveryMenu();
        });

        step("Открыть раздел сервисы", () -> {
            mainPage.serviceMenu();
        });

        step("Открыть раздел партнерам", () -> {
            mainPage.partnersMenu();
        });

        step("Открыть раздел инвесторам", () -> {
            mainPage.investorsMenu();
        });
    }

    @Test
    @Tag("Group")
    @Tag("Search")
    void headerSearchTest() {

        step("Открыть страницу", () -> {
            headerSearchPage.openPage();
        });

        step("Поиск из главной стр", () -> {
            headerSearchPage.searchFromMainPage("география");
        });

        step("Поиск из раздела результаты", () -> {
            headerSearchPage.searchFromResultPage("X5 Group");
        });

        step("Тип поиска", () -> {
            headerSearchPage.searchFromResultPageView("по дате");
        });

        step("Поиск", () -> {
            headerSearchPage.searchResult();
        });

        step("Переход на главную страницу", () -> {
            headerSearchPage.goToMainPage();
        });
    }

    static Stream<Arguments> menuContain() {
        return Stream.of(
                Arguments.of(ContentMenu.COMPANY, List.of(
                        "История компании", "География", "Деловая этика", "Стратегия устойчивого развития")),
                Arguments.of(ContentMenu.PARTNERS, List.of(
                        "Добросовестное партнёрство", "Поставщикам", "Сервисы для поставщиков",
                        "Маркетинговые возможности", "Стать франчайзи", "X5 Transport",
                        "Операции с недвижимостью", "X5 Import", "X5 Ready Food",
                        "Закупки для собственных нужд X5 Group")),
                Arguments.of(ContentMenu.INVESTORS, List.of("Отчёты и результаты", "Акции", "Долговые инструменты",
                        "Корпоративное управление", "Кредитные рейтинги", "Частным инвесторам",
                        "Календарь инвестора", "ESG")),
                Arguments.of(ContentMenu.PRESS, List.of("Пресс-релизы", "Интервью", "Индекс «Пятёрочки»",
                        "Фотобанк", "Фирменный стиль X5 Group", "Контакты для прессы"))
        );
    }

    @MethodSource
    @ParameterizedTest
    @Tag("Group")
    @Tag("Menu")
    void menuContain(ContentMenu menuSection, List<String> expectedButtons) {
        step("Открыть страницу", () -> {
            menuContainPage.openOnlyPage();
        });

        step("Проверка меню на содежания", () -> {
            menuContainPage.parameterMenu(menuSection.toString(), expectedButtons);
        });
    }

    @Test
    @Tag("Group")
    @Tag("Feedback")
    void feedBackEmployee() {

        step("Открыть страницу", () -> {
            feedBackPage.openPage();
        });

        step("Выбрать роль", () -> {
            feedBackPage.clickOnSelectRole();
            feedBackPage.clickOnEmployee();
            feedBackPage.clickOnEmployeeAndNext();
        });

        switchTo().window(1);

        step("Выбрать пункт Я сотрудник", () -> {
            feedBackPage.whoIAm("Я сотрудник");
        });

        step("Выбрать пункт Я бывший сотрудник", () -> {
            feedBackPage.whoIAm("Я бывший сотрудник");
        });

        step("Выбрать пункт Я не сотрудник", () -> {
            feedBackPage.whoIAm("Я не сотрудник");
        });
    }
}
