package Day14_Windows_Scrolling;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

public class _04_ScrollIntro  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://triplebyte.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,6000)"); // sayfanin en sonuna kadar veya 6000 pixel gidinceye kadar...
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1000)");



        Thread.sleep(6000);
        driver.quit();


    }
}
