package Day11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _06_DragAndDropTest2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //a[text()=' BANK ']           div>ol#bank

        WebElement bank = driver.findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement account = driver.findElement(By.cssSelector("div>ol#bank"));

        Actions builder = new Actions(driver);

        // 1. Yontem:
//        Action build = builder.dragAndDrop(bank, account).build();
//        build.perform();

        Action build = builder.clickAndHold(bank).moveToElement(account).release().build(); Thread.sleep(500);
        build.perform();

        List<WebElement> videoClose= driver.findElements(By.cssSelector("#flow_close_btn_iframe"));
        if (videoClose.size()>0)
        driver.findElement(By.cssSelector("#flow_close_btn_iframe")).click();   // sol altta video aciliyor, onu kapatmak icin...

        Thread.sleep(3000);
        //driver.quit();
    }
}
