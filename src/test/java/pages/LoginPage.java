package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.Console;

import static utils.TestData.*;

public class LoginPage extends BasePage{
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginLogo = By.className("login_logo");
    private final By error = By.tagName("h3");

    public LoginPage(WebDriver driver) {
       super(driver);
    }

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public String getLogoText() {
        log.info("Verifying Login page.");
        return driver.findElement(loginLogo).getText();
    }

    public void login(String username, String password) {
        log.info("Logging in user: " + username);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        log.debug("Login button clicked!");
    }

    public String getErrorMessage() {
        log.info("Verifying error message.");
        return driver.findElement(error).getText();
    }


}
