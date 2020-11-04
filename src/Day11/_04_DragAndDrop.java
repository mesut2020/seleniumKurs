package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _04_DragAndDrop extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Dogru secenek yesil oldugu icin, deneyererk butun baskentleri ulkelere atiniz...

        // source : box1       target : box101
        WebElement oslo = driver.findElement(By.id("box1"));                  // div.dragableBox[id^='box']
        WebElement norvec = driver.findElement(By.id("box101"));

        Actions builder = new Actions(driver);

        Action build = builder.dragAndDrop(oslo, norvec).build();
        build.perform();

        WebElement washington = driver.findElement(By.id("box3"));
        WebElement unitedStates = driver.findElement(By.id("box103"));

        build = builder.dragAndDrop(washington, unitedStates).build();
        build.perform();

        //driver.quit();
    }
}
