package apiTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static apiTest.helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class ApiX5GroupTest {

    @Test
    @Tag("Group")
    @Tag("Api")
    void checkMain() {
        step("Открыть главную страницу", () ->
        given()
                .filter(withCustomTemplates())
                .get("https://www.x5.ru/ru/")
                .then()
                .log().status()
                .statusCode(200));
    }

    @Test
    @Tag("Group")
    @Tag("Api")
    void checkPlanning() {
        step("Открыть страницу Планирование", () ->
        given()
                .filter(withCustomTemplates())
                .when()
                .get("https://www.x5.ru/ru/consumer/")
                .then()
                .log().status()
                .statusCode(200));
    }

    @Test
    @Tag("Group")
    @Tag("Api")
    void checkShopping() {
        step("Открыть страницу Покупка", () ->
        given()
                .filter(withCustomTemplates())
                .when()
                .get("https://www.x5.ru/ru/consumer/#shopping")
                .then()
                .log().status()
                .statusCode(200));
    }

    @Test
    @Tag("Group")
    @Tag("Api")
    void checkDelivery() {
        step("Открыть страницу Доставка", () ->
        given()
                .filter(withCustomTemplates())
                .when()
                .get("https://www.x5.ru/ru/consumer/#delivery")
                .then()
                .log().status()
                .statusCode(200));
    }

    @Test
    @Tag("Group")
    @Tag("Api")
    void checkServices() {
        step("Открыть страницу Сервисы", () ->
        given()
                .filter(withCustomTemplates())
                .when()
                .get("https://www.x5.ru/ru/consumer/#services")
                .then()
                .log().status()
                .statusCode(200));
    }

    @Test
    @Tag("Group")
    @Tag("Api")
    void checkSearch() {
        step("Проверка поисковой строки", () ->
        given()
                .filter(withCustomTemplates())
                .when()
                .get("https://www.x5.ru/?s=компания")
                .then()
                .log().status()
                .statusCode(200));
    }

    @Test
    @Tag("Group")
    @Tag("Api")
    void negativCheckMain() {
        step("Проверка на невалидную адресную строкку", () ->
        given()
                .filter(withCustomTemplates())
                .when()
                .get("https://www.x5.ru/5u/")
                .then()
                .log().status()
                .statusCode(404));
    }
}