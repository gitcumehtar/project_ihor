package ihor.tests;

import ihor.pageObject.MainPage;
import org.testng.annotations.Test;

public class SalePageTest extends BaseTest{

    @Test(description = "Check 'Old and 'Sale' prices in SALE")
    public void checkSale() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .clickOnSale()
                .clickgridView()
                .clickShowDropDown("36")
                .comparePrices();
    }

}
