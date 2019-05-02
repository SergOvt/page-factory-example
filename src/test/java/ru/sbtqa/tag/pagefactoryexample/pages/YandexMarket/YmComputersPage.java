package ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket;

import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.CategoriesBlock;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.HeaderBlock;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.LeftMenuBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Компьютеры")
public class YmComputersPage extends Page implements AbstractPage{

    @ElementTitle("Меню поиска")
    public HeaderBlock headerBlock;

    @ElementTitle("Категории")
    public CategoriesBlock categoriesBlock;

    @ElementTitle("Левое Меню")
    public LeftMenuBlock leftMenuBlock;

    public YmComputersPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
        isPageLoaded();
    }
}