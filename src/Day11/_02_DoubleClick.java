package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_DoubleClick extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/buttons"); Thread.sleep(500);

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        Actions builder = new Actions(driver);

//        Action build = builder.moveToElement(doubleClickButton).doubleClick().build();
//        build.perform();
        builder.moveToElement(doubleClickButton).doubleClick().perform();



        Thread.sleep(3000);
        driver.quit();

    }
}
