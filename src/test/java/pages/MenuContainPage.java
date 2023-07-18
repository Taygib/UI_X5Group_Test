package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MenuContainPage {
    private SelenideElement headerContentMenu = $(".header__content-menu");

    public void openOnlyPage(String language) {
        open(language);
    }
    public void parameterMenu(String containMenu, List<String> expectedButtons) {
        headerContentMenu.find(withText(containMenu)).hover();
        $$(".header__sub-menu-container > li").shouldHave(CollectionCondition.containExactTextsCaseSensitive(expectedButtons));
    }
}