package ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.PageWrapper;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket.YmNotebooksPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by e.perceva on 28.10.17.
 */
@Name("Левое Меню")
@FindBy(css = ".catalog-menu__item")
public class LeftMenuBlock extends HtmlElement {

    @RedirectsTo(page = YmNotebooksPage.class)
    @ElementTitle("Ноутбуки")
    @FindBy(xpath = "//a[contains(@class, 'catalog-menu__list-item') and contains(text(),'Ноутбук')]")
    public Link notebooks;
    @RedirectsTo(page = YmNotebooksPage.class)
    @ElementTitle("Планшеты")
    @FindBy(xpath = "//a[contains(@class, 'catalog-menu__list-item') and contains(text(),'Планшет')]")
    public Link tablets;
    private PageWrapper pageFactory = PageFactory.getInstance();

    @ActionTitle("нажимает на ссылку")
    public void click(String name) throws PageException {
        pageFactory.getCurrentPage().findElementInBlockByTitle("Левое Меню", name).click();
    }
}