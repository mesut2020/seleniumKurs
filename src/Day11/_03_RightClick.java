package Day11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03_RightClick extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/buttons"); Thread.sleep(500);

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));

       Actions builder = new Actions(driver);

       Action build = builder.moveToElement(rightClickButton).contextClick().build(); // builder.contextClick(rightClickButton).perform();

       build.perform();

       String actualMessage = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals("HATA VAR!!!", "You have done a right click", actualMessage);

        Thread.sleep(3000);
        driver.quit();

    }
}
