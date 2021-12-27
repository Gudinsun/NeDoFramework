package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ShopCartTests {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void SCTest() {
        driver.get("https://www.saucedemo.com/");
        WebElement insertLogin = driver.findElement(By.xpath("//*[@id='user-name']"));
        insertLogin.sendKeys("standard_user");
        WebElement insertPassword = driver.findElement( By.xpath("//*[@id='password']"));
        insertPassword.sendKeys("secret_sauce");
        WebElement clickButton = driver.findElement(By.xpath("//input[@type='submit']"));
        clickButton.click();

        WebElement cartButton = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        cartButton.click();
        WebElement csButton = driver.findElement(By.xpath("//*[@class='shopping_cart_link']"));
        csButton.click();
        WebElement cartItem = driver.findElement(By.xpath("//*[@class='cart_item']"));
        Assert.assertEquals(cartItem,cartItem);
    }
}
