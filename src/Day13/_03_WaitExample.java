package Day13;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;
/*
Senaryo :
2- Samsung galaxy s6 linkine tiklayiniz...
3- Sepete ekleyiniz
4- Cikan alerte accept yapin
 */


public class _03_WaitExample extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");

        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        driver.findElement(By.cssSelector("a[onclick='addToCart(1)']")).click();


        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();


        Thread.sleep(5000);
        driver.quit();
    }

    }
