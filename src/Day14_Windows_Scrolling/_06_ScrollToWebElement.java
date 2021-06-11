package Day14_Windows_Scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;

public class _06_ScrollToWebElement extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://triplebyte.com/");

        WebElement element = driver.findElement(By.xpath("//div[@class='text-center font-bold text-3xl']"));

         js.executeScript("arguments[0].scrollIntoView();", element);
        // arguments[0] : virgülden sonraki ilk eleman
        // gözükene kadar scroll yap => scrollIntoView()

        Thread.sleep(5000);
        driver.quit();
    }
}
