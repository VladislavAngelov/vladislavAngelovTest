package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoLoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "login-button")
    private WebElement loginButton;

    /**
     * class constructor
     * @param driver
     */
    public SaucedemoLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * type in user name field
     * @param username
     */
    public void typeUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    /**
     * type in password field
     * @param password
     */
    public void typePassword (String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /**
     * click login button
     */
    public void clickLoginButton (){
        loginButton.click();
        waitForPageToBeLoaded(DriverFactory.getDriver(), 30);

    }

}
