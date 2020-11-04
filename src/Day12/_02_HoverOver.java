package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseStaticDriver;

public class _02_HoverOver  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.etsy.com");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button.wt-btn.wt-btn--secondary.wt-width-full")).click();

        WebElement clothing = driver.findElement(By.id("catnav-primary-link-10923"));
        WebElement kidMenu = driver.findElement(By.id("side-nav-category-link-10941"));

        Actions builder = new Actions(driver);
        Action build = builder.moveToElement(clothing).build();
        build.perform();
        Thread.sleep(2000);

        build = builder.moveToElement(kidMenu).build();
        build.perform();

        System.out.println(kidMenu.getText());


        Thread.sleep(6000);
        driver.quit();


    }
}
