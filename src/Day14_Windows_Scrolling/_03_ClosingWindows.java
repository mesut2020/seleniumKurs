package Day14_Windows_Scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

public class _03_ClosingWindows extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.selenium.dev");
        String homePageID = driver.getWindowHandle();

        List<WebElement> links = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement link : links) {
            link.click();
        }

        Set<String> windowsIDs = driver.getWindowHandles();

        for (String id : windowsIDs ) {
            System.out.println(id);
            if(homePageID.equals(id)) continue; // Ana sayfayi atlamak icin...

            driver.switchTo().window(id);
            System.out.println("Window title : " +driver.getTitle() + "   "+ driver.getCurrentUrl());
            driver.close();
        }
        driver.switchTo().window(homePageID); // Diger acilan pencereleri kapattiktan sonra ana sayfa acik kaliyor.
        // Eger tekrar ana sayfada islem yapmak istiyorsak. Ana sayfaya switchTo yapmaliyiz...
        for (WebElement link : links) {
            link.click();
        }

        Thread.sleep(10000);
        driver.quit();

    }
}