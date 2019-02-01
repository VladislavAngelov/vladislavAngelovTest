package pageObjects;

import driver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoSuchElementException;



public class HeaderNavigationPage extends BasePage {

    @FindBy(tagName = "path")
    private WebElement shopingCartLink;


    @FindBy(css = ".fa-layers-counter")
    private WebElement shopingCartBadge;


    /**
     * class constructor
     * @param driver
     */
    public  HeaderNavigationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    /**
     * click shopping cart link
     */
    public void clickShoppingCartLink(){
        shopingCartLink.click();
        waitForPageToBeLoaded(DriverFactory.getDriver(),30);
    }

    /**
     * assert quantity in shopping cart counter
     * @param expectedQuantity
     */
    public void assertShoppingBadgeQuantity (String expectedQuantity){
        String badgeQuantity = shopingCartBadge.getText();
        Assert.assertEquals(expectedQuantity, badgeQuantity);
    }

    /**
     * return true if element present
     * @return
     */
    public boolean isShoppingBadgePresent(){
        try {
            shopingCartBadge.getText();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * assert shopping cart counter not present
     */
    public void assertShoppingBadgeNotPresent(){
        boolean isFound = isShoppingBadgePresent();
        Assert.assertTrue(!isFound);
    }

}
