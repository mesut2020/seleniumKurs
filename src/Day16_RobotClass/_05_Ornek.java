package Day16_RobotClass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;

import java.awt.*;

// 1- Become a Memeber menusunden Teachers a tiklatin.
// 2-  Çıkan sayfanın title ının "Teachers | Yoga Alliance"  olup olmadığını assert ile kontrol ediniz.


public class _05_Ornek extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, AWTException {
        driver.get("https://www.yogaalliance.org/");

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(//a[@class='sf-with-ul'])[2]"));
        actions.moveToElement(element).perform();

        driver.findElement(By.xpath("(//a[text()='Teachers'])[2]")).click();

        String expectedText = "Teachers | Yoga Alliance";

        wait.until(ExpectedConditions.titleContains("Teachers | Yoga Alliance"));

        System.out.println(driver.getTitle());

        Assert.assertEquals("Hata var...", expectedText, driver.getTitle());


        Thread.sleep(3000);
        driver.quit();
    }
}
