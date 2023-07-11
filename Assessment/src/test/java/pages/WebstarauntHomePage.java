package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtil;
import utilities.DriverUtil;

public class WebstarauntHomePage extends BrowserUtil {

    public WebstarauntHomePage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    @FindBy(id = "searchval")
    private WebElement searchBox;

    @FindBy(css = "button[value='Search']")
    private WebElement searchButton;

    public void enterSearch(String searchTerm) {
        searchBox.sendKeys("stainless work table");
    }

    public void pressSearchButton(){
        searchButton.click();
    }

}
