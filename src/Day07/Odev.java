package Day07;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class Odev extends BaseStaticDriver {
/*
1- https://www.saucedemo.com/ sitesini açınız.
2- login işlemini yapınız (login işlemi ayrı bir static metodda olsun ordan çağırınız)
3- Açılan sayfadaki bütün ürünleri sepete ekleyiniz.
4- Sepete tıklayınız
5- Sepette listelenen bütün ürünleri REMOVE yapınız.
6- Sağ üst taraftaki sepet imajındaki ürün sayısını gösteren yerin boş olduğunu Assert ile kontrol ediniz.
*/
    static void logIn(){
        driver.findElement(By.xpath("//input[@id='user-name'] ")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password'] ")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button'] ")).click();
    }
    public static void main(String[] args)  {
        driver.get("https://www.saucedemo.com");
        logIn();

        List<WebElement> addButton = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

        for (WebElement e: addButton) {
            e.click();
        }

        driver.findElement(By.cssSelector("div#shopping_cart_container")).click();

        List<WebElement> removeButton = driver.findElements(By.xpath("//button[text()='REMOVE']"));

        for (WebElement e: removeButton) {
            e.click();
        }
        List<WebElement> sepetNo = driver.findElements(By.cssSelector("span.fa-layers-counter.shopping_cart_badge"));

        if(sepetNo.size()==0) System.out.println("Sepette urun yoktur...");
        else System.out.println("Sepette kalan urun sayisi : " +driver.findElement(By.cssSelector("span.fa-layers-counter.shopping_cart_badge")).getText());
        String urunSayisi="0";

        if (sepetNo.size()!=0) urunSayisi = driver.findElement(By.cssSelector("span.fa-layers-counter.shopping_cart_badge")).getText(); // size 0 olunca elemani bulamayacagi icin hata verir

        Assert.assertEquals("HATA : Sepet bos olmasi gerekirken, sepette " + urunSayisi+" adet urun bulunmaktadir...",0, sepetNo.size());

        driver.quit();
    }
}
