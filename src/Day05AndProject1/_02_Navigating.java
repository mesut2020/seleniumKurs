package Day05AndProject1;

import org.openqa.selenium.By;
import utils.BaseStaticDriver;

public class _02_Navigating extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("http://www.practiceselenium.com/");

        driver.findElement(By.cssSelector("[id=email]"));

        Thread.sleep(1000);
        driver.findElement(By.linkText("Check Out")).click();

        Thread.sleep(1000);
        driver.navigate().back();

        Thread.sleep(1000);
        driver.navigate().forward();

        Thread.sleep(1000);
         driver.manage().window().maximize();

        Thread.sleep(1000);
        driver.quit();

    }
}
