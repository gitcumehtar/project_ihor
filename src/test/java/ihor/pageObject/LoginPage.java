package ihor.pageObject;

import ihor.elements.Button;
import ihor.elements.InputField;
import ihor.elements.TextField;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static ihor.DriverManager.getDriver;

public class LoginPage extends AbstractPage{

    private By emailField = By.xpath("//input[@type='email'][@title='Email Address']");
    private By passwordField = By.xpath("//input[@type='password'][@title='Password']");
    private By loginBtn = By.xpath("//button[@title='Login']");

    @Getter
    public InputField Email = new InputField(emailField,"Email field");

    @Getter
    public InputField Password = new InputField(passwordField,"Password field");

    @Getter
    public Button Login = new Button(loginBtn,"Login");

    @Step
    public LoginPage fillEmailField(String email){
        getEmail().setText(email);
        Assert.assertEquals(email, Email.getText(), String.format("Expected email %s but entered was %s", email, Email.getText()));
        return this;
    }

    @Step
    public LoginPage fillPasswordField(String password){
        getPassword().setText(password);
        Assert.assertEquals(password.length(), Password.getText().length(), "Check password");
        return this;
    }

    @Step
    public MainPage clickLoginbtn(){
        getLogin().click();
        return new MainPage();
    }


}
