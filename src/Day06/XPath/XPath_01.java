package Day06.XPath;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseStaticDriver;

import java.io.IOException;

public class XPath_01 extends BaseStaticDriver {
/*1- https://www.saucedemo.com/  sitesini açın                standard_user        secret_sauce
            2- login işlemini yapınız.                                         //input[@id='user-name']      //input[@id='password']    //input[@id='login-button']
3- Sauce Labs Backpack  a tıklatın ve sepete ekletin.         //div[text()='Sauce Labs Backpack']       //button[text()='ADD TO CART']
            4- Sonra geri dönün                                               //button[text()='<- Back']
5- Sauce Labs Bolt T-Shirt  a tıklatın ve sepete ekleyin.     //div[text()='Sauce Labs Bolt T-Shirt']   //button[text()='ADD TO CART']
            6- sepete tıklatın                                                  //div[@id='shopping_cart_container']
7- CheckOut a tıklatın
8- kullanıcı bilgilerini doldurup Continue ya tıklatın
9- Burada her bir eşyanın ücretlerinin toplamının
    aşağıdaki Item total e eşit olup olmadığını Assert ile test
    ediniz.

    xpath de css selectordeki tag basina // koyulur ve parametrenin basina @ konulur
   css in eleman bulmada zorlandigi veya ise yaramadigi yerlerde kullanilir

   css selector de tag in text i kullanilmazken xpath de text ile eleman bulunabilir
   //div[text()='text'] -->> parametre girmedigimiz icin @ isareti kullanmadik !!!
       */
//             //div[text()='Sauce Labs Backpack']/parent::*/parent::div -> /parent::*  bir üst e gider.parent e
//             //div[text()='Sauce Labs Backpack']/../../..   -> aynı işlemi para üste gider /..  ile
//            ((//div[@id='inventory_container'])[1]/div/div)[2]   -> [2] den önceki kısımda bulunan elamanlardan 2.sini bulur
//            // (//div[@id='inventory_container'])[1]/div/div/following-sibling::div  -> /following-sibling::div kardeş div i bulur

static double stringToDouble(String ucret){
    ucret=ucret.replaceAll("[^\\d.]", "");
    return Double.parseDouble(ucret);
}

    public static void main(String[] args) throws InterruptedException, IOException {
        driver.navigate().to("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name'] ")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password'] ")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button'] ")).click();

        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();
        driver.findElement(By.xpath("//button[text()='<- Back']")).click();

        driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).click();
        driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
        driver.findElement(By.xpath("//button[text()='<- Back']")).click();

        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

        driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click(); Thread.sleep(500);

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Mesut");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Dogan");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();

        String fiyat1 =driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();  //$29.99
        String fiyat2 =driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[2]")).getText();  //$15.99
        String strItemTotal =driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();  //Item total: $45.98

        double expectedItemTotal= stringToDouble(fiyat1) + stringToDouble(fiyat2);

        double siteActualTotal = stringToDouble(strItemTotal);

        System.out.println(fiyat1);
        System.out.println(fiyat2);
        System.out.println(strItemTotal);

        System.out.println(expectedItemTotal);

        Assert.assertEquals("HATA : Sayfada cikan sonuc:  $" + siteActualTotal + ", beklenen sonuc: $" + expectedItemTotal, expectedItemTotal,siteActualTotal,0); // delta 0 olursa tam esit olmali
       // Assert.assertEquals(45.96, siteTotal, 0.02); // aralarindaki fark  0.2 az veya 0.1 fazla olunca da dogru kabul ediyor...

        Thread.sleep(1000);
        driver.quit();
    }
}
