package Day14_Windows_Scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

public class _01_OpenWindows extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.selenium.dev");

        List<WebElement> links = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement link:links) {
            link.click();
        }

        Set<String> windowIDleri = driver.getWindowHandles();

        for (String id : windowIDleri ) {
            System.out.println(id);   // acilan pencerelriin
        }
//        CDwindow-2FB406533FC5374AC9E6831D9FFEFBF1
//        CDwindow-98D9DCDEED7631FE587486A2DAD5145F
//        CDwindow-52575D9610B9D797E77AE2F70A68F948

        Thread.sleep(8000);
        driver.quit();

    }
}
