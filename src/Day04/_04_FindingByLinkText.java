package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _04_FindingByLinkText extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com/");
        driver.manage().window().maximize();

        WebElement e = driver.findElement(By.linkText("Check Out")); // Link texti "Check Out" olana elemani bul.
        System.out.println(e.getAttribute("data-title"));  //bulunna elemanin "data-title" degerini yazdir....

        Thread.sleep(1000);

        WebElement e2 = driver.findElement(By.partialLinkText("Passion"));    // Link text i nin bir parcasi "Passion" olan elemani bul
        System.out.println(e2.getAttribute("href")); // bulunna elemanin "href" degerini yazdir....

        driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000450914895 > div > div > a > img")).click();

        System.out.println("click    click   click");
        Thread.sleep(3000);
        driver.quit();

    }
}
