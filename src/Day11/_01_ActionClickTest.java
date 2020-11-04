package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _01_ActionClickTest extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/buttons"); Thread.sleep(500);

        WebElement clickButton = driver.findElement(By.xpath("//button[text() = 'Click Me']"));
        Actions builder = new Actions(driver); // driver üzerinden aksiyonları çalıştırmak için değişken tanımladım

        Action build = builder.moveToElement(clickButton).click().build();  // aksiyonlar değişkenine bir aksiyon ekledim.
        // Henüz işlem olmadı.

        build.perform(); // Aksiyon yapiliyor

        Thread.sleep(3000);
        driver.quit();

    }
}
