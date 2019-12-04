package ihor.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InputField extends TextField {
    public InputField(By locator, String description) {
        super(locator, description);
    }

    @Step
    public void setText(String text){
        get().sendKeys(text);
    }

    @Step
    public void clear(){
        get().clear();
    }

}