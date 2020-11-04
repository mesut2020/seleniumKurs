package Day05AndProject1;


import org.junit.Assert;
import org.openqa.selenium.*;
import utils.BaseStaticDriver;

public class _01_SendKesys_Click_Senaryo extends BaseStaticDriver {

    public static void main(String[] args) throws Exception {

        driver.get("http://www.practiceselenium.com/");

        driver.findElement(By.linkText("Check Out")).click();

        driver.findElement(By.id("email")).sendKeys("medogan@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Mesut Dogan");
        Thread.sleep(1000);
        driver.findElement(By.id("address")).sendKeys("Deutschland");
         Thread.sleep(2000);
        driver.findElement(By.className("btn-primary")).click();

        WebElement menu = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914921"));
        String menuTxt = menu.getText();

        Assert.assertEquals("Menu", menuTxt);

        String url = driver .getCurrentUrl();
        Assert.assertEquals("http://www.practiceselenium.com/menu.html?", url);
        
        Thread.sleep(3000);
        driver.quit();
    }


}
