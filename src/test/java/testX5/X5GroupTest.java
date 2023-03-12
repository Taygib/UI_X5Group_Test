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

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class X5GroupTest extends TestBase {

    @Test
    @Tag("test")
    @Tag("mainTest")
    void mainPageTest() {

        step("Открыть страницу", () -> {
            workPage.openPage();
        });

        step("Открыть раздел планирование", () -> {
            workPage.planMenu();
        });

        step("Открыть раздел покупка", () -> {
            workPage.buyingMenu();
        });

        step("Открыть раздел доставка", () -> {
            workPage.deliveryMenu();
        });

        step("Открыть раздел сервисы", () -> {
            workPage.serviceMenu();
        });

        step("Открыть раздел партнерам", () -> {
            workPage.partnersMenu();
        });

        step("Открыть раздел инвесторам", () -> {
            workPage.investorsMenu();
        });
    }

    @Test
    @Tag("test")
    @Tag("Search")
    void headerSearchTest() {

        step("Открыть страницу", () -> {
            workPage.openPage();
        });

        step("Поиск из главной стр", () -> {
            workPage.searchFromMainPage("география");
        });

        step("Поиск из раздела результаты", () -> {
            workPage.searchFromResultPage("X5 Group");
        });

        step("Тип поиска", () -> {
            workPage.searchFromResultPageView("по дате");
        });

        step("Поиск", () -> {
            workPage.searchResult();
        });

        step("Переход на главную страницу", () -> {
            workPage.goToMainPage();
        });
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
    @Tag("test")
    @Tag("Menu")
    void menuContain(

            ContentMenu contain,
            List<String> buttons
    ) {
        step("Открыть страницу", () -> {
            workPage.openOnlyPage();
        });

        step("Проверка меню на содежания", () -> {
            workPage.parameterMenu(contain.name(), buttons);
        });
    }

    @Test
    @Tag("test")
    @Tag("Feedback")
    void FeedBackEmployee() {

        step("Открыть страницу", () -> {
            workPage.openPage();
        });

        step("Выбрать роль", () -> {
            workPage.clickOnSelectRole();
            workPage.clickOnEmployee();
            workPage.clickOnEmployeeAndNext();
        });

        switchTo().window(1);

        step("Выбрать пункт Я сотрудник", () -> {
            workPage.whoIAm("Я сотрудник");
        });

        sleep(500);

        step("Выбрать пункт Я бывший сотрудник", () -> {
            workPage.whoIAm("Я бывший сотрудник");
        });

        sleep(500);

        step("Выбрать пункт Я не сотрудник", () -> {
            workPage.whoIAm("Я не сотрудник");
        });
    }
}
