package Day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

/*
         İnterview Sorusu :  Implicit ve Explicit

         Implicit : Bütün elemanlar için kullanılır.bir kere tanımlanır.
         Explicit : Tek bir eleman özel Kriter olarak tanımlanır sadece ilgili elemanda geçerli olur
                   ExpectedConditions
                                     .titleIs -> title bu olana kadar bekle
                                     .titleContains -> title ın da bu kelime geçene kadar bekle
                                     .visibilityOfTheElement -> eleman gözükene kadar bekle
                                     .elementToBeClickable -> eleman tıklanabilir olana kadra bekle
                                     .elementToBeSelected -> eleman seçilebilir olana kadra bekle
                                     .alertIsPresent()  -> alert çıkana kadar bekle.
                                     .textToBe -> elemanda verilen txt gözükene kadar bekle.
                                     .InvisibilityOfTheElement -> eleman kaybolana kadar bekle

         Her ikisi tanımlı ise : önce Implicit kullanılır, ve üzerine Explicit in süresi eklenerek
                                  toplam hata sınır süresi ortaya çıkmış olur.
 */

public class _02_ExplicitWait  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
        driver.findElement(By.id("title")).sendKeys("Beklemem Komutu");
        driver.findElement(By.id("description")).sendKeys("Explicit eleman ozel kriter oludana kadar bekleme seklidir...");
        driver.findElement(By.id("btn-submit")).click();





        WebDriverWait wait = new WebDriverWait(driver, 15);

        Boolean yaziOlustu=wait.until( ExpectedConditions.textToBe( By.id("submit-control"), "Form submited Successfully!"));


        //Thread.sleep(5000);
        //driver.quit();

    }
}