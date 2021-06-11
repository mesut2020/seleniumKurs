package Day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import utils.BaseStaticDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
   Senaryo :
        1- https://opensource-demo.orangehrmlive.com/  sitesine gidiniz.
        2- Login işlemini yapınız.
        3- Welcome yazan sağ üst tarafta kullanıcı adının geçip geçmediğini kontrol ediniz.
        4- Eğer Kullanıcı adınız gözükmüyorsa , ekran görünütüsnü kaydedip, ilgili kişiye gönderiniz.
 */
public class _02_ScreenShot  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        WebElement userName = driver.findElement(By.id("welcome"));
        String welcome = userName.getText();

        System.out.println(welcome);

        if (welcome.contains("Admin"))
        {
            System.out.println("Test Passed...");
        }
        else
        {
            System.out.println("Test Failed...");
            // Ekran kaydetme işlemleri burada olacak.

            // 1. Asama : ekran goruntusu alma degsikenini tanimladik...
            TakesScreenshot ts = (TakesScreenshot) driver;

            // 2. Asama : alinacak Ekran goruntusu dosyasi tipi secilerek olsuturuldu...
            File screenFile = ts.getScreenshotAs(OutputType.FILE);

            // 3. Asama: Ekran dosyasini bir dosyaya yazma/kopyalama islemi yapiliyor...
            // DosyaKopyala (ekranDosyasi, ekranGoruntusu.png)
            // Yukaridaki komut JAVA nin iicnde yok, ayni Selenium u ekledigimiz gibi ekleyecegiz.
            // bu kutuphane common.io bu apache sitesinden indirilecek.
            FileUtils.copyFile(screenFile, new File("EkranGoruntuleri/orangehrm/LoginKontrol"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm ss"))+".png"));
            // hafizadaki ekran dosyasini al ve verdigim yola ve isme kaydet...
            // jpg, bmp, gif
            System.out.println(LocalDateTime.now());
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));


        }


        Thread.sleep(5000);
        driver.quit();
    }
}
