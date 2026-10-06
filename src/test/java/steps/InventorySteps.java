package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.InventoryPage;
import utils.DriverFactory;
import utils.TestData;

public class InventorySteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final InventoryPage inventoryPage = new InventoryPage(driver);

    @Then("the header is displayed")
    public void theHeaderIsDisplayed(){
        Assert.assertEquals(inventoryPage.getLogoText(), TestData.LOGO_TEXT);
        Assert.assertTrue(inventoryPage.isMenuButtonDisplayed());
        Assert.assertTrue(inventoryPage.isCartDisplayed());
    }

}
