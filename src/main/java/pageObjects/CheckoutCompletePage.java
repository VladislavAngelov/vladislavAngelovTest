package pageObjects;

import driver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {
    @FindBy(className = "complete-header")
    private WebElement pageHeader;

    /**
     * class constructor
     * @param driver
     */
    public CheckoutCompletePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    /**
     * assert page header after finished order
     */
    public void assertTextForSuccessfulOrder (){
        String expectedText = "THANK YOU FOR YOUR ORDER";
        String actualText = pageHeader.getText();
        Assert.assertEquals(expectedText, actualText);
    }
}
