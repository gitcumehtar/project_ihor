package ihor.tests;

import ihor.pageObject.MainPage;
import org.testng.annotations.Test;

public class ShowSelectTest extends BaseTest{

    @Test(description = "Only 5 items are shown on each page")
    public void  showSelect(){
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("5")
                .checkNumbersOfItemsOnEachPage(5);
    }
}


