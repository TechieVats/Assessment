package base;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestingUtility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseDriver {
    public static WebDriver driver;
    public static Properties property;
    public static WebDriverWait wait;
    public static Configuration config;

    public static void creatingTheSession() throws MalformedURLException {
        driver = null;
        config = new Configuration();
        property = config.getProperties();
        String browserName = property.getProperty("BROWSER");

        switch (browserName) {

            case "DOCKER_CHROME": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920,1200");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                URL url = new URL("http://localhost:4444/wd/hub");
                driver = new RemoteWebDriver(url, chromeOptions);
                break;
            }

            case "CHROME": {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + property.getProperty("CHROME_PATH"));
                driver = new ChromeDriver();
                break;
            }
            case "FIREFOX": {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + property.getProperty("GECKO_PATH"));
                driver = new FirefoxDriver();
                break;
            }
            case "MAC_CHROME": {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + property.getProperty("MAC_CHROME_DRIVER_PATH"));
                driver = new ChromeDriver();
                break;
            }

        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestingUtility.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestingUtility.IMPLICIT_WAIT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestingUtility.WEB_DRIVER_WAIT));
    }

    public void navigateToUrl() {
        driver.get(property.getProperty("DEMO_URL"));
    }
}