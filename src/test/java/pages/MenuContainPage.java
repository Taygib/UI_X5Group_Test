package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MenuContainPage {
    private SelenideElement headerContentMenu = $(".header__content-menu");
    private ElementsCollection menuContainer = $$(".header__sub-menu-container > li");

    public void openOnlyPage(String language) {
        open(language);
    }
    public void parameterMenu(String containMenu, List<String> expectedButtons) {
        headerContentMenu.find(withText(containMenu)).hover();
        menuContainer.shouldHave(CollectionCondition.containExactTextsCaseSensitive(expectedButtons));
    }
}