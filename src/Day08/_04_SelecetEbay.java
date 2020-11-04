package Day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

public class _04_SelecetEbay extends BaseStaticDriver {
    /*
  Senaryo :
  1- https://www.ebay.com/ sitesini açın
  2- Arama seçim menüsünden 2984  değerli elemanı seçtiriniz.
  3- Arama işlemini yaptırınız.

 */
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.ebay.com");
        driver.manage().deleteAllCookies(); // siteler bizim bilgileri tutarak bazen engel cikardigi cookies leri sildik...

        WebElement dropDownMenu=driver.findElement(By.cssSelector("select[id='gh-cat']"));

        Select menu = new Select(dropDownMenu);
        menu.selectByValue("2984");

        driver.findElement(By.cssSelector("input#gh-ac")).sendKeys("Cocuk arabasi");Thread.sleep(1000);

        driver.findElement(By.cssSelector("input#gh-btn")).click();

        Thread.sleep(5000);
        driver.quit();


    }
}
