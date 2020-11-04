package Day20_Project_4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

/*
 *"https://demo.sellacious.com/squick/" sayfasına gidin
 *  * Arama simgesine tıklayın ve "Canon" u arayın               div.searchactionbtn             input#finder125
 * * "Canon" kamera için "Add to cart" a tıklayın
 * * "Ödeme Yap" ı tıklayın
 * Email adresini girin ve ""Proceed" e tıklayın.
 * "Checkout as Guest"  te tıklayın.
 * Formu doldurun.(rastgele bir ülke seçilmeli) - (Eyalet ve ilçe için hiçbir şey seçmeyin)
 * Save butonuna tıklayın
 * Adresin altındaki 'Bill Here' ve 'deliver here' butonuna tıklayın ve devam etmek için oka tıklayın
 * Devam etmek için ok butonuna tıklayın
 * "Proceed to payment" butonuna tıklayın
 * "Cheque" ve "pay now" butonuna tıklayın. (burada bir bug var)
 * "Adress Adress" kutucugunu kapatmak için X 'e basın. (thread sleep)
 * "Cheque" e tıklayın ve "Pay Now" butonuna tekrar basın.
 * "Payment via Cheque approved" mesajının görüntülendiğini dogrulayın
 * Success" mesajının görüntülendiğini doğrulayın
 * "View Invoice" butonuna tıklayın ve doğru ürünü siparis ettiginizi onaylayın.
 * "View Receipt" e tıklayın ve e postanızın makbuzda dogru yazıldıgını kontol edin, onaylayın.
 *
 */
public class SeleniumProject_4 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.e-shopland.ch/sellacious/index.php");

        driver.findElement(By.cssSelector("div.searchactionbtn")).click();   // search
        driver.findElement(By.cssSelector("input#finder125")).sendKeys("canon");
        driver.findElement(By.cssSelector("button[type='submit']")).click();  // Search button

        driver.findElement(By.cssSelector("button.btn.btn-default.btn-add-cart.add")).click();  // Add to cart
        Thread.sleep(1000);
        String urunAdi = driver.findElement(By.cssSelector("a.cart-item-title")).getText();

        driver.findElement(By.cssSelector("a> button")).click();  // Checkout button

        driver.findElement(By.id("login_email")).sendKeys("techno@study.com");  // email gir
        driver.findElement(By.id("login_email_submit")).click();  // email submit button
        driver.findElement(By.id("btn_guest_checkout")).click();  // checkout as guest

//* Formu doldurun.(rastgele bir ülke seçilmeli) - (Eyalet ve ilçe için hiçbir şey seçmeyin)
// * Save butonuna tıklayın
        driver.findElement(By.id("jform0_name")).sendKeys("Ahmet Kaya");  // name
        driver.findElement(By.id("jform0_company")).sendKeys("Techno Study");  // company
        driver.findElement(By.id("jform0_address")).sendKeys("Mechul bir yer");  // adress

        driver.findElement(By.id("select2-chosen-3")).click();   // country e tikla
        List<WebElement> ulkeler = driver.findElements(By.cssSelector(".select2-result-label"));
        ulkeler.get((int)(Math.random()*252)).click();

       driver.findElement(By.cssSelector("button[class='btn btn-primary btn-save-address']")).click(); // SAVE button

//        Adresin altındaki 'Bill Here' ve 'deliver here' butonuna tıklayın ve devam etmek için oka tıklayın
// * Devam etmek için ok butonuna tıklayın
// * "Proceed to payment" butonuna tıklayın
// * "Cheque" ve "pay now" butonuna tıklayın. (burada bir bug var)
// * "Adress Adress" kutucugunu kapatmak için X 'e basın. (thread sleep)
//                * "Cheque" e tıklayın ve "Pay Now" butonuna tekrar basın.
//                * "Payment via Cheque approved" mesajının görüntülendiğini dogrulayın
//                * Success" mesajının görüntülendiğini doğrulayın
//                * "View Invoice" butonuna tıklayın ve doğru ürünü siparis ettiginizi onaylayın.
// * "View Receipt" e tıklayın ve e postanızın makbuzda dogru yazıldıgını kontol edin, onaylayın.

        driver.findElement(By.cssSelector("button[class='btn btn-small btn-default btn-bill-here']")).click();  // Bill Here
        driver.findElement(By.cssSelector("button[class='btn btn-small btn-default btn-ship-here']")).click(); //deliver here
        driver.findElement(By.cssSelector("a[class='btn btn-small btn-default btn-next pull-right']")).click(); // next1
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@class='btn btn-small btn-default btn-next pull-right'])[2]")).click(); // next2
        driver.findElement(By.xpath("//button[text()=' Proceed to Payment']")).click(); // Proceed to payment" butonuna tıklayın
        driver.findElement(By.xpath("//a[text()='Cheque']")).click(); // Cheque
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Cheque']")).click(); // Cheque

        driver.findElement(By.cssSelector("button[class='btn btn-primary btn-pay-now']")).click(); // pay now

        Thread.sleep(1000);

        String expectedInfo ="Payment via Cheque approved.";
        String actualInfo=driver.findElement(By.xpath("(//div/p)[1]")).getText();
        Assert.assertEquals("Hata", expectedInfo, actualInfo);

        String expectedSuccess = "Order placed successfully.";
        String actualSuccess = driver.findElement(By.xpath("(//div/p)[2]")).getText();
        Assert.assertEquals("Hata:...", expectedSuccess, actualSuccess);

        System.out.println(actualInfo);
        System.out.println(actualSuccess);

        //"View Invoice" butonuna tıklayın ve doğru ürünü siparis ettiginizi onaylayın.
        String homePageID = driver.getWindowHandle();
        driver.findElement(By.cssSelector("button[class='btn-action btn-invoice fa fa-file']")).click(); // View Invoice
        Set<String> windowsIDs = driver.getWindowHandles();  // Acilan pencerelerin ID lerini al ve acilan pencereye git
        for (String id : windowsIDs) {
            if (homePageID.equals(id)) continue;
            driver.switchTo().window(id);
        }

        String urunAdi2= driver.findElement(By.xpath("//td[@class='v-top']")).getText();

        System.out.println("urun1 = " + urunAdi);
        System.out.println("urun2 = " + urunAdi2);

        Assert.assertTrue(urunAdi2.contains(urunAdi));

        driver.close();  // sayfayi kapat...
        driver.switchTo().window(homePageID); // Ana sayfaya geri geliyor...

        // * "View Receipt" e tıklayın ve e postanızın makbuzda dogru yazıldıgını kontol edin, onaylayın.     button[class='btn-action btn-invoice fa fa-file-text']
        driver.findElement(By.cssSelector("button[class='btn-action btn-invoice fa fa-file-text']")).click(); // View Receipt
        windowsIDs = driver.getWindowHandles();  // Acilan pencerelerin ID lerini al ve acilan pencereye git
        for (String id : windowsIDs) {
            if (homePageID.equals(id)) continue;
            driver.switchTo().window(id);
        }

        String actualEmail = driver.findElement(By.cssSelector("div[class='sub-title text-center']")).getText(); // email
        String expectedEmail = "techno@study.com";

        driver.close();  // sayfayi kapat...

        System.out.println(actualEmail);

        Assert.assertEquals("Email yanlis...",  actualEmail.substring(4), expectedEmail); // mail deki for kismini atladik...

        Thread.sleep(5000);
       driver.quit();
    }
}
