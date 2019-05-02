package ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket;

import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.CategoriesBlock;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.HeaderBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by e.perceva on 28.10.2017.
 */
@PageEntry(title = "Яндекс Маркет")
public class YmMainPage extends Page implements AbstractPage{

    @ElementTitle("Меню поиска")
    public HeaderBlock headerBlock;

    @ElementTitle("Категории")
    public CategoriesBlock categoriesBlock;

    public YmMainPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
        isPageLoaded();
    }


}
