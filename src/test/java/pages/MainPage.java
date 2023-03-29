package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class MainPage {
    private SelenideElement
            buyerOuterContainer = $("div.buyer__outer-container"),
            corporateBlock = $("div.corporate-block");

    public void openPage() {
        open("ru/");
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
        switchTo().window(0);
    }

    public void investorsMenu() {
        corporateBlock.find(byText("Темпы роста, развитие форматов и цифровых бизнесов " +
                "и другие данные для оценки эффективности компании")).hover();
        corporateBlock.find(byText("Инвесторам")).click();
        Selenide.back();
    }
}
