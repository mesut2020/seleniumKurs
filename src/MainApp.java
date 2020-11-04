import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com.tr/");
        //driver.navigate.to("https://www.google.com.tr/"); // sayfanin

        driver.manage().window().maximize();
// id veya name >  tag  ve link  veya class name > css Selector > X path  //
        driver.findElement(By.name("q")).sendKeys("Automation Testing in Germany");

        Thread.sleep(500);

        driver.findElement(By.className("RNmpXc")).click();

        driver.findElement(By.name("sc.keyword")).clear();
        driver.findElement(By.name("sc.keyword")).sendKeys("junior test automation engineer");

        //Thread.sleep(1000);

        driver.findElement(By.className("gd-btn-mkt")).click();

        List<WebElement> list = driver.findElements(By.tagName("script"));

        System.out.println(list);

        //*[@id="respProductListPLPMachine-8797528041232-5997c840-0c93-46a0-9df4-a1c35e5776db"]/div/div/div[2]/div[3]/div/article/div[2]/a

        //driver.quit();  // butun acilmis tarayicilari kapatir
        // driver.close(); sadece aktif ola sayfayi kapatir.






    }
}
