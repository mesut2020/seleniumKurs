package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseStaticDriver;

public class _01_HoverOver extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement bank = driver.findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement account = driver.findElement(By.cssSelector("div>ol#bank"));

        Actions builder = new Actions(driver);
        Action build = builder.moveToElement(bank).build();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#flow_close_btn_iframe")).click();   // sol altta video aciliyor, onu kapatmak icin...


        System.out.println("Mous uzerine gelmeden once renk :" + Color.fromString(bank.getCssValue("color")).asHex());
        build.perform();Thread.sleep(3000);
        System.out.println("Mous uzerine geldikten sonra renk :" + Color.fromString(bank.getCssValue("color")).asHex());


        Thread.sleep(3000);
        driver.quit();


    }
}
