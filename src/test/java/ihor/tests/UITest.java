package ihor.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UITest {

    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe/");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        driver.get("http://magento.mainacad.com/");
        //driver.findElement(By.id("xxx").sendKeys("xxx");
        //driver.findElement(By.cssSelector("yyy")).click();
        //WebElement lang = driver.findElement(By.id("zzz"));
        Select lang = new Select(driver.findElement(By.id("select-language")));
        lang.selectByVisibleText("Automation");
    }

    @After
    public void closeUp() {
        driver.quit();
    }


}
