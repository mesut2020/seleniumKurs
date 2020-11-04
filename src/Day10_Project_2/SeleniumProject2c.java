package Day10_Project_2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

public class SeleniumProject2c extends BaseStaticDriver {
/*
1) Bu siteye gidin --> http://zero.webappsecurity.com/login.html
2) Login'e "username" -- Password'a "password" yazın. Sign in button'una tıklayınız.
3) Paybils button'ına tıklayınız.
            4) Purchase Foreign Currency'ya tıklayınız.
            5) Currency kısmından rastgele(RANDOM) bir değer seçiniz. (Dropdown'ın içindeki Select One değerini, Random'a dahil etmeyin.)
            6) Amount'a bir değer girin.
            7) U.S. dollar (USD)'ı seçiniz.
            8) Purchase button'una tıklayınız.
            9) Foreign currency cash was successfully purchased. yazısı görünmelidir.*/
public static void main(String[] args) throws InterruptedException {

    driver.get("http://zero.webappsecurity.com/login.html");

    driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
    driver.findElement(By.cssSelector("input#user_password")).sendKeys("password");
    driver.findElement(By.cssSelector("input[name='submit']")).click();

    driver.findElement(By.id("pay_bills_tab")).click();

    driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

    Thread.sleep(1000);

    WebElement currency = driver.findElement(By.cssSelector("select#pc_currency"));  // (//select[@id='pc_currency']/option)[2]
    Select fromSecim = new Select(currency);
    int random = (int)(Math.random()*15+1);
    fromSecim.selectByIndex(random);

    driver.findElement(By.id("pc_amount")).sendKeys("500");  Thread.sleep(500);
    driver.findElement(By.cssSelector("input#pc_inDollars_true")).click();  Thread.sleep(500);

    driver.findElement(By.cssSelector("input#purchase_cash")).click();Thread.sleep(500);

    WebElement result = driver.findElement(By.cssSelector("div#alert_content"));

    String actualResult = result.getText();

    Assert.assertTrue("Hata: Sonuc mesaji alinamadi...", actualResult.contentEquals("Foreign currency cash was successfully purchased."));

    Thread.sleep(6000);
    driver.quit();

}
}
