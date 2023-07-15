package testX5;

import data.ContentMenu;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @Owner("Taygib")
    @Severity(SeverityLevel.BLOCKER)
    void mainPageTest() {                                   //  дополнить проверками
        step("Открыть страницу", () -> {
            mainPage.openPage("ru/", "Принять");
        });

        step("Открыть раздел планирование", () -> {
            mainPage.clickOnPlanMenu("Найти рецепт и подобрать ингредиенты",
                    "Планирование");
        });

        step("Открыть раздел покупка", () -> {
            mainPage.clickOnBuyingMenu("Купить продукты и товары для дома в магазине",
                    "Покупка");
        });

        step("Открыть раздел доставка", () -> {
            mainPage.clickOnDeliveryMenu("Заказать продукты и готовые блюда с доставкой на дом",
                    "Доставка");
        });

        step("Открыть раздел сервисы", () -> {
            mainPage.clickOnServiceMenu("Дополнительные сервисы для комфортных и выгодных покупок",
                    "Сервисы");
        });

        step("Открыть раздел партнерам", () -> {
            mainPage.clickOnPartnersMenu("Как получить доступ к миллионам клиентов по всей стране и" +
                            " другие возможности сотрудничества",
                    "Партнерам");
        });

        step("Открыть раздел инвесторам", () -> {
            mainPage.clickOnInvestorsMenu("Темпы роста, развитие форматов и цифровых бизнесов и" +
                            " другие данные для оценки эффективности компании",
                    "Инвесторам");
        });
    }

    @Test
    @Tag("Group")
    @Tag("Search")
    @Owner("Taygib")
    @Severity(SeverityLevel.BLOCKER)
    void headerSearchTest() {

        String firstSearch = "география";
        String secondSearch = "X5 Group";
        String searchType = "по дате";

        step("Открыть страницу", () -> {
            headerSearchPage.openPage("ru/", "Принять");
        });

        step("Поиск из главной стр", () -> {
            headerSearchPage.searchFromMainPage(firstSearch);

            step("проверка поиска", () -> {
                headerSearchPage.checkSearch(firstSearch);
            });
        });

        step("Поиск из раздела результаты", () -> {
            headerSearchPage.searchFromResultPage(secondSearch);

            step("Тип поиска", () -> {
                headerSearchPage.searchFromResultPageView(searchType);
            });

            step("Поиск", () -> {
                headerSearchPage.searchResult("Найти");
            });

            step("проверка поиска", () -> {
                headerSearchPage.checkSearch(secondSearch);
            });
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
    @Owner("Taygib")
    @Severity(SeverityLevel.BLOCKER)
    void menuContain(ContentMenu menuSection, List<String> expectedButtons) {
        step("Открыть страницу", () -> {
            menuContainPage.openOnlyPage("ru/");
        });

        step("Проверка меню на содежания", () -> {
            menuContainPage.parameterMenu(menuSection.toString(), expectedButtons);
        });
    }

    @Test
    @Tag("Group")
    @Tag("Feedback")
    void feedBackEmployee() {

        String role = "Я сотрудник";

        step("Открыть страницу", () -> {
            feedBackPage.openPage("ru/", "Принять");
        });

        step("Выбрать роль", () -> {

            step("Проверка названия раздела =Обратная связь=", () -> {
                feedBackPage.findFeedback("Обратная связь");
            });

            step("Найти и выбрать роль", () -> {
                feedBackPage.findAndClickRole("Выберите роль", role);
            });

            step("Проверка выбора роли =" + role + "=", () -> {
                feedBackPage.checkRole(role);
            });

            step("Нажать на кнопку =Далее=", () -> {
                feedBackPage.clickOnButton("Далее");
            });
        });

        switchTo().window(1);

        step("Выбрать пункт =Я сотрудник=", () -> {
            feedBackPage.clickOnCheckboxWhoIAm("Я сотрудник");

            step("Проверка выбранного пункта =Я сотрудник=", () -> {
                feedBackPage.checkCheckbox("Я сотрудник");
            });
        });

        step("Выбрать пункт Я бывший сотрудник", () -> {
            feedBackPage.clickOnCheckboxWhoIAm("Я бывший сотрудник");

            step("Проверка выбранного пункта =Я бывший сотрудник=", () -> {
                feedBackPage.checkCheckbox("Я бывший сотрудник");
            });
        });

        step("Выбрать пункт Я не сотрудник", () -> {
            feedBackPage.clickOnCheckboxWhoIAm("Я не сотрудник");

            step("Проверка выбранного пункта =Я не сотрудник=", () -> {
                feedBackPage.checkCheckbox("Я не сотрудник");
            });
        });
    }
}