package Day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

public class _00_iFrameGiris extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        driver.switchTo().frame("flow_close_btn_iframe");
        WebElement kapatButonu= driver.findElement(By.id("closeBtn"));  // alttaki video yu kapatmak iicn
        kapatButonu.click();


        Thread.sleep(6000);
        driver.quit();
    }
}




