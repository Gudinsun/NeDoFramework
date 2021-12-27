package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private static final By INVENTORY_LOCATOR = By.xpath("//*[@id='inventory_container']");
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
            this.driver = driver;
        }
        public String getInventory() {
            return driver.findElement(INVENTORY_LOCATOR).getText();
        }
    }
