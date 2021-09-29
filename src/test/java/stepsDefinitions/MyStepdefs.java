package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseTest;

public class MyStepdefs extends BaseTest {

    String vendorCodeFromSearch;
    String itemsNameFromSearch;

    @Before
    public void setup() {
        openBrowser();
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Given("Open the Eldorado main page {string}")
    public void openTheEldoradoMainPage(String url) {
        open(url);
    }

    @And("Click on agree with city button")
    public void clickOnAgreeWithCityButton() {
        mainPage.clickOnAgreeWithCityButton();
    }

    @And("Enter search parameter {string}")
    public void enterSearchParameter(String searchParam) {
        mainPage.enterSearchParam(searchParam);
    }


    @And("Press enter button")
    public void pressEnterButton() {
        mainPage.pressEnterButton();
    }

    @When("Remember first found items vendor code and name")
    public void rememberFirstFoundItemsVendorCodeAndName() {
        vendorCodeFromSearch = searchPage.getFoundItemsVendorCode();
        itemsNameFromSearch = searchPage.getFoundItemsName();
    }

    @And("Add first item to the basket")
    public void addFirstItemToTheBasket() {
        searchPage.clickOnAddToBasketButton();
    }

    @And("Click on basket button")
    public void clickOnBasketButton() {
        searchPage.clickOnBasketButton();
    }

    @Then("Check that the item was added to the basket")
    public void checkThatTheItemWasAddedToTheBasket() {
        basketPage.checkItemAddedToBasket(vendorCodeFromSearch, itemsNameFromSearch);
    }

    @Given("Remove item from the basket")
    public void removeItemFromTheBasket() {
        basketPage.deleteItemFromBasket();
    }

    @Then("Item successfully removed from the basket")
    public void itemSuccessfullyRemovedFromTheBasket() {
        basketPage.checkItemDeletedFromBasket();
    }

}
