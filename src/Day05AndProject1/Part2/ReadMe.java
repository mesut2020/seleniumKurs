package Day05AndProject1.Part2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class ReadMe extends BaseStaticDriver {
    /*
        1) Bu siteye gidin. -> https://demo.applitools.com/
        2) Username kısmına "ttechno@gmail.com" girin.
        3) Password kısmına "techno123." girin.
        4) "Sign in" buttonunan tıklayınız.
        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.(Assert kullanın )
        6) URL'in bu olduğunu doğrulayın. -> https://demo.applitools.com/app.html   (Assert kullanın )

     */
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demo.applitools.com/");
        driver.manage().window().maximize();
        WebElement user2=driver.findElement(By.id("username"));
        user2.sendKeys("ttechno@gmail.com");
        Thread.sleep(1500);
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("techno123.");
        Thread.sleep(1500);
        WebElement giris=driver.findElement(By.id("log-in"));
        giris.click();
        Thread.sleep(1500);

        WebElement checktime=driver.findElement(By.id("time"));
        String times=checktime.getText();

        Assert.assertEquals("Your nearest branch closes in: 30m 5s", times);
        String url=driver.getCurrentUrl();
        Assert.assertEquals("https://demo.applitools.com/app.html",url);
                driver.quit();
    }
}
