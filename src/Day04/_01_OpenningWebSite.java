package Day04;

import org.openqa.selenium.By;
import utils.BaseStaticDriver;

public class _01_OpenningWebSite extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com/");
        //driver.navigate.to("https://www.google.com.tr/"); // sayfanin

        Thread.sleep(1000);

        driver.manage().window().maximize();

        driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000450914897")).click();

        driver.quit();

    }
}
