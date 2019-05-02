package ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket.YmSearchResultsPage;
import ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket.YmSpecificItemPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by e.perceva on 28.10.17.
 */

@Name("Меню поиска")
@FindBy(xpath = "//div[contains(@class, 'header2__main-content')]")
public class HeaderBlock extends HtmlElement {

    @Name("Строка поиска")
    @FindBy(xpath = "//input[@id='header-search']")
    public TextInput searchString;

    @RedirectsTo(page = YmSpecificItemPage.class)
    @Name("Найти")
    @FindBy(xpath = "//button[@type='submit']")
    public TextInput searchButton;

    @ActionTitle("выполняет поиск")
    public void startSearch(String text) {
        searchString.sendKeys(text);
        searchButton.click();
    }

    @ActionTitle("выполняет поиск по запомненному значению")
    public void startSearchRemembered() {
        searchString.sendKeys(YmSearchResultsPage.rememberedSearchResult);
        searchButton.click();
    }
}