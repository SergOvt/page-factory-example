package ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.PageFactory;

/**
 * Created by e.perceva on 28.10.2017.
 */
public interface AbstractPage {
    default void isPageLoaded() {
        new WebDriverWait(PageFactory.getDriver(), 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return (document.readyState == 'complete' && jQuery.active == 0)").equals(true));
    }
}
