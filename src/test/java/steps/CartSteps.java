package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import utils.DriverFactory;

import java.util.List;

public class CartSteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final CartPage cartPage = new CartPage(driver);

    @Then("user verifies {string} is in the cart")
    public void userVerifiesItemIsInCart(String item){
        Assert.assertEquals(cartPage.getItemName(),item);
    }

    @Then("user verifies {string} are in the cart")
    public void userVerifiesItemsAreInCart(String items) {
        List<String> expected = List.of(items.split(",\\s*"));
        Assert.assertEquals(cartPage.getItemNames(), expected);
    }

    @Then("the cart page header shows {string} item")
    public void theCartPageHeaderShowsNumberOfItem(String numberOfItems){
        Assert.assertEquals(cartPage.getNumberOfItemInCart(),numberOfItems);
    }
}
