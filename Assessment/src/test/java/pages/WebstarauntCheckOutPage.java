package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtil;
import utilities.DriverUtil;

public class WebstarauntCheckOutPage extends BrowserUtil {
// page factory to call driver util, store our web elements and methods here
    public WebstarauntCheckOutPage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    @FindBy(css = "button.emptyCartButton")
    private WebElement firstEmptyCartButton;

    @FindBy(css = "footer button[type='button']")
    private WebElement secondEmptyCartButton;

    @FindBy(css = "p.header-1")
    private WebElement emptyCartVerification;

    public void clickFirstEmptyCartButton(){
        firstEmptyCartButton.click();
    }

    public void clickSecondEmptyCartButton(){
        secondEmptyCartButton.click();
    }

    public void verifyCartIsEmpty(){
        if (emptyCartVerification.isDisplayed()){
            System.out.println("Cart is empty, test successful");
        }else {
            System.out.println("Cart was not emptied, test failed");
        }
    }


}
