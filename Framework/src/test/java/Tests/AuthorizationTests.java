package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthPage;
import pages.MainPage;

public class AuthorizationTests {
    WebDriver driver;
    private AuthPage authPage;
    private MainPage mainPage;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        authPage = new AuthPage(driver);
        mainPage = new MainPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void successAuth() {
        authPage.insertLogin("standard_user");
        authPage.insertPassword("secret_sauce");
        authPage.clickSignInButton();
        String getInventory = mainPage.getInventory();
        Assertions.assertEquals(getInventory, getInventory);
    }

    @Test
    public void wrongLogin() {
        authPage.insertLogin("Luka");
        authPage.insertPassword("secret_sauce");
        authPage.clickSignInButton();
        String getErrorMessage = authPage.getErrorMessage();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", getErrorMessage);
    }

    @Test
    public void emptyPassword() {
        authPage.insertLogin("standard_user");
        authPage.insertPassword("");
        authPage.clickSignInButton();
        String getErrorMessage = authPage.getErrorMessage();
        Assertions.assertEquals("Epic sadface: Password is required", getErrorMessage);
    }
}

