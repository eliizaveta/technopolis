import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    private String LOGIN_LOCATOR = ".//input[@id='field_email']";
    private String PASSWORD_LOCATOR = ".//input[@id='field_password']";
    private String SIGN_IN_LOCATOR = ".//input[@class = 'button-pro __wide']";

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public UserPage doLogin(String username, String password) throws InterruptedException
    {
        Thread.sleep(4);
        driver.findElement(By.xpath(LOGIN_LOCATOR)).sendKeys(username);
        driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys(password);
        driver.findElement(By.xpath(SIGN_IN_LOCATOR)).click();
        return new UserPage(driver);
    }

}

