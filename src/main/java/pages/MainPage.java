package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitElement;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'Hq']//button[@class = 'Kq Lq']")
    private WebElement agreeWithCityButton;
    @FindBy(xpath = "//input[@name = 'search']")
    private WebElement productSearchField;
    @FindBy(xpath = "//div[@class = 'sr']//button[@type = 'submit']")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage enterSearchParam(String searchParam) {
        WaitElement.waitToBeClickable(driver, productSearchField).click();
        WaitElement.waitVisibilityOf(driver, productSearchField).sendKeys(searchParam);
        return this;
    }

    public MainPage clickOnAgreeWithCityButton() {
        WaitElement.waitToBeClickable(driver, agreeWithCityButton).click();
        return this;
    }

    public MainPage clickSearchButton() {
        WaitElement.waitToBeClickable(driver, searchButton).click();
        return this;
    }

}
