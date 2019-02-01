package pageObjects;

import driver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    @FindBy(className = "cart_cancel_link")
    private WebElement continueShoppingLink;

    @FindBy(className = "cart_checkout_link")
    private WebElement checkoutLink;

    @FindBy(className = "remove-from-cart-button")
    private List<WebElement> removeButtons;

    @FindBy(className = "cart_quantity")
    private List<WebElement> quantityField;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    /**
     * class constructor
     * @param driver
     */
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * type quantity for all listed items
     * @param quantity
     */
    public void typeQuantity (String quantity){
        for(int i = 0; i < quantityField.size(); i++){
            WebElement field = quantityField.get(i);
            field.clear();
            field.sendKeys(quantity);
        }
    }

    /**
     * assert quantity for all listed items
     * @param expectedQuantity
     */
    public void assertItemsQuantity(String expectedQuantity){
        for(int i = 0; i < quantityField.size(); i++){
            WebElement field = quantityField.get(i);
            String quantity = field.getText();
            Assert.assertEquals(expectedQuantity, quantity);
        }
    }

    /**
     * assert the number of listed items
     * @param expectedNumber
     */
    public void assertNumberOfCartItems (int expectedNumber){
        Assert.assertTrue(expectedNumber + "item(s) not found in shopping cart",expectedNumber == cartItems.size());
    }

    /**
     * click checkout link
     */
    public void clickCheckout (){
        checkoutLink.click();
        waitForPageToBeLoaded(DriverFactory.getDriver(),30);
    }

    /**
     * click remove button for the first listed item
     */
    public void clickRemoveFirstItem(){
        removeButtons.get(0).click();
        waitForPageToBeLoaded(DriverFactory.getDriver(),5);
    }


    /**
     * click continue shopping link
     */
    public void clickContinueShoppinLink(){
        continueShoppingLink.click();
        waitForPageToBeLoaded(DriverFactory.getDriver(),5);
    }
}
