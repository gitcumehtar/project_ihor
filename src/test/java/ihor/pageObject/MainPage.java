package ihor.pageObject;

import ihor.elements.BaseElement;
import ihor.elements.Button;
import ihor.elements.DropdownList;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

public class MainPage {
    private By languageMenu = By.xpath("//select[@id='select-language']");
    private By homeAndDecorBtn = By.xpath(" //a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronicsMenu = By.xpath("//a[contains(text(),'Electronics')]");
    private By saleBtn = By.xpath("//a[contains(text(),'Sale')]");
    private By accountBtn = By.xpath("//span[@class='label'][(contains(text(),'Account'))]");
    private By loginBtn = By.xpath("//div[@class='links']//a[@title='Log In']");

    @Getter
    DropdownList LanguageDropdown = new DropdownList(languageMenu, "Language dropdown list");

    @Getter
    Button HomeAndDecor = new Button(homeAndDecorBtn, "Main menu HOME&DECOR");

    @Getter
    Button ElectronicsSubMenu = new Button(electronicsMenu, "HOME&DECOR - Electronics");

    @Getter
    Button Sale = new Button(saleBtn, "Main menu SALE");

    @Getter
    private Button Account = new Button(accountBtn, "Account Button");

    @Getter
    private Button Login = new Button(loginBtn, "Account to Login Button");


    public enum Language {
        AUTOMATION("Automation"),
        ENGLISH("English");

        private String text;
        Language(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    @Step
    public MainPage setLanguage(Language language) {
        LanguageDropdown.select(language.toString());
        return this;
    }

    @Step
    public MainPage focusHomeAndDecorMenu() {
        HomeAndDecor.setFocusOn();
        return this;
    }

    @Step
    public ElectronicsPage clickOnElectronicsItem() {
        ElectronicsSubMenu.click();
        return new ElectronicsPage();
    }

    @Step
    public SalePage clickOnSale() {
        Sale.click();
        return new SalePage();
    }

    @Step
    public MainPage clickAccount(){
        Account.click();
        return new MainPage();
    }

    @Step
    public LoginPage clickLogIn(){
        Login.click();
        return new LoginPage();
    }


}
