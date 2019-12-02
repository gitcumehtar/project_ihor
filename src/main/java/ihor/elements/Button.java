package ihor.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Button extends TextField {

    public Button(By locator, String description) {
        super(locator, description);
    }

    @Step
    public void click(){
        get().click();
    }
}