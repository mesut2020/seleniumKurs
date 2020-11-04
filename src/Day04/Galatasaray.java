package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class Galatasaray extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {


        driver.get("https://www.galatasaray.org/anasayfa");
        driver.manage().window().maximize();

        WebElement e = driver.findElement(By.cssSelector("#menu-sub-3 > a"));

        //System.out.println(e.getAttribute("href"));
        System.out.println(e.getText());
        System.out.println(e.getAttribute("href"));




        Thread.sleep(1000);
        driver.quit();
    }
}
