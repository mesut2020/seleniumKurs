package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _02_FindingById extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com/");
        driver.manage().window().fullscreen();

        WebElement e = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914887"));

        System.out.println(e.getText());
        Thread.sleep(1000);

        try{
            WebElement e2 = driver.findElement(By.id("bulunamadiginda ne olacak"));
            System.out.println(e2.getText());
        }catch (Exception ex){
            System.out.println("eleman bulunamadi... " + ex.getMessage());
        }
        Thread.sleep(1000);

        driver.quit();

    }
}
