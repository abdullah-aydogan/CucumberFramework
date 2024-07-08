package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver webDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String url = prop.getProperty("qaurl");
        String browserProperties = prop.getProperty("browser");
        String browserMaven = System.getProperty("browser");
        String browser = browserMaven != null ? browserMaven : browserProperties;

        if(driver == null) {

            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }

            if(browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }

        return driver;
    }
}