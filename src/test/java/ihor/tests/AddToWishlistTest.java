package ihor.tests;

import ihor.pageObject.MainPage;
import org.testng.annotations.Test;

public class AddToWishlistTest extends BaseTest {

    @Test(description = "Wishlist opens and name of item is present")
    public void addToWishlist() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .clickAccount()
                .clickLogIn()
                .fillEmailField("cumehtar@gmail.com")
                .fillPasswordField("qwerty")
                .clickLoginbtn()
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25");
        //TODO: chooseRandomItem{}
        //TODO: clickAddToWish()
        //TODO: check WISHLIST
    }
}




}
