package Day16_RobotClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class _02_Copytext extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, AWTException {
        driver.get("http://demo.guru99.com/test/upload/");

        // alttaki video yu kapatmak icin...
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flow_close_btn_iframe")));
//        driver.switchTo().frame("flow_close_btn_iframe");
//        WebElement kapatButonu = driver.findElement(By.id("closeBtn"));
//        kapatButonu.click();
//        driver.switchTo().defaultContent();

        Thread.sleep(2000);
       driver.findElement(By.id("file_wraper0")).click(); // Choose File button

        // Selenium clipboard set String
        // String i  hafizaya (clipboard) kopyalaiyor (set ediyor)...
        StringSelection stringSelection = new StringSelection("C:\\Users\\medog\\Desktop");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection , null);

        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // dosya adini kopyala ve enter la..
        stringSelection = new StringSelection("ornek.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection , null);

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        WebElement btn = driver.findElement(By.id("submitbutton"));
        btn.click();

        Thread.sleep(5000);
        driver.quit();

    }
}
