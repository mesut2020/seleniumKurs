package Day05AndProject1.Part3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class ReadMe extends BaseStaticDriver {
    /*
        1) Bu siteye gidin. -> https://www.snapdeal.com/
        2) "teddy bear" aratın ve  Search butonuna tıklayın.
        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 918 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.
        4) Snepdeal logosuna tıklayınız.
        5) URL'in bu olduğunu doğrulayın. (https://www.snapdeal.com/)
     */
    public static void main(String[] args) throws InterruptedException {
        driver.navigate().to("https://www.snapdeal.com/");

        WebElement search = driver.findElement(By.id("inputValEnter"));
        search.sendKeys("teddy bear");

        driver.findElement(By.className("searchTextSpan")).click();

        String expectedResult = "We've got 1499 results for 'teddy bear'";

        Thread.sleep(2000);
        String result = driver.findElement(By.className("marT12")).getText();

        Assert.assertEquals(expectedResult, result); // buldugu sayilar degisiyor...

        WebElement elementUrl = driver.findElement(By.className("cur-pointer"));
        //Thread.sleep(3000);
        elementUrl.click();
        String expectedUrl = "https://www.snapdeal.com/";

        Assert.assertEquals(expectedUrl, driver.getCurrentUrl() );

        Thread.sleep(3000);
        driver.quit();

    }
}
