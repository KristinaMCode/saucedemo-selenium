package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.InventoryPage;
import utils.DriverFactory;
import utils.TestData;

public class InventorySteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final InventoryPage inventoryPage = new InventoryPage(driver);
    private final CartPage cartPage = new CartPage(driver);

    @Then("the header is displayed")
    public void theHeaderIsDisplayed() {
        Assert.assertEquals(inventoryPage.getLogoText(), TestData.LOGO_TEXT);
        Assert.assertTrue(inventoryPage.isMenuButtonDisplayed());
        Assert.assertTrue(inventoryPage.isCartDisplayed());
    }
    @When("user opens the cart")
    public void userOpensCart() {
        inventoryPage.openCart();
        cartPage.waitUntilLoaded();
    }

    @Then("the cart page is displayed")
    public void theCartPageIsDisplayed(){
        Assert.assertEquals(cartPage.getTitle(), TestData.CART_TEXT);
    }
    @When("user adds {string} to the cart")
    public void userAddsItemToCart(String items) {
        for (String item : items.split(",\\s*")) {
            inventoryPage.addToCart(item);
        }    }


    @Then("the cart badge shows {string}")
    public void userVerifiesNumberOfItemsInCart(String number) {
        Assert.assertEquals(inventoryPage.getNumberOfItemInCart(), number);
    }

}
