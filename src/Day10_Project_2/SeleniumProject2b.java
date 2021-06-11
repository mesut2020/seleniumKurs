package Day10_Project_2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

public class SeleniumProject2b extends BaseStaticDriver {
 /*         1) Bu siteye gidin --> http://zero.webappsecurity.com/login.html
            2) Login'e "username" -- Password'a "password" yazın. Sign in button'una tıklayınız.
            3) Paybils button'ına tıklayınız.
            4) Payee dropdown'unundan rastgele (Random) bir değer seçiniz.
            5) Account dropdown'unundan rastgele (Random) bir değer seçiniz..
            6) Amount'a bir değer girin..
            7) Date'de bir tarih seçiniz.
            8) Description'ı her hangi bir şekilde doldurun.
            11) Pay button'una tıklayınız.
            12) The payment was successfully submitted. mesajının göründüğünü doğrulayınız.*/

 public static void main(String[] args) throws InterruptedException {

  driver.get("http://zero.webappsecurity.com/login.html");

  driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
  driver.findElement(By.cssSelector("input#user_password")).sendKeys("password");
  driver.findElement(By.cssSelector("input[name='submit']")).click();

  //WebElement backToSafetyButton = driver.findElement(By.cssSelector("#primary-button"));
  if (driver.findElement(By.cssSelector("#primary-button")).isDisplayed())
   driver.findElement(By.cssSelector("#primary-button")).click();

  driver.findElement(By.cssSelector("#transfer_funds_link")).click();

  driver.findElement(By.id("pay_bills_tab")).click();


  int random1 = (int)(Math.random()*4+1);  //  (//select[@id='sp_payee']/option)[1] den basliyor.....
  driver.findElement(By.xpath("(//select[@id='sp_payee']/option)["+random1 +"]")).click();

   random1 = (int)(Math.random()*6+1);
  driver.findElement(By.xpath("(//select[@id='sp_account']/option)["+random1 +"]")).click(); Thread.sleep(500);

  driver.findElement(By.id("sp_amount")).sendKeys("500");  Thread.sleep(500);

  driver.findElement(By.id("sp_date")).click();

        Thread.sleep(500);

        driver.findElement(By.xpath("//a[text()='17']")).click();   //      (//a[@class='ui-state-default'])[12]")


  driver.findElement(By.cssSelector("input#sp_description")).sendKeys("Descripton girildi..."); Thread.sleep(500);

  driver.findElement(By.cssSelector(".btn.btn-primary")).click();Thread.sleep(500);

  WebElement result = driver.findElement(By.cssSelector("div#alert_content"));

  String actualResult = result.getText();

  Assert.assertTrue("Hata: Sonuc mesaji alinamadi...", actualResult.contentEquals("The payment was successfully submitted.")); //\n


  Thread.sleep(6000);
  driver.quit();

 }
}
