package Day12;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

/*
     Interview sorusu
       - Alertleri nasıl kullanırsın (handle edersin)

          driver.switchTo().alert()   bununla kullanılır.
          komutları:
          accept -> OK, TAMAM yani olumlu butona basmak
          dismiss -> CANCEL, HAYIR yani olumsuz butona basmak
          getText -> Alertin mesaj alınır.
          SendKeys -> Alertin inputuna mesaj göndermek için kullanılır.
 */

public class _03_IntroAlert  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        Thread.sleep(500);

        WebElement clickMe1=driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        clickMe1.click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept(); // Alert kutucuğuna geçildi ve Tamam butonuna basıldı.
        // web sayfasından Alert kutucuğuna geçildi.  switchTo

        WebElement clickMe2 = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        clickMe2.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        WebElement textActual =  driver.findElement(By.id("confirm-demo"));
        Assert.assertEquals("HATA: ... ", "You pressed Cancel!", textActual.getText());

        WebElement clickMe3 = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        clickMe3.click();
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Almanya Almanya");
        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        textActual =  driver.findElement(By.id("prompt-demo"));

        Assert.assertEquals("HATA: ...", "You have entered 'Almanya Almanya' !", textActual.getText());




        Thread.sleep(6000);
        driver.quit();
    }
}