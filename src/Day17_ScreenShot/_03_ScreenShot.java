package Day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/*
   Senaryo :
        1- https://opensource-demo.orangehrmlive.com/  sitesine gidiniz.
        2- Sifreyi hatali vererek Login işlemini yapınız ve ekran goruntusunu aliniz...
 */

public class _03_ScreenShot extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123"); // hatali Sifre
        driver.findElement(By.id("btnLogin")).click();
try {
    WebElement alertMessage = driver.findElement(By.id("spanMessage"));
    String alertText = alertMessage.getText();

        System.out.println(alertText);

        if (alertText.contains("Invalid credentials"))
        {
            System.out.println("Test Failed...");
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenFile = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenFile, new File("EkranGoruntuleri/orangehrm/LoginAlert.png"));
        }

}catch (Exception e){
    System.out.println("Test Passed...");
}

        Thread.sleep(5000);
        driver.quit();
    }
}
