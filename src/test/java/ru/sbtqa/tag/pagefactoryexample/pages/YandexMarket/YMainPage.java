package ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Яндекс")
public class YMainPage extends Page implements AbstractPage {

    @ElementTitle("Маркет")
    @RedirectsTo(page = YmMainPage.class)
    @FindBy(xpath = "//a[@data-id='market']")
    public Link yandexMarketLink;

    public YMainPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
        isPageLoaded();
    }

    @ActionTitle("нажимает на ссылку")
    public void redirectTo(String elementTitle) throws PageException {
        clickElementByTitle(elementTitle);


    }
}
