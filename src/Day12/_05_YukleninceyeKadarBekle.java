package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.concurrent.TimeUnit;

public class _05_YukleninceyeKadarBekle extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        WebElement button = driver.findElement(By.cssSelector("button[onclick = 'timedText()']"));
        button.click();

        WebElement webDriverText = driver.findElement(By.xpath("//p[text()='WebDriver']"));
        System.out.println(webDriverText.getText());

    }
}
