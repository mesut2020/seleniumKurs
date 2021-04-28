package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_FindingByClassName extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com/");

        //driver.manage().window().maximize();

        WebElement e = driver.findElement(By.className("editor_collections"));
        System.out.println(e.getText());


        Thread.sleep(1000);

        driver.quit();
    }
}
