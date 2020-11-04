package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _09_YonTuslariSecim extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/auto-complete");
        driver.manage().window().maximize();

        WebElement textInput = driver.findElement(By.id("autoCompleteSingleInput"));

        Actions builder  = new Actions(driver);
        Action build = builder
                .moveToElement(textInput)
                .click()
                .sendKeys("b")
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build();

        Thread.sleep(2000);
        build.perform();

        Thread.sleep(3000);
        //driver.quit();
    }
}
/*

    WebElement textInput=driver.findElement(By.id("autoCompleteMultipleInput"));

    Actions builder=new Actions(driver);
    Action build=builder
            .moveToElement(textInput) // inputa gidildi.
            .click() // içine tıklandı.
            .sendKeys("b").build();
        build.perform();
                Thread.sleep(3000);

                build=builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
                build.perform();

                Thread.sleep(6000);
                driver.quit();

                */
