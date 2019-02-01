package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(css = "input[data-test='firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "input[data-test='lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "input[data-test='postalCode']")
    private WebElement postalCodeInput;

    @FindBy(css = "input[type='submit']")
    private WebElement continueButton;

    @FindBy(className = "cart_cancel_link")
    private WebElement canselButton;


    /**
     * class constructor
     * @param driver
     */
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * type first name
     * @param firstName
     */
    public void typeFirstName (String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    /**
     * type last name
     * @param lastName
     */
    public void typeLastName (String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    /**
     * type postal code
     * @param postalCode
     */
    public void typePostalCode (String postalCode){
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    /**
     * click continue button
     */
    public void clickContinueButton (){
        continueButton.click();
        waitForPageToBeLoaded(DriverFactory.getDriver(),30);
    }

    /**
     * click cancel button
     */
    public void clickCancelButton (){
        canselButton.click();
        waitForPageToBeLoaded(DriverFactory.getDriver(),30);
    }

}
