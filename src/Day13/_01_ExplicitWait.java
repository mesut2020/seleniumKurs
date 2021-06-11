package Day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

// todo Seleniumdaki bekletme komutları
// Thread.sleep tavsiye edilen bir bekleme komutu değildir.
// Implicit(Üstü kapalı) Wait ve Explicit(Belirgin) Wait
// Implicit Wait her komuta belirli bir zaman tanır.
// Explicit Wait spesifik bir komut için belirli bir süre tanır.


public class _01_ExplicitWait extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        WebElement button = driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        button.click();

        //WebElement text = driver.findElement(By.xpath("//p[text()='WebDriver']"));

        // ExplicitWait

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
        // Bu locator daki elemen gorunur(visible) olana kadar bekle...
        // Implicit ve Explicit bekleme kullanildiginda ikisinide kullanir...


Thread.sleep(2000);
driver.quit();

    }
}
