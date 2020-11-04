package Day10_Project_2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

public class SeleniumProject2a extends BaseStaticDriver {
    /*
1) Bu siteye gidin --> http://zero.webappsecurity.com/login.html
2) Login'e "username" -- Password'a "password" yazın . Sign in button'ına tıklayınız.                  input#user_login    input#user_password      input[name='submit']
3) Transfer founds butonuna tıklayınız.
4) From account kısmından herhangı bir(Random'la tıklatın) değer seçınız.
5) To account kısmından herhangı bir(Random'la tıklatın.) değer seçınız.
6) Her hangi bir amount gırınız.
7) Her hangi bir description giriniz.
8)Continue butonuna tiklayiniz.
9)Submit butonuna tiklayiniz.
10) "You successfully submitted your transaction" Yazısı gözükmesi gerekiyor.
 */
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
        driver.findElement(By.cssSelector("input#user_password")).sendKeys("password");
        driver.findElement(By.cssSelector("input[name='submit']")).click();

        driver.findElement(By.id("transfer_funds_tab")).click();

        WebElement fromAccount = driver.findElement(By.cssSelector("select#tf_fromAccountId"));
        Select fromAccountMenu = new Select(fromAccount);
        String random1 = String.valueOf((int)(Math.random()*6+1)); // value 1 den basliyor, bu yuzden random 1 den basladi
        fromAccountMenu.selectByValue(random1);Thread.sleep(500);   //fromAccountMenu.selectByIndex(random1);

        WebElement toAccount = driver.findElement(By.cssSelector("select#tf_toAccountId"));
        Select toAccountMenu = new Select( toAccount);
        String random2 = String.valueOf((int)(Math.random()*6+1)); // String str= Integer.toString(num);
        toAccountMenu.selectByValue(random2);Thread.sleep(500);

        driver.findElement(By.cssSelector("input#tf_amount")).sendKeys("500");  Thread.sleep(500);
        driver.findElement(By.cssSelector("input#tf_description")).sendKeys("Descripton girildi..."); Thread.sleep(500);

        driver.findElement(By.cssSelector("button#btn_submit")).click();Thread.sleep(500);
        driver.findElement(By.cssSelector("button#btn_submit")).click();

        WebElement result = driver.findElement(By.cssSelector(".alert.alert-success"));

        String actualResult = result.getText();

        Assert.assertTrue("Hata: Sonuc mesaji alinamadi...", actualResult.contentEquals("You successfully submitted your transaction."));


        Thread.sleep(3000);
        driver.quit();
    }
}
