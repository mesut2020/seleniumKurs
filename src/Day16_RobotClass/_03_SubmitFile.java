package Day16_RobotClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;

import java.awt.*;

public class _03_SubmitFile extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/upload/");

        WebElement input=driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\medog\\Desktop\\ornek.txt");

        WebElement btn = driver.findElement(By.id("submitbutton"));
        btn.click();

        Thread.sleep(5000);
        driver.quit();
    }
}