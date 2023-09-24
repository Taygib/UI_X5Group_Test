package testX5Group;

import data.ContentMenu;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import pages.MenuContainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Owner("Taygib")
public class MenuTest extends TestBase {
    MenuContainPage menuContainPage = new MenuContainPage();
    MainPage mainPage = new MainPage();

    @Test
    @Tag("Group")
    @Tag("mainTest")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка разделов")
    void mainPageTest() {

        step("Открыть страницу", () -> {
            mainPage.openPage("ru/", "Принять");
        });

        step("Открыть раздел =планирование=", () -> {
            mainPage.clickOnPlanMenu("Найти рецепт и подобрать ингредиенты",
                    "Планирование");
        });

        step("Проверить название торговых сетей в разделе =планирование=", () -> {
            mainPage.checkClickOnPlan("Food.ru");
        });

        step("Открыть раздел =покупка=", () -> {
            mainPage.clickOnBuyingMenu("Купить продукты и товары для дома в магазине",
                    "Покупка");
        });

        step("Проверить название торговых сетей в разделе =покупка=", () -> {
            mainPage.checkClickOnBuying("Перекрёсток", "Пятёрочка", "Чижик",
                    "Красный Яр", "Слата");
        });

        step("Открыть раздел =доставка=", () -> {
            mainPage.clickOnDeliveryMenu("Заказать продукты и готовые блюда с доставкой на дом",
                    "Доставка");
        });

        step("Проверить название торговых сетей в разделе =доставка=", () -> {
            mainPage.checkClickOnDelivery("Впрок", "Перекрёсток",
                    "Пятёрочка", "Много лосося");
        });

        step("Открыть раздел =сервисы=", () -> {
            mainPage.clickOnServiceMenu("Дополнительные сервисы для комфортных и выгодных покупок",
                    "Сервисы");
        });

        step("Проверить название торговых сетей в разделе =сервисы=", () -> {
            mainPage.checkClickOnService("X5 ID", "X5 Банк",
                    "Х5 Клуб", "Пакет", "5Post");
        });

        step("Открыть раздел =партнерам=", () -> {
            mainPage.clickOnPartnersMenu("Как получить доступ к миллионам клиентов по всей стране и" +
                            " другие возможности сотрудничества",
                    "Партнерам");
        });

        step("Проверить наличие раздела =партнерам=", () -> {
            mainPage.checkClickOnPartners("Поставщикам");
        });

        step("Открыть раздел =инвесторам=", () -> {
            mainPage.clickOnInvestorsMenu("Темпы роста, развитие форматов и цифровых бизнесов и" +
                            " другие данные для оценки эффективности компании",
                    "Инвесторам");
        });

        step("Проверить наличие раздела =инвесторам=", () -> {
            mainPage.checkClickOnInvestors("Календарь инвестора");
        });
    }

    static Stream<Arguments> menuContainTest() {
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
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка наличие подменю в меню главной страницы")
    void menuContainTest(ContentMenu menuSection, List<String> expectedButtons) {

        step("Открыть страницу", () -> {
            menuContainPage.openOnlyPage("ru/");
        });

        step("Проверка меню на содежания", () -> {
            menuContainPage.parameterMenu(menuSection.toString(), expectedButtons);
        });
    }
}