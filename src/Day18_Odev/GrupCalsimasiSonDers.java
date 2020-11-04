package Day18_Odev;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

/*
Senaryo;
        1- https://www.snapdeal.com/  sitesine gidiniz.
        2- Random Bir tane ürüne tıklatınız.       .product-img>img.wooble
        3- Açılan yeni window daki ürünü sepete ekletiniz.       span.intialtext
        4- Ana Window a dönüp sepete tıklatınız.
        5- Sepete eklenen ürün ile sepete tıklattığınızdaki ekrana çıkan
        ürün ismi aynı olup olmadığını assert ile kontrol ediniz.

        */
public class GrupCalsimasiSonDers extends BaseStaticDriver {

    public static void ekrandaUrunuGoster(List<WebElement> urunler, int index) {
        WebElement next = driver.findElement(By.cssSelector("a>div>i.next-i"));// urunleri gezmek icin ok isareti olan yer...
        while(!urunler.get(index).isDisplayed()){    // secilen urunu ekran da gozukene kadar doner...
            System.out.println("Next...");
            next.click();
        }
        System.out.println(index + " index numarali urun su anda ekranda..");
    }

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.snapdeal.com/");

        String homePageID = driver.getWindowHandle();


        List<WebElement> urunler = driver.findElements(By.cssSelector("div[class='trendingProd product-relative dp-widget-link col-xs-5 favDp']>a>div+div+div>div[class='product_name']"));  // div[class='trendingProd product-relative dp-widget-link col-xs-5 favDp']   20 urun cikiyor         //div.product_name   29 tane buluyor
        // for (int i = 0; i < 5; i++) {

           int index = (int) (Math.random() * 20 + 0); // Ana sayfa ilk acildiginda 5 urun icin. index=4  den basliyor...  ama geri gelince 0 dan basliyor 0 1 2 3 4
            //int index = i;

            ekrandaUrunuGoster(urunler, index);

            String secilenUrun = urunler.get(index).getText(); // Secilen urunun textini al
            urunler.get(index).click(); // secilen urunu tikla

            Set<String> windowsIDs = driver.getWindowHandles();  // Acilan pencerelerin ID lerini al ve acilan pencereye git
            for (String id : windowsIDs) {
                if (homePageID.equals(id)) continue;
                driver.switchTo().window(id);
            }

            driver.findElement(By.cssSelector("div#add-cart-button-id")).click();   // ADD TO CART a tikla
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.cartQuantity"))); // Add to carta tikladiktan sonra sepete eklenen urun sayisini bekle...

            driver.close();  // sayfayi kapat...
            driver.switchTo().window(homePageID); // Ana sayfaya geri geliyor...

            driver.findElement(By.cssSelector("span.cartTextSpan")).click(); // SEPET e tikla...

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.item-name"))); // Sepete eklenen urunun text inin oldugu yer...
            String sepetUrun = driver.findElement(By.cssSelector("a.item-name")).getText();

            System.out.println("secilenUrun :" + secilenUrun + "    " + "sepet : " + sepetUrun);

            Assert.assertEquals("Hata:...", secilenUrun, sepetUrun);

            driver.findElement(By.cssSelector("div.remove-item-div")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("span[data-omniturename='cartCrossedNew']")).click();

       // }

        Thread.sleep(3000);
        driver.quit();
    }
}
