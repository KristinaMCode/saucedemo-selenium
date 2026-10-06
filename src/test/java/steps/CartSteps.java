package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.internal.junit.ArrayAsserts;
import pages.CartPage;
import utils.DriverFactory;

public class CartSteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final CartPage cartPage = new CartPage(driver);

    @Then("user verifies {string} is in the cart")
    public void userVerifiesItemIsInCart(String item){
        Assert.assertEquals(cartPage.getItemName(),item);
    }

    @Then("the cart page header shows {string} item")
    public void theCartPAgeHeaderShowsNumberOfItem(String numberOfItems){
        Assert.assertEquals(cartPage.getNumberOfItemInCart(),numberOfItems);
    }
}
