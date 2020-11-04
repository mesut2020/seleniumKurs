package Day11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;
/*
   Senaryo :
   1- http://demo.guru99.com/test/drag_drop.html Siteyi açınız.
   2- Bank butonunu sürükleyerek bağtaki kutucuğa bırakınız.
   3- Daha sonra kutucuk içinde BANK butonunun textini kontrol ediniz.
   4- Assert ile doğrulayınız.
 */

public class _05_DragAndDropTest extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //a[text()=' BANK ']           div>ol#bank

        WebElement bank = driver.findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement account = driver.findElement(By.cssSelector("div>ol#bank"));

        Actions builder = new Actions(driver);
        Action build = builder.dragAndDrop(bank, account).build();
        build.perform();

        Assert.assertEquals("HATA varrrrr", bank.getText(), account.getText());

        driver.findElement(By.cssSelector("#flow_close_btn_iframe")).click();   // sol altta video aciliyor, onu kapatmak icin...

        Thread.sleep(3000);
        driver.quit();


    }
}
