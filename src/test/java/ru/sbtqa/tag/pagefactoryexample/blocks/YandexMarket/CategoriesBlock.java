package ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket;


import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.PageWrapper;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket.YmComputersPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Категории")
@FindBy(css = ".topmenu__list,.n-topmenu-new-horizontal__links")
public class CategoriesBlock extends HtmlElement {

    @RedirectsTo(page = YmComputersPage.class)
    @ElementTitle("Компьютеры")
    @FindBy(xpath = "//a[contains(@class, '__link') and contains(text(),'Компьютер')]")
    public Link computers;
    private PageWrapper pageFactory = PageFactory.getInstance();

    @ActionTitle("нажимает на ссылку")
    public void click(String name) throws PageException {
        pageFactory.getCurrentPage().findElementInBlockByTitle("Категории", name).click();
    }
}
