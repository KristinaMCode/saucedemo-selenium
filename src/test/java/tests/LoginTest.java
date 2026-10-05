package tests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.TestData;

public class LoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(loginPage.getLogoText(), TestData.LOGO_TEXT);
        loginPage.login(ConfigReader.get("standard.user"), ConfigReader.getPassword());
        Assert.assertEquals(inventoryPage.getUrl(), ConfigReader.get("inventory.url"));
        Assert.assertEquals(inventoryPage.getLogoText(), TestData.LOGO_TEXT);
        log.info("User was successfully logged in!");
    }

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][]{
                {"", ConfigReader.getPassword(), TestData.ERROR_EMPTY_USERNAME},
                {ConfigReader.get("standard.user"), "", TestData.ERROR_EMPTY_PASSWORD},
                {ConfigReader.get("locked.user"), ConfigReader.getPassword(), TestData.ERROR_LOCKED_USER},
                {ConfigReader.get("not.match.user"), ConfigReader.getPassword(), TestData.ERROR_WRONG_CREDENTIALS}};
    }

    @Test(dataProvider = "invalidLogins")
    public void loginWithError(String username, String password, String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.get("base.url"));
        log.info("User was unsuccessfully logged in!");
    }



//    @Test
//    public void loginWithLockedUser() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login(ConfigReader.get("locked.user"), ConfigReader.getPassword());
//        Assert.assertEquals(loginPage.getErrorMessage(), ConfigReader.get("login.error.locked.username"));
//        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.get("base.url"));
//        log.info("Locked user was unsuccessfully logged in!");
//    }

}
