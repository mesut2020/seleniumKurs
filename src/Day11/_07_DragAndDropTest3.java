package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _07_DragAndDropTest3 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php"); // siteyi açtım
        driver.manage().window().maximize();

        WebElement slider=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]"));

        Actions builder=new Actions(driver);
        Action build=builder.dragAndDropBy(slider, 100, 0).build();
        Thread.sleep(2000);
        build.perform();

        Thread.sleep(6000);
        driver.quit();
    }
}