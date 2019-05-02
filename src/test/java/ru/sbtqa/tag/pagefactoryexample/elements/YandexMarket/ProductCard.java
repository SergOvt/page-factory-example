package ru.sbtqa.tag.pagefactoryexample.elements.YandexMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ProductCard extends TypifiedElement {

    private String nameXpath = "//*[contains(@class,'link_theme_blue')]";
    private String costXpath = ".//div[@class='price']";

    public ProductCard(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public String getProductName(){
        String name = getWrappedElement()
                .findElement(By.xpath(nameXpath))
                .getText();
        return name;
    }
}
