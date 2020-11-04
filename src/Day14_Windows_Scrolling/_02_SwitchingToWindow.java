package Day14_Windows_Scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

public class _02_SwitchingToWindow  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.selenium.dev");
        String homePageID = driver.getWindowHandle();

        List<WebElement> links = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement link : links) {
            link.click();
        }

        Set<String> windowsIDs = driver.getWindowHandles();

        for (String id : windowsIDs ) {
            if(homePageID.equals(id)) continue;
            System.out.println(id);
            driver.switchTo().window(id);
            System.out.println("Window title : " +driver.getTitle() + "   "+ driver.getCurrentUrl());
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
