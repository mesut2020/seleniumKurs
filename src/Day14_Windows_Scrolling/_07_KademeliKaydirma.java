package Day14_Windows_Scrolling;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _07_KademeliKaydirma extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://de.hotels.com/search.do?resolved-location=CITY%3A336647%3AUNKNOWN%3AUNKNOWN&destination-id=336647&q-destination=Frankfurt,%20Hessen,%20Deutschland&q-check-in=2020-09-11&q-check-out=2020-09-12&q-rooms=1&q-room-0-adults=2&q-room-0-children=0");
        Thread.sleep(1000);
        new Actions(driver).sendKeys(Keys.ESCAPE).perform(); // Cikan takvim i iptal etmek icin
        WebElement link = pageScrollToFindElement(driver, By.cssSelector("button[type='button']"), 100);
        System.out.println("Simdi Burada");

        System.out.println(link.getText());
        driver.quit();
    }

    // kaydirma sonrasi bulunan elementi return eder
    public static WebElement pageScrollToFindElement(WebDriver driver, By selector, int pixelToDown) throws InterruptedException {
        WebElement element = null;
        boolean objFound = false;
        int currentPixel = 0;
        while (!objFound) {
            try {
                element = driver.findElement(selector);
                objFound = true;
            } catch (Exception ignored){
                scrollPage(driver, pixelToDown);
                currentPixel+=pixelToDown;
                System.out.println(bodyHeight(driver));
                //Thread.sleep(100);
            };
        }
        return element;
    }

    // sayfayi pixel miktarinca agagi kaydirir
    public static void scrollPage(WebDriver driver, int pixel){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, '"+ pixel + "')");
    }

    // sayfanin o anki max yüksekligi
    public static int bodyHeight(WebDriver driver){
        String height = ((JavascriptExecutor)driver)
                .executeScript("return document.body.scrollHeight;").toString();
        return Integer.parseInt(height);

    }
}
