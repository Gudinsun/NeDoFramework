package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {
    private final WebDriver driver;
    private static final By USERNAME_LOCATOR = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_LOCATOR = By.xpath("//*[@id='password']");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//input[@type='submit']");
    private static final By ERROR_MESSAGE = By.xpath("//*[@class='error-message-container error']");
    public AuthPage(WebDriver driver) {
            this.driver = driver;
        }
        public void insertLogin(String login) {
            driver.findElement(USERNAME_LOCATOR).sendKeys(login);
        }
        public void insertPassword(String password) {
            driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
        }
        public void clickSignInButton() {
            driver.findElement(SIGN_IN_BUTTON_LOCATOR).click();
        }
        public String getErrorMessage() {
            return driver.findElement(ERROR_MESSAGE).getText();
        }
        public void fullAuth(String login, String password) {
            insertLogin(login);
            insertPassword(password);
            clickSignInButton();
    }

}

