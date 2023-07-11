package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtil;
import utilities.DriverUtil;

import java.util.List;

public class WebstarauntSearchResultsPage extends BrowserUtil {

    public WebstarauntSearchResultsPage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    @FindBy(css = "span[data-testid='itemDescription']")
    private List<WebElement> searchResults;

    @FindBy(name = "addToCartButton")
    private List<WebElement> addToCartButtonsList;

    @FindBy(css = "a[href='/viewcart.cfm']")
    private WebElement viewCartButton;

    public void verifyTitle(){
        for (WebElement searchResult : searchResults) {
            // get the text of every search result item description
            String title = searchResult.getText();
            // if statement to verify all search result item descriptions contain the word "Table", toLowerCase to make 'Table' case-insensitive
            if (title.toLowerCase().contains("table")) {
                System.out.println("Title contains Table: " + title);
            } else {
                System.out.println("Title does not contain Table: " + title);
            }
        }

    }


    public void clickLast3AddToCartButtons(){
        // number of add to cart buttons that will be clicked
        int lastThreeItems = 3;
        // total number of add to cart buttons in the list
        int totalItems = addToCartButtonsList.size();
        // isolate last 3 indexes in list, Math.max and 0 to ensure first index is maximum value and positive
        int firstIndex = Math.max(totalItems - lastThreeItems, 0);
        // identifies last index of list
        int lastIndex = totalItems - 1;

        // iterates over set index range and clicks add to cart button
        for (int i = firstIndex; i <= lastIndex; i++) {
            WebElement addToCartButton = addToCartButtonsList.get(i);
            addToCartButton.click();
        }

    }

    public void clickViewCartButton(){
        viewCartButton.click();
    }


}
