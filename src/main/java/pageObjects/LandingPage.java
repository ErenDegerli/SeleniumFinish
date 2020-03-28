package pageObjects;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage extends Base {

    public static WebDriver driver;

    /*@FindBy(css = "a[href='http://qaclickacademy.usefedora.com/sign_in']")
    WebElement signIn;

    @FindBy(css = ".text-center>h2")
    WebElement title;

    @FindBy(css = "ul[class='nav navbar-nav navbar-right']")
    WebElement navBar;*/

    private By signIn = By.cssSelector("a[href='http://qaclickacademy.usefedora.com/sign_in']");
    private By title = By.cssSelector(".text-center>h2");
    private By navBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
    private By header = By.cssSelector("div[class*='video-banner']");
    private By popup=By.xpath("//button[text()='NO THANKS']");

    public LandingPage(WebDriver driver) {
        LandingPage.driver = driver;

    }

    public WebElement getLogin() {
        return driver.findElement(signIn);
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getNavigationBar() {
        return driver.findElement(navBar);
    }

    public WebElement getHeader() {
        return driver.findElement(header);
    }

    public int getPopUpSize()
    {
        return driver.findElements(popup).size();
    }

    public WebElement getPopUp()
    {
        return driver.findElement(popup);
    }
}
