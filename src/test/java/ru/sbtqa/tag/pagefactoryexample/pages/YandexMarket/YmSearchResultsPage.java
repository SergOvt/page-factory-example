package ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.HeaderBlock;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.SearchResultsBlock;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Результаты поиска")
public class YmSearchResultsPage extends Page implements AbstractPage {

    public static String rememberedSearchResult;

    @Name("Имя первого элемента")
    @FindBy(xpath = "//*[contains(@class, 'n-snippet-card2__title')][1]/a")
    public TextBlock name;

    @ElementTitle("Меню поиска")
    private HeaderBlock headerBlock;

    @ElementTitle("Результаты поиска")
    private SearchResultsBlock searchResultsBlock;


    public YmSearchResultsPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
        isPageLoaded();
    }

    @ActionTitle("количество результатов поиска должно быть не менее")
    public void checkResultCount(String amount) {
        Assert.assertTrue("Incorrect count of search results", searchResultsBlock.returnSize() >= Integer.valueOf(amount));
    }

    @ActionTitle("запоминает первый элемент в списке")
    public void saveFirstEntry() {
        isPageLoaded();
        rememberedSearchResult = searchResultsBlock.returnProductCards().get(0).getText().split("\n")[0];
    }
}

