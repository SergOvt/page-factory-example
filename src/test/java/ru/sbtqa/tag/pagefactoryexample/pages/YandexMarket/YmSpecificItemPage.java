package ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.CategoriesBlock;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.HeaderBlock;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.SearchResultsBlock;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by e.perceva on 28.10.2017.
 */
@PageEntry(title = "Конкретный товар")
public class YmSpecificItemPage extends Page implements AbstractPage {

    @Name("Имя товара")
    @FindBy(xpath = "//*[contains(@class,'n-product-title__text-container')]//h1")
    public TextBlock name;

    @ElementTitle("Меню поиска")
    public HeaderBlock headerBlock;

    @ElementTitle("Результаты поиска")
    public SearchResultsBlock searchResultsBlock;

    @ElementTitle("Категории")
    public CategoriesBlock categoriesBlock;

    public YmSpecificItemPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
        isPageLoaded();
    }

    @ActionTitle("проверяет имя товара")
    public void checkFirstEntry() {
        try {
            new WebDriverWait(PageFactory.getDriver(), 10).until(ExpectedConditions.visibilityOf(name));
            Assert.assertEquals(name.getText(), YmSearchResultsPage.rememberedSearchResult);
        } catch (Exception ex) {
            searchResultsBlock.returnProductCards().get(0).click();
            isPageLoaded();
            Assert.assertEquals(name.getText(), YmSearchResultsPage.rememberedSearchResult);
        }
    }
}
