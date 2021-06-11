package Day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;

public class _05_SelectFacebook extends BaseStaticDriver {
    /*
   Senaryo
   1- https://www.facebook.com/ sitesine giriniz.
   2- Yeni hesap oluştura tıklayınız.
   3- Formdaki tüm bilgileri giriniz.

        u_1_2
        u_2_2
         u_3_2
         u_4_2
         u_6_2

    u_ başlıyor    _2 bitiyor

    a[id^='u_'][id$='_2']

    CSS de
^ -> ile başlayan
$ -> ile biten
* -> içinde geçen

    Xpath
//a[starts-with(@id,'u_')] -> ile başlayan
//a[ends-with(@id,'_2')]    -> ile biten
//a[contains(@id,'u_')]    -> içinde geçen
(//a[starts-with(@id,'u_')])[3]      3. elemani bulur
     */

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.facebook.com");
        driver.manage().deleteAllCookies(); // siteler bizim bilgileri tutarak bazen engel cikardigi cookies leri sildik...
        driver.findElement(By.cssSelector("button[data-cookiebanner='accept_button']")).click();Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[rel='async']")).click();

        driver.findElement(By.cssSelector("input[id^='u_'][id$='_3n']")).sendKeys("Ahmet"); Thread.sleep(500);  // firstname
        driver.findElement(By.cssSelector("input[id^='u_'][id$='_xt']")).sendKeys("Kaya");Thread.sleep(500);  // lastname

        System.out.println("Confirmed EMail Box is displayed : "+driver.findElement(By.cssSelector("input[id^='u_'][id$='_j']")).isDisplayed());
        driver.findElement(By.cssSelector("input[id^='u_'][id$='_g']")).sendKeys("ahmet@kaya.com");Thread.sleep(500);  // email
        driver.findElement(By.cssSelector("input[id^='u_'][id$='_j']")).sendKeys("ahmet@kaya.com");Thread.sleep(500);  // email
        System.out.println("Confirmed EMail Box is displayed : "+driver.findElement(By.cssSelector("input[id^='u_'][id$='_j']")).isDisplayed());

        driver.findElement(By.cssSelector("input#password_step_input")).sendKeys("Sele-/123");Thread.sleep(500); // password

        WebElement month = driver.findElement(By.cssSelector("select#month"));
        Select monthMenu = new Select(month);
        monthMenu.selectByValue("3");Thread.sleep(500);

        WebElement day = driver.findElement(By.cssSelector("select#day"));
        Select dayMenu = new Select(day);
        dayMenu.selectByValue("2");Thread.sleep(500);

        WebElement year = driver.findElement(By.cssSelector("select#year"));
        Select yearMenu = new Select(year);
        yearMenu.selectByValue("1978");Thread.sleep(500);

        driver.findElement(By.xpath("//label[text()='Male']")).click(); Thread.sleep(500);

       driver.findElement(By.cssSelector("button#u_2_s")).click();

        Thread.sleep(5000);
        //driver.quit();
    }
}
