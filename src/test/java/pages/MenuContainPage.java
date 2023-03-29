package pages;

import com.codeborne.selenide.CollectionCondition;
import data.ContentMenu;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

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
