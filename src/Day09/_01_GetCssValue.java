package Day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _01_GetCssValue extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.snapdeal.com");

        WebElement button = driver.findElement(By.id("inputValEnter"));
        System.out.println(button.getAttribute("name"));
        System.out.println(button.getAttribute("type"));
        System.out.println(button.getAttribute("class"));
        System.out.println(button.getAttribute("id"));

        WebElement button2 = driver.findElement(By.className("searchformButton"));
        System.out.println(button2.getCssValue("color"));
        System.out.println(button2.getCssValue("font-size"));
        System.out.println(button2.getCssValue("background"));
        System.out.println(button2.getCssValue("cursor"));
        driver.quit();
    }
}
