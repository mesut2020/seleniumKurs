package Day14_Windows_Scrolling;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;
/*
    Selenium da sayfayi asagi kaydirilmasi gereken durumlar vardr
    bunlar sayfa kaydirildikca yuklenen elemanlar icin ve sayfanin
    ustunde olusan ek popuplar in konumun kaydrilmasidir

    cunku uzernde popup olan eleman tiklatilamaz

    Bu islem javascript executer ile yapilir Bu interface sayaseinde sayfa
    kaydirma islemi ve javascript ve javascript komutlari calistrilabilir
    sayfa uzerinde

 */
public class _04_ScrollIntro  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://triplebyte.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,6000)"); // sayfanin en sonuna kadar veya 6000 pixel gidinceye kadar...
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1000)");



        Thread.sleep(6000);
        driver.quit();


    }
}
