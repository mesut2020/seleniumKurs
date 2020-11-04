package Day05AndProject1.Part1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class ReadMe extends BaseStaticDriver {
    /*
        1) Bu siteye gidin. ->  http://demoqa.com/text-box
        2) Full Name kısmına "Automation" girin.
        3) Email kısmına "Testing" girin.
        4) Current Address kısmına "Testing Current Address" girin.
        5) Permanent Address kısmına "Testing Permanent Address" girin.
        6) Submit butonuna tıklayınız.
        7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
        8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.
     */

    public static void main(String[] args) throws InterruptedException {
        driver.navigate().to("http://demoqa.com/text-box");
                driver.manage().window().maximize();

        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("Automation");
        Thread.sleep(1500);
        WebElement eMail=driver.findElement(By.id("userEmail"));
        eMail.sendKeys("Testing@outlook.com");
        Thread.sleep(1500);
        WebElement curr_adress=driver.findElement(By.id("currentAddress"));
        curr_adress.sendKeys("Testing Current Address");
        Thread.sleep(1500);
        WebElement perm_adress=driver.findElement(By.id("permanentAddress"));
        perm_adress.sendKeys("Testing Permanent Address");
        Thread.sleep(1500);

        WebElement button2=driver.findElement(By.className("btn-primary"));
        button2.click();

        WebElement checkname=driver.findElement(By.id("name"));
        String namesss=checkname.getText();


       // Assert.assertEquals("Name:Automation", namesss);
        Assert.assertTrue("Automation bulunamadi...", namesss.contains("Automation"));


        Thread.sleep(1500);

        WebElement checkmail=driver.findElement(By.id("email"));
        String mails=checkmail.getText();

        //Assert.assertEquals("Email:Testing@outlook.com", mails);
        Assert.assertTrue("Mail adresi bulunamadi..",mails.contains("Testing@outlook.com"));

        Thread.sleep(3500);
        driver.quit();

    }
}
