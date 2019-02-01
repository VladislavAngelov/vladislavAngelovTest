package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductsPage extends BasePage {


    @FindBy(className = "product_label")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List <WebElement> products;

    @FindBy(tagName = "img")
    private List <WebElement> productImages;

    @FindBy(css = "button.add-to-cart-button")
    private List<WebElement> addToCartButtons;


    public ProductsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    /**
     * assert that the user is at product page
     */
    public void assertLoginToProductPage(){
        try {
            String expectedTitle = "Products";
            String title = pageTitle.getText();
            Assert.assertEquals(expectedTitle, title);
        } catch (Exception error){
            Assert.fail("The user is not logged in to Products page");
        }

    }


    /**
     * assert that all products are displayed
     */
    public void assertAllProductsDisplayed(){
        for (int i = 0; i < products.size(); i++){
            WebElement product = products.get(i);
            Assert.assertTrue(product.isDisplayed());
        }
    }

    /**
     * assert expected number of products
     * @param expectedNumber
     */
    public void assertNumberOfProducts(int expectedNumber ){
        Assert.assertEquals(expectedNumber, products.size());
    }

    /**
     * assert that images are displayed
     */
    public void assertAllImagesDisplayed(){
        for (int i = 0; i < productImages.size(); i++){
            WebElement image = productImages.get(i);
            String src = image.getAttribute("src");
            Assert.assertTrue("Image is not displayed", !(src.contains("jpgWithGarbageOnItToBreakTheUrl")));
        }
    }

    /**
     * return int value for number of products
     * @return
     */
    public int getNumberOfProducts (){
        int numberOfProducts = products.size();
        return numberOfProducts;
    }

    /**
     * click add to cart button for specified by parameter item
     * @param productNumber
     */
    public void clickAddToCartButton (int productNumber){
        WebElement addToCartButton;
        if (addToCartButtons.size() > 0) {
            addToCartButton = addToCartButtons.get(productNumber - 1);
            addToCartButton.click();
            waitForPageToBeLoaded(DriverFactory.getDriver(), 30);
        } else {
            Assert.fail("WebElement addToCartButton is not found");
        }
    }

    /**
     * click add to cart button of the first item
     */
    public void clickFirstAddToCartButton(){
        addToCartButtons.get(0).click();
        waitForPageToBeLoaded(DriverFactory.getDriver(),5);
    }

    /**
     * click add to cart button for all items
     */
    public void clickAllAddToCartButtons (){
        int numberOfButtons = addToCartButtons.size();
        for (int i = 0; i < numberOfButtons; i++){
            WebElement addToCart = addToCartButtons.get(0);
            addToCart.click();
            waitForPageToBeLoaded(DriverFactory.getDriver(),5);
        }
    }
}
