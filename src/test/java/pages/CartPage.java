package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CartPage extends HeaderPage {
    private final By title = By.xpath("//div[@class='header_secondary_container']//span[@class='title']");
    private final By itemInCart = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LoggerFactory.getLogger(CartPage.class);

    public CartPage waitUntilLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(title));
        return this;
    }
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getItemName() {
        return driver.findElement(itemInCart).getText();
    }
}
