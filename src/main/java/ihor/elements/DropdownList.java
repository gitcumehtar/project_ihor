package ihor.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropdownList extends TextField{
        public DropdownList(By locator, String description) {
        super(locator, description);
    }

    @Step ("select by id")
    public void select(int id){
        getSelectElement().selectByIndex(id);
    }

    @Step ("select by text")
    public void select(String text){
        getSelectElement().selectByVisibleText(text);
    }

    private Select getSelectElement(){
        return new Select(get());
    }

    public void click(){
        get().click();
    }
}
