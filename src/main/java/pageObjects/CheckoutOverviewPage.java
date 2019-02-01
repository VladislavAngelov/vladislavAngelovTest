package pageObjects;

import driver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CheckoutOverviewPage extends BasePage {
    @FindBy(className = "summary_quantity")
    private List<WebElement> itemsQuantity;

    @FindBy(className = "cart_checkout_link")
    private WebElement finishButton;

    /**
     * class constructor
     * @param driver
     */
    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    /**
     * assert quantity for all listed items
     * @param expectedQuantity
     */
    public void assertQuantity(String expectedQuantity){
        for(int i = 0; i < itemsQuantity.size(); i++){
            if (itemsQuantity.size() > 0){
                WebElement quantityHolder = itemsQuantity.get(i);
                String actualQuantity = quantityHolder.getText();
                Assert.assertEquals(expectedQuantity, actualQuantity);
            }else {
                Assert.fail("WebElement itemsQuantity is not found");
            }
        }
    }

    /**
     * click finish button
     */
    public void clickFinishButton(){
        finishButton.click();
        waitForPageToBeLoaded(DriverFactory.getDriver(),30);
    }
}
