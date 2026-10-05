package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.TestData;

public class LoginSteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);
    private final InventoryPage inventoryPage = new InventoryPage(driver);

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get(ConfigReader.get("base.url"));
        Assert.assertEquals(loginPage.getLogoText(), TestData.LOGO_TEXT);
    }

    @When("the user logs in {string} with valid password")
    public void theUserLogsInWithValidPassword(String userType) {
        String username = ConfigReader.get(userType + ".user");
        loginPage.login(username, ConfigReader.getPassword());
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String userType, String password) {
        String username = "";
        if (!userType.isEmpty()) {
            username = ConfigReader.get(userType + ".user");
        }
        if (!password.isEmpty()) {
            password = ConfigReader.getPassword();
        }
        loginPage.login(username, password);
    }

    @Then("the inventory page is displayed")
    public void theInventoryPageIsDisplayed() {
        inventoryPage.waitUntilLoaded();
        Assert.assertEquals(inventoryPage.getUrl(), ConfigReader.get("inventory.url"));
        Assert.assertEquals(inventoryPage.getLogoText(), "Swag Labs");
    }

    @Then("the error message {string} is displayed")
    public void theErrorMessageIsDisplayed(String errorType) {
        Assert.assertEquals(loginPage.getErrorMessage(), TestData.getLoginError(errorType));
    }
}
