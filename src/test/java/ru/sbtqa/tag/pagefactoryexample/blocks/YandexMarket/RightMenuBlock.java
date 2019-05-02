package ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.PageWrapper;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactoryexample.pages.YandexMarket.YmSearchResultsPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Правое Меню")
@FindBy(css = ".layout__col_search-filters_visible")
public class RightMenuBlock extends HtmlElement {

    @ElementTitle("Имя производителя")
    @FindBy(xpath = "//*[contains(text(), 'Производитель')]/ancestor::div[contains(@class,'n-filter-cookie')]//input")
    public TextInput vendorAutoSuggest;
    @ElementTitle("Цена Макс")
    @FindBy(xpath = ".//*[@name='glf-priceto-var']")
    public TextInput maxPrice;
    @ElementTitle("Цена Мин")
    @FindBy(xpath = ".//*[@name='glf-pricefrom-var']")
    public TextInput minPrice;
    @ElementTitle("HP")
    @FindBy(xpath = ".//label[text()='HP']/ancestor::a")
    public TextInput hpCheckBox;
    @ElementTitle("Acer")
    @FindBy(xpath = ".//label[text()='Acer']/ancestor::a")
    public TextInput acerCheckBox;
    @ElementTitle("DELL")
    @FindBy(xpath = ".//label[text()='DELL']/parent::span")
    public TextInput dellCheckBox;
    @ElementTitle("Lenovo")
    @FindBy(xpath = ".//label[text()='Lenovo']/ancestor::a")
    public TextInput lenovoCheckBox;
    @ElementTitle("Показать всё")
    @FindBy(xpath = "//span[text()='Показать всё']/parent::button")
    public TextInput showAll;
    @ElementTitle("Свернуть")
    @FindBy(xpath = "//span[text()='Свернуть']/parent::button")
    public TextInput collapse;
    @RedirectsTo(page = YmSearchResultsPage.class)
    @ElementTitle("Применить")
    @FindBy(xpath = "//span[text()='Применить']/parent::button")
    public Button setButton;
    private PageWrapper pageFactory = PageFactory.getInstance();

    @ActionTitle("устанавливает максимальную цену")
    public void setMaxPrice(String price) {
        maxPrice.sendKeys(price);
    }

    @ActionTitle("устанавливает минимальную цену")
    public void setMinPrice(String price) {
        minPrice.sendKeys(price);
    }

    @ActionTitle("нажимает элемент")
    public void click(String name) throws PageException {
        pageFactory.getCurrentPage().findElementInBlockByTitle("Правое Меню", name).click();
        waitForLoad();
    }

    @ActionTitle("ищет производителя")
    public void searchForVendor(String name) throws PageException {
        vendorAutoSuggest.sendKeys(name);
        waitForLoad();
    }

    void waitForLoad() throws PageException {
//        new WebDriverWait(PageFactory.getDriver(), 30)
//                .until(ExpectedConditions.refreshed(ExpectedConditions
//                        .visibilityOfAllElementsLocatedBy(By.cssSelector(".n-snippet-card2__part"))));

//        new WebDriverWait(PageFactory.getDriver(), 30).until((ExpectedCondition<Boolean>) wd ->
//                ((JavascriptExecutor) wd).executeScript("return (document.readyState == 'complete' && jQuery.active == 0)").equals(true));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}