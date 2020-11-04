package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _04_Alert_2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        WebElement text  = driver.findElement(By.name("cusid"));
        text.sendKeys("123");        Thread.sleep(500);


        WebElement submit  = driver.findElement(By.cssSelector("input[type='submit']"));
        submit.click();
        Thread.sleep(2000);

        String alertMesage = driver.switchTo().alert().getText();

        System.out.println(alertMesage);

        driver.switchTo().alert().accept();        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        Thread.sleep(6000);
        driver.quit();


    }
}
