package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class sausedemoShopingBasketSteps {

    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() throws Throwable {
        WebDriver driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @When("^I log in with '(.*)' and password: (.*) in the website$")
    public void iLogInWithEachOfTheUsers(String user, String password) throws Throwable {
        SaucedemoLoginPage loginPage = new SaucedemoLoginPage(DriverFactory.getDriver());
        loginPage.typeUsername(user);
        loginPage.typePassword(password);
        loginPage.clickLoginButton();
    }

    @Then("^User is able to see (.*) product items with their images$")
    public void user_is_able_to_see_six_product_items_with_their_images(int numberOfProducts)  {
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        productsPage.assertLoginToProductPage();
        productsPage.assertNumberOfProducts(numberOfProducts);
        productsPage.assertAllProductsDisplayed();
        productsPage.assertAllImagesDisplayed();
    }

    @When("^I click add to cart button for item (.*)$")
    public void i_click_button_for_each_any_item(int itemNumber){
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        productsPage.clickAddToCartButton(itemNumber);
    }

    @Then("^The item is added to the shopping cart with quantity (.*)$")
    public void the_item_is_added_to_the_shopping_cart_with_quantity(String quantity){
        HeaderNavigationPage headerPage = new HeaderNavigationPage(DriverFactory.getDriver());
        headerPage.assertShoppingBadgeQuantity(quantity);
        headerPage.clickShoppingCartLink();
        ShoppingCartPage cartPage = new ShoppingCartPage(DriverFactory.getDriver());
        cartPage.assertNumberOfCartItems(1);
        cartPage.assertItemsQuantity(quantity);
    }

    @Then("^I can checkout successfully with correct total amount (.*) for item$")
    public void i_can_checkout_successfully_with_correct_total_amount(String amount) {
        ShoppingCartPage cartPage = new ShoppingCartPage(DriverFactory.getDriver());
        cartPage.clickCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutPage.typeFirstName("first");
        checkoutPage.typeLastName("last");
        checkoutPage.typePostalCode("1000");
        checkoutPage.clickContinueButton();
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(DriverFactory.getDriver());
        overviewPage.assertQuantity(amount);
        overviewPage.clickFinishButton();
        CheckoutCompletePage completePage = new CheckoutCompletePage(DriverFactory.getDriver());
        completePage.assertTextForSuccessfulOrder();
    }

    @Then("^In the shopping cart I can type quantity (.*) for the item$")
    public void inTheShoppingCartICanTypeQuantityForTheItem(String amount){
        HeaderNavigationPage headerPage = new HeaderNavigationPage(DriverFactory.getDriver());
        headerPage.clickShoppingCartLink();
        ShoppingCartPage cartPage = new ShoppingCartPage(DriverFactory.getDriver());
        cartPage.typeQuantity(amount);
        cartPage.assertItemsQuantity(amount);
    }

    @Then("^I am able to add all items to shopping cart with quantity (.*)$")
    public void iAmAbleToAddAllItemsToShoppingCartWithQuantity(String quantity){
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        productsPage.clickAllAddToCartButtons();
        HeaderNavigationPage headerPage = new HeaderNavigationPage(DriverFactory.getDriver());
        headerPage.clickShoppingCartLink();
        ShoppingCartPage cartPage = new ShoppingCartPage(DriverFactory.getDriver());
        cartPage.assertNumberOfCartItems(6);
        cartPage.assertItemsQuantity(quantity);
    }

    @And("^In the shopping cart I can type quantity (.*) for each item$")
    public void inTheShoppingCartICanTypeQuantityForEachItem(String quantity){
        ShoppingCartPage cartPage = new ShoppingCartPage(DriverFactory.getDriver());
        cartPage.typeQuantity(quantity);
        cartPage.assertItemsQuantity(quantity);
    }

    @Then("^The cart counter is correct displaying (.*)$")
    public void theCartCounterIsCorrect(String expectedQuantity){
        HeaderNavigationPage headerPage = new HeaderNavigationPage(DriverFactory.getDriver());
        headerPage.assertShoppingBadgeQuantity(expectedQuantity);
    }

    @And("^I remove the item from the cart and click continue shopping$")
    public void iRemoveTheItemFromTheCart() throws Throwable {
        HeaderNavigationPage headerPage = new HeaderNavigationPage(DriverFactory.getDriver());
        headerPage.clickShoppingCartLink();
        ShoppingCartPage cartPage = new ShoppingCartPage(DriverFactory.getDriver());
        cartPage.clickRemoveFirstItem();
        cartPage.clickContinueShoppinLink();
    }

    @Then("^The cart counter is not displayed$")
    public void theCartCounterIsNotDisplayed() throws Throwable {
        HeaderNavigationPage headerPage = new HeaderNavigationPage(DriverFactory.getDriver());
        headerPage.assertShoppingBadgeNotPresent();
    }

    @Then("^I add one by one all items verifying shopping cart counter on each adding$")
    public void iAddOneByOneAllItemsVerifyingShoppingCartCounterOnEachAdding(){
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        HeaderNavigationPage headerPage = new HeaderNavigationPage(DriverFactory.getDriver());
        for (int i = 0; i < productsPage.getNumberOfProducts(); i++){
            productsPage.clickFirstAddToCartButton();
            headerPage.assertShoppingBadgeQuantity(String.valueOf(i+1));
        }
    }

    @And("^I remove one by one all items from shopping cart verifying counter on each removing$")
    public void iRemoveOneByOneAllItemsFromShoppingCartVerifyingCounterOnEachRemoving(){
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        HeaderNavigationPage headerPage = new HeaderNavigationPage(DriverFactory.getDriver());
        ShoppingCartPage cartPage = new ShoppingCartPage(DriverFactory.getDriver());
        for (int i = productsPage.getNumberOfProducts(); i >1; i--){
            headerPage.clickShoppingCartLink();
            cartPage.clickRemoveFirstItem();
            headerPage.assertShoppingBadgeQuantity(String.valueOf(i-1));
        }
        cartPage.clickRemoveFirstItem();
        headerPage.assertShoppingBadgeNotPresent();
    }
}
