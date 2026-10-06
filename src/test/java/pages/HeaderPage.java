package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HeaderPage extends BasePage {
    private final By logoTitle;
    private final By menuButton;
    private final By shoppingCart;


    public HeaderPage(WebDriver driver) {
        super(driver);
        this.logoTitle = By.className("app_logo");
        this.menuButton = By.id("react-burger-menu-btn");
        this.shoppingCart = By.id("shopping_cart_container");
    }

    private static final Logger log = LoggerFactory.getLogger(HeaderPage.class);


    public String getLogoText(){
        log.info("Verifying Header page title.");
        return driver.findElement(logoTitle).getText();
    }

    public boolean isMenuButtonDisplayed(){
        log.info("Verifying Menu element is displayed on Header page menu.");
        return driver.findElement(menuButton).isDisplayed();
    }

    public boolean isCartDisplayed(){
        log.info("Verifying Cart element is displayed on Header page menu.");
        return driver.findElement(shoppingCart).isDisplayed();
    }

}
