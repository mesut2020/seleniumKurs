package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseStaticDriver {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static WebDriverWait wait;

    static{
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // Konsoldaki kirmizi yazilari gostermez
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver= new ChromeDriver();

        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);  // sayfanin yuklenmesini bekler
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // sayfadaki butun elemeanlarin yuklenmesini max. 30sn bekler...

        driver.manage().deleteAllCookies();

        js = (JavascriptExecutor) driver;
    }
}
