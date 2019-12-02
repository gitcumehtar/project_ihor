package ihor.pageObject;

import org.openqa.selenium.JavascriptExecutor;

import static ihor.DriverManager.getDriver;

public class AbstractPage {

    public AbstractPage(){

        //close banner
        ((JavascriptExecutor)getDriver()).executeScript("document.getElementById('close-fixedban').click()");
    }
}
