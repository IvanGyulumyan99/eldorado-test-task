package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitElement;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "//li[@class = 'ZD']//div[@class = 'cE']//button[@class = 'WJ']")
    private WebElement addToTheBasketButton;
    @FindBy(xpath = "//li[@class = 'ZD']//div[@data-dy='productsList']//span")
    private WebElement firstFoundItemsVendorCode;
    @FindBy(xpath = "//li[@class = 'ZD']//a[@class = 'fE']")
    private WebElement firstFoundItemsName;
    @FindBy(xpath = "//a[contains(@class, 'bi ci')]")
    private WebElement basketButton;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFoundItemsVendorCode() {
        return WaitElement.waitVisibilityOf(driver, firstFoundItemsVendorCode).getText();
    }

    public String getFoundItemsName() {
        return WaitElement.waitVisibilityOf(driver, firstFoundItemsName).getText();
    }

    public SearchPage clickOnAddToBasketButton() {
        WaitElement.waitToBeClickable(driver, addToTheBasketButton).click();
        return this;
    }

    public SearchPage clickOnBasketButton() {
        WaitElement.waitToBeClickable(driver, basketButton).click();
        return this;
    }
}
