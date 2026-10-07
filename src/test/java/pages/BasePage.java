package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
  protected final WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

}
