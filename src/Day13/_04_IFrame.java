package Day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

public class _04_IFrame extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://chercher.tech/practice/frames");

        //driver.switchTo().frame(0);  indexle de bulunabilir  (1)
        driver.switchTo().frame("frame1"); // id veya name le de bulunabilir  (2)
        //WebElement cerceve1=driver.findElement(By.id("frame1")); // element olarak bulunup
        //driver.switchTo().frame(cerceve1); // bu şekilde de diğer sayfaya geçilebilir. (3)

        WebElement input=driver.findElement(By.cssSelector("input[type='text']"));
        input.sendKeys("Türkiye");
        driver.switchTo().frame("frame3");
        driver.findElement(By.id("a")).click();

        //sonra anasayfaya geri döndüm
        driver.switchTo().defaultContent(); // Ana sayfaya geri getiriyorur gittiğim framaden(sayfadan)
        //driver.switchTo().parentFrame(); // bir geri sayfaya git demektir.yukarıdaki kodla aynı işi görüyor.

        // 2.Frame geçilecek ama öncesinde ana sayfaya gitmem gerekiyor.
        driver.switchTo().frame("frame2");

        // bir tane elemanın gettext ini aldım.
        WebElement frame2Yazi=driver.findElement(By.cssSelector("body > b"));
        System.out.println(frame2Yazi.getText());

        Select menu = new Select(driver.findElement(By.id("animals")));
        menu.selectByIndex(3);

        Thread.sleep(6000);
        driver.quit();

        Thread.sleep(6000);
        driver.quit();
    }
}
