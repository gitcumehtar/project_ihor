package ihor.tests;

import ihor.pageObject.ElectronicsPage;
import ihor.pageObject.MainPage;
import org.testng.annotations.Test;

public class SortByTest extends BaseTest {

    @Test(description = "Price of each next item is higher than of the previous item")
    public void sortBy() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                //.setSortBy(ElectronicsPage.SortBy.PRICE)
                .checkSortedPrices();

    }
}

