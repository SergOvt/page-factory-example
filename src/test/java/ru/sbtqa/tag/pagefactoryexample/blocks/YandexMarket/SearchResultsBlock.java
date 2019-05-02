package ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactoryexample.elements.YandexMarket.ProductCard;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@Name("Результаты поиска")
@FindBy(css = ".layout__col_search-filters_visible")
public class SearchResultsBlock extends HtmlElement {
    private String nameXpath = "//*[contains(@class,'link_theme_blue')]";
    @ElementTitle("Список товаров")
    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2__header')]//a")
    private List<ProductCard> productCards;

    public String getProductName() {
        String name = getWrappedElement()
                .findElement(By.xpath(nameXpath))
                .getText();
        return name;
    }

    public int returnSize() {
        return productCards.size();
    }

    public List<ProductCard> returnProductCards() {
        return productCards;
    }

}