package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FeedBackPage {
    public void openPage() {
        open("ru/");
        sleep(500);
        $("div.cookie-consent__button-group").find(byText("Принять")).click();
        $("div.hero-main__logo").find(byText("Выбор в пользу будущего"));
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

