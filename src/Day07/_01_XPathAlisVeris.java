package Day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _01_XPathAlisVeris extends BaseStaticDriver {
/*    1- https://www.saucedemo.com/ sitesini açınız.
            2- Login işlemini yapınız
3- Burada gözüken ürünlerin isimlerini yazdırınız.

*/
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.xpath("//input[@id='user-name'] ")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password'] ")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button'] ")).click();

        ArrayList<WebElement> elList2 = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<WebElement> elList =  driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        for (WebElement e: elList ) {
            System.out.println(e.getText());
        }

        driver.quit();
    }
}
