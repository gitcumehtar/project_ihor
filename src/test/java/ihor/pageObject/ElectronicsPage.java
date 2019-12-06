package ihor.pageObject;

import ihor.elements.Button;
import ihor.elements.DropdownList;
import ihor.elements.TextField;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static ihor.DriverManager.getDriver;

public class ElectronicsPage extends AbstractPage {

    private By showAsListBtn = By.xpath("(//a[@class='list'])[1]");
    private By showSelectionLst = By.xpath("(//select[@title='Results per page'])[1]");
    private By productInList = By.xpath("//div[@class='product-primary']");
    private By nextPgArrowBtn = By.xpath("//a[@title='Next'][1]");
    private By pagesNumber = By.xpath("//p[@class='amount amount--has-pages']");
    private By sortByDropDownList = By.xpath("//select[@title='Sort By']");
    private By item = By.xpath("//*[@id='products-list']/l");
    private By itemPrice = By.xpath("//div[@class='price-box']//span[@class='price']");
    private By priceSelection0_999 = By.xpath("(//a/span[@class='price']//..)[1]");
    private By priceSelection1000above = By.xpath("//a/span[@class='price']//..)[4]");

    @Getter
    private Button ShowAsList = new Button(showAsListBtn, "Show as list");

    @Getter
    private Button NextPgSmallArrowBtn = new Button(nextPgArrowBtn, "Next page arrow");

    @Getter
    private DropdownList ShowSelectionList = new DropdownList(showSelectionLst, "Show list");

    @Getter
    private TextField PagesAmount = new TextField(pagesNumber, "Show list");

    @Getter
    private DropdownList SortBy = new DropdownList(sortByDropDownList, "Sort by dropdown list");

    @Getter
    private TextField ItemPrice = new TextField(itemPrice, "Price of a product");

    @Getter
    private Button PriceSelectionFilterOne = new Button(priceSelection0_999, "Price selection from 0 - 999");

    @Getter
    private Button PriceSelectionFilterTwo = new Button(priceSelection1000above, "Price selection from 0 - 999");

    @Step
    public ElectronicsPage clickShowAsList() {
        ShowAsList.click();
        return this;
    }

    @Step
    public ElectronicsPage clickShowDropDown(String value) {
        ShowSelectionList.select(value);
        return this;
    }

    @Step
    public int getProductsNumber() {
        List <WebElement> welist = getDriver().findElements(productInList);
        return welist.size();
    }

    @Step
    public ElectronicsPage clickPriceFilter(String filter) {
        switch (filter) {
            case "0-999":
                PriceSelectionFilterOne.click();
                break;
            case "1.000.000 and above":
                PriceSelectionFilterTwo.click();
                break;
        }
        return this;
    }

    public void checkNumbersOfItemsOnEachPage(int expectedItems) {
        int pageNumber = 1;
        do {
            if (pageNumber != 1)
                NextPgSmallArrowBtn.click();
            //Counts items on the page
            int numberOfItems = getDriver().findElements(item).size();
            if (NextPgSmallArrowBtn.isExists(1)) {
                Assert.assertEquals(numberOfItems, expectedItems,
                        String.format("Expect %s items, but found %s items on page %s", expectedItems, numberOfItems, pageNumber));
            } else {
                Assert.assertTrue(numberOfItems <= expectedItems,
                        String.format("Expect not more than %s items, but found %s items on page %s", expectedItems, numberOfItems, pageNumber));
            }

            pageNumber++;
        } while (NextPgSmallArrowBtn.isExists(1));
    }

    public enum SortBy {
        POSITION("Position"),
        NAME("Name"),
        PRICE("Price");
        private String text;
        SortBy(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
//    public ElectronicsPage setSortBy(SortBy SortBy) {
//        SortBy.select(SortBy.toString());
//        return this;
//    }
    // Check prices sorted from low to high
    public void checkSortedPrices() {
        List<WebElement> eltList = getDriver().findElements(itemPrice);
        for (int i = 0; i < eltList.size() - 1; i++) {
            double priceCurrent =
                    Double.parseDouble(eltList.get(i).getText());
            double priceNext = Double.parseDouble(eltList.get(i + 1).getText());
            Assert.assertTrue(priceNext > priceCurrent,
                    String.format("Expect price %s of next item bigger than price %s of current item", priceNext, priceCurrent));
        }
    }
    //Check prices < 100
    public void checkPricesValues() {
        List <WebElement> eltList = getDriver().findElements(priceSelection0_999);
        for (WebElement e : eltList) {
            double price = Double.parseDouble(e.getText());
            Assert.assertTrue(price < 100.00, String.format("Price %s less than 100", price));
        }
    }
    public ElectronicsPage addRandomProductToWishList(){
        Random randomGenerator = new Random();
        List <WebElement> weList = getDriver().findElements(item);
        int numOfItems = weList.size();
        int i = randomGenerator.nextInt(numOfItems);

//TODO: weList.get(i).clickAddToWishListBtn()
        return this;
    }
}