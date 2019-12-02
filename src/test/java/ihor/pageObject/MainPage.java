package ihor.pageObject;

import ihor.elements.Button;
import ihor.elements.DropdownList;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static ihor.DriverManager.getDriver;


public class MainPage {

    private By languageDropDownLst = By.xpath("//select[@id='select-language']");
    private By homeAndDecorBtn = By.xpath(" //a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronicsSubMenu = By.xpath("//a[contains(text(),'Electronics')]");

    @Getter
    private DropdownListownList LanguageDropDown = new DropdownList()ownList(languageDropDownLst, "Language dropdown list");

    @Getter
    private Button HomeAndDecor = new Button(homeAndDecorBtn, "HOME&DECOR");

    @Getter
    private Button ElectronicsSubMenu = new Button(electronicsSubMenu, "HOME&DECOR - Electronics");


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
        getLanguageDropDown().select(language.toString());
        return this;
    }

    @Step
    public MainPage focusHomeAndDecorMenu() {
        getHomeAndDecor().setFocusOn();
        return this;
    }

    //Q1: Is it correct? - class will have giant num of methods.
    //Q2: How to call Electronics only in Home & Decor context --> clickHomeAndDecorMenu().selectItem("Electronics")

    public Electronics clickOnElectronicsItem() {
        getElectronicsSubMenu().click();
        return new Electronics();
    }


}

