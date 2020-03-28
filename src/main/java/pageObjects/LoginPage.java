package pageObjects;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base {

    public static WebDriver driver;

    /*@FindBy(id="user_email")
    WebElement email;
    @FindBy(id="user_password")
    WebElement password;
    @FindBy(css ="[value='Log In']")
    WebElement login;*/
    By email = By.id("user_email");
    By password = By.id("user_password");
    By login = By.cssSelector("[value='Log In']");

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
    }

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLogin() {
        return driver.findElement(login);
    }
}
