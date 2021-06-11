package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class OdevDragDropGetCss_2 extends BaseStaticDriver {

    //http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html
    // buradaki bütün öğrencileri bütün kutucukları doldurana kadar atınız.

    public static void main(String[] args) throws InterruptedException {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

        List<WebElement> students = driver.findElements(By.cssSelector("ul#allItems>li")); //  ul#allItems>li
        List<WebElement> boxes = driver.findElements(By.cssSelector("div#dhtmlgoodies_mainContainer>div"));
        Actions builder = new Actions(driver);
        Action build;
        int a=0;
        Thread.sleep(1000);
        for (int j=0; j<students.size();j++) {
            for (int i=a;i<boxes.size();i++) {
                build = builder.clickAndHold(students.get(j)).moveToElement(boxes.get(i)).release(boxes.get(i)).build();
                build.perform();
                if(boxes.get(i).getText().contains(students.get(j).getText())) break;
                else a++;   // kutu dolunca 1 artar ve dolu kutuya baktirmmis olur....
            }
        }


    }
}
