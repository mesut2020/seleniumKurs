package Day14_Windows_Scrolling;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

public class _05_ScrollToButtomOfThePage extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://triplebyte.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");  // - yazinca yikari cikar...


    }
}
