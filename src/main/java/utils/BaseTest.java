package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasketPage;
import pages.MainPage;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected static WebDriver driver;
    protected MainPage mainPage;
    protected SearchPage searchPage;
    protected BasketPage basketPage;

    public void openBrowser() {
        configureWebDriver();
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        basketPage = new BasketPage(driver);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void open(String url) {
        driver.get(url);
    }

    private void configureWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}