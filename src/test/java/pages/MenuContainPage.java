package pages;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MenuContainPage {
    public void openOnlyPage() {
        open("ru/");
    }
    public void parameterMenu(String containMenu, List<String> expectedButtons) {
        $(".header__content-menu").find(withText(containMenu)).hover();
        $$(".header__sub-menu-container > li").shouldHave(CollectionCondition.containExactTextsCaseSensitive(expectedButtons));
    }
}
