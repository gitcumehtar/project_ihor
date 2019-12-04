package ihor.pageObject;

import ihor.elements.Button;
import ihor.elements.DropdownList;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

public class MainPage {
    private By languageDropDownLst = By.xpath("//select[@id='select-language']");
    private By homeAndDecorBtn = By.xpath(" //a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronicsSubMenu = By.xpath("//a[contains(text(),'Electronics')]");
    private By accountBtn = By.xpath("//span[@class='label'][(contains(text(),'Account'))]");
    private By logInBtn = By.xpath("//div[@class='links']//a[@title='Log In']");
    private By saleBtn = By.xpath("//a[contains(text(),'Sale')]");

    @Getter
    private DropdownList LanguageDropDown = new DropdownList(languageDropDownLst, "Language dropdown list");

    @Getter
    private Button HomeAndDecor = new Button(homeAndDecorBtn, "Main menu HOME&DECOR");

    @Getter
    private Button ElectronicsSubMenu = new Button(electronicsSubMenu, "HOME&DECOR - Electronics");

    @Getter
    private Button Account = new Button(accountBtn, "ACCOUNT button");

    @Getter
    private Button Login = new Button(logInBtn, "ACCOUNT -> LogIn button");

    @Getter
    private Button Sale = new Button(saleBtn, "Main menu SALE");


    // enums for Your Language menu
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
        getLanguageDropdown().select(language.toString());
        return this;
    }

    @Step
    public MainPage focusHomeAndDecorMenu() {
        getHomeAndDecor().setFocusOn();
        return this;
    }

    @Step
    public ElectronicsPage clickOnElectronicsItem() {
        getElectronicsSubMenu().click();
        return new ElectronicsPage();
    }

    @Step
    public SalePage clickOnSale() {
        getSale().click();
        return new SalePage();
    }

    @Step
    //TODO: Q: Move this to AbstractPage?
    public MainPage clickAccount(){
        getAccount().click();
        return this;
    }

    @Step
    public LoginPage clickLogIn(){
        getLogin().click();
        return new LoginPage();
    }
}
