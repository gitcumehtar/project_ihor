package ihor.tests;

import ihor.pageObject.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemsCounterTest extends BaseTest{

    @Test (description = "Number of present items is equal to the counter")
    public void itemsCounter() {
        MainPage mainPage = new MainPage();

        int num = mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25").getProductsNumber();

        Assert.assertEquals(num,12,"Number of products is 12");
    }
}






}
