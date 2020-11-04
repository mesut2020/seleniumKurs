package Day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _02_XPathLogInTest extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com");

       String pass = "secret_sauce";

        String users = driver.findElement(By.cssSelector("div[class='login_credentials']")). getText();
        String[] userArr = users.split("\n");

        for(int i=1; i<userArr.length;i++)
        {
            driver.findElement(By.xpath("//input[@id='user-name']")).clear();
            driver.findElement(By.xpath("//input[@id='user-name'] ")).sendKeys(userArr[i]);

            driver.findElement(By.xpath("//input[@id='password']")).clear();
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);

            driver.findElement(By.xpath("//input[@id='login-button'] ")).click();


            //findelement ile findelements dönüşlerinin farkı nedir?
            //findelement 1 element bulur, bulamazsa NoSuchElementException hatasını üretir.
            //findelements çoklu elements bulur, bulamazsa size 0 gönderir.

            List<WebElement> txtProducts = driver.findElements(By.xpath("//div[text()='Products']"));

            if (txtProducts.size() == 1)
            {
                System.out.println(userArr[i] + "--> login oldu");
                driver.navigate().back();
            }
            else
            {
                WebElement errorElement=driver.findElement(By.xpath("//h3[@data-test='error']"));
                System.out.println(userArr[i] +"-->"+ errorElement.getText());
            }
        }

       // driver.quit();

    }
}
