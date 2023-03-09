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

import static com.codeborne.selenide.Selenide.*;

public class X5GroupTest extends TestBase {

    @Test
    @Tag("mainTest")
    void mainPageTest() {

        // Configuration.holdBrowserOpen = true;
        workPage.openPage();
        //Планирование
        workPage.planMenu();
        //Покупка
        workPage.buyingMenu();
        //Доставка
        workPage.deliveryMenu();
        //Сервисы
        workPage.serviceMenu();
        //Партнерам
        workPage.partnersMenu();
        //Инвесторам
        workPage.investorsMenu();

    }

    @Test
    @Tag("Search")
    void headerSearchTest() {

        workPage.openPage();

        //Поиск
        //Поиск из главной стр
        workPage.searchFromMainPage("география");
        //поиск из раздела Результаты
        workPage.searchFromResultPage("X5 Group");
        // Тип поиска
        workPage.searchFromResultPageView("по дате");
        workPage.searchResult();

        //Переход на глав стр
        workPage.goToMainPage();
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
    @Tag("Menu")
    void menuContain(

            ContentMenu contain,
            List<String> buttons
    ) {

        workPage.openOnlyPage();
        workPage.parameterMenu(contain.name(), buttons);
    }

    @Test
    @Tag("Feedback")
    void FeedBackEmployee() {

        // Configuration.holdBrowserOpen = true;

        //проверка Я сотрудник
        workPage.openPage();

        workPage.clickOnSelectRole();

        workPage.clickOnEmployee();
        workPage.clickOnEmployeeAndNext();
        switchTo().window(1);
        workPage.whoIAm("Я сотрудник");
        sleep(500);
        workPage.whoIAm("Я бывший сотрудник");
        sleep(500);
        workPage.whoIAm("Я не сотрудник");

    }
}
