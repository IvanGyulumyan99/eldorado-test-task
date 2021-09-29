import org.junit.jupiter.api.Test;
import utils.BaseTest;

public class EldoradoTest extends BaseTest {

    @Test
    public void basketTest() throws InterruptedException {
        mainPage.clickOnAgreeWithCityButton()
                .enterSearchParam("Iphone")
                .clickSearchButton();

        String vendorCodeFromSearch = searchPage.getFoundItemsVendorCode();
        String itemsNameFromSearch = searchPage.getFoundItemsName();

        searchPage.clickOnAddToBasketButton()
                .clickOnBasketButton();

        basketPage.checkItemAddedToBasket(vendorCodeFromSearch, itemsNameFromSearch)
                .deleteItemFromBasket()
                .checkItemDeletedFromBasket();
    }
}
