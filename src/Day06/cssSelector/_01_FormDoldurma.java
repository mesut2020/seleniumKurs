package Day06.cssSelector;

import org.openqa.selenium.By;
import utils.BaseStaticDriver;

public class _01_FormDoldurma extends BaseStaticDriver {
/* 1- https://formsmarts.com/form/yu?mode=h5 sitesini açın
            2- Business i çekleyin.                                                         input[id$='4586_0']
3- discover XYZ ye tıklatın ve online Advertising i seçin                 select[id$=_4588]           option[value='Online Advertising']
4- Every day i seçin                                                                           input[value='Every Day]
5- Good u seçin                                                                                 input[value='Good']
6- using XYZ yi tıklatın ve 3.seçeneği seçin                                           select[id$='_4597']>:nth-child(4)
*/

    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("https://formsmarts.com/form/yu?mode=h5");

        driver.findElement(By.cssSelector("input[id$='4586_0']")).click(); Thread.sleep(500);
        driver.findElement(By.cssSelector("select[id$=_4588] ")).click();Thread.sleep(500);
        driver.findElement(By.cssSelector("option[value='Online Advertising']")).click();Thread.sleep(500);
        driver.findElement(By.cssSelector("input[value='Every Day']")).click();Thread.sleep(500);
        driver.findElement(By.cssSelector("input[value='Good']")).click();Thread.sleep(500);
        driver.findElement(By.cssSelector("select[id$='_4597']>:nth-child(4)")).click();Thread.sleep(500);
        driver.findElement(By.cssSelector("textarea#u_Hc4_89597")).sendKeys("XYZ");Thread.sleep(500);

        Thread.sleep(15000);
        driver.quit();

    }
}
