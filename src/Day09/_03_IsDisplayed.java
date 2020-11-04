package Day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_IsDisplayed extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.facebook.com");
        //driver.manage().deleteAllCookies(); // siteler bizim bilgileri tutarak bazen engel cikardigi cookies leri sildik...
        driver.findElement(By.cssSelector("a[id^='u_'][id$='_2']")).click();Thread.sleep(1000);

        driver.findElement(By.cssSelector("input[id^='u_'][id$='_b']")).sendKeys("Ahmet"); Thread.sleep(500);  // firstname
        driver.findElement(By.cssSelector("input[id^='u_'][id$='_d']")).sendKeys("Kaya");Thread.sleep(500);  // lastname

        WebElement confirmedEmail = driver.findElement(By.cssSelector("input[id^='u_'][id$='_j']"));

        System.out.println("Confirmed EMail Box is displayed : "+confirmedEmail.isDisplayed());

        driver.findElement(By.cssSelector("input[id^='u_'][id$='_g']")).sendKeys("ahmet@kaya.com");Thread.sleep(500);  // email

        System.out.println("Confirmed EMail Box is displayed : "+confirmedEmail.isDisplayed());

        confirmedEmail.sendKeys("ahmet@kaya.com");Thread.sleep(500);  // email



    }
}
