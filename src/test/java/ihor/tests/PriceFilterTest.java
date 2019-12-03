package ihor.tests;

import ihor.pageObject.MainPage;
import org.testng.annotations.Test;

public class PriceFilterTest extends BaseTest {

    @Test(description = "Price of all items is less than 100")
    public void priceFilter() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .clickPriceFilter("0-999")
                .checkPricesValues();
    }
}



}
