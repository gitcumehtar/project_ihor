package ihor.pageObject;

import ihor.elements.Button;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.Assertion;

import static ihor.DriverManager.getDriver;

public class AbstractPage {
    protected Assertion softAssert = new Assertion();
    private By accountBtn = By.xpath("//span[@class='label'][(contains(text(),'Account'))]");
    private By loginBtn = By.xpath("//div[@class='links']//a[@title='Log In']");

    @Getter
    private Button Account = new Button(accountBtn, "Account Button");

    @Getter
    private Button Login = new Button(loginBtn, "Account to Login Button");

    public AbstractPage(){

        //close banner
        ((JavascriptExecutor)getDriver()).executeScript("document.getElementById('close-fixedban').click()");
    }

}
