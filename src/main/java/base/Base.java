package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public Properties properties = new Properties();


    public WebDriver initializeDriver() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\pageObjects\\data.properties");
        properties.load(fileInputStream);
        //mvn test -Dbrowser = chrome
        //String browserName = System.getProperty("browser");

        String browserName = properties.getProperty("browser");

        if (browserName.contains("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.contains("Firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (browserName.contains("headless")) {
                firefoxOptions.addArguments("headless");
            }
            driver = new FirefoxDriver(firefoxOptions);

        } else if (browserName.contains("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    /*public void getScreenshot(String result) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\erend\\Desktop\\screenshots\\" + result + "screenshot.png"));
    }*/

}
