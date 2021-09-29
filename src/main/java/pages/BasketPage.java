package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitElement;

public class BasketPage {
    WebDriver driver;

    @FindBy(xpath = "//span[@class = 'empty-basket-one']")
    private WebElement emptyBasketText;
    @FindBy(xpath = "//div[contains(@class, 'basketBlockCels basketBlockCels_wish')]//span[@class = 'q-basketBlockClouser-button no-mobile']")
    private WebElement deleteItemFromBasket;
    @FindBy(xpath = "//a[contains(@class, 'q-basketBlockCels_nameProdItemLink')]")
    private WebElement itemsNameFromBasket;
    @FindBy(xpath = "//div[contains(@class, 'q-basketBlockCelsContainerRight')]//div[@class = 'basketBlockCels_sku']")
    private WebElement itemsVendorCodeFromBasket;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String getVendorCodeFromBasket() {
        return WaitElement.waitVisibilityOf(driver, itemsVendorCodeFromBasket).getText();
    }

    private String getItemsNameFromBasket() {
        return WaitElement.waitVisibilityOf(driver, itemsNameFromBasket).getText();
    }

    public BasketPage checkItemAddedToBasket(String vendorCodeFromSearch, String itemsNameFromSearch) {
        Assertions.assertEquals(vendorCodeFromSearch.substring(4), getVendorCodeFromBasket().substring(5),
                "Vendor codes not equals");
        Assertions.assertEquals(itemsNameFromSearch, getItemsNameFromBasket(),
                "Items names not equals");
        return this;
    }

    public BasketPage deleteItemFromBasket() {
        WaitElement.waitToBeClickable(driver, deleteItemFromBasket).click();
        driver.navigate().refresh();
        return this;
    }

    public BasketPage checkItemDeletedFromBasket() {
        Assertions.assertTrue(emptyBasketText.isDisplayed(), "Item is not deleted");
        return this;
    }


}
