package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class InventoryPage extends HeaderPage {
    private final By appLogo = By.className("app_logo");
    private final By productsHeader = By.className("header_secondary_container");
    private final By inventoryList = By.className("inventory_list");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LoggerFactory.getLogger(InventoryPage.class);

    public InventoryPage waitUntilLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(inventoryList));
        return this;
    }

    public String getUrl() {
        log.info("Assert inventory URL.");
        return driver.getCurrentUrl();
    }

    public String getLogoText() {
        log.debug("Assert inventory logo");
        return driver.findElement(appLogo).getText();

    }

    public void assertProductsHeader() {
        Assert.assertTrue(driver.findElement(productsHeader).isDisplayed());
    }

}
