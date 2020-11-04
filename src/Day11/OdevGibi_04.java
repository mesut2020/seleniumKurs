package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class OdevGibi_04 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();


        // Dogru secenek yesil oldugu icin, deneyererk butun baskentleri ulkelere atiniz...

        // source : box1       target : box101
        List<WebElement> cities = driver.findElements(By.cssSelector("div.dragableBox[id^='box']"));                  // div.dragableBox[id^='box']
        List<WebElement> countries = driver.findElements(By.cssSelector("div#countries>div"));

        Actions builder = new Actions(driver);

        Action build;
        for (WebElement city : cities) {
            for (WebElement country : countries) {
                if (country.getText().length() > 13)
                    continue;  // Kutular boskan en fazla 13 karakter var. United States. Dolu olanlari atlamak icin.
                build = builder.dragAndDrop(city, country).build();
                build.perform();
                if (city.getCssValue("background-color").equals("rgba(0, 255, 0, 1)")) break;

                Thread.sleep(100);
            }
        }


        //driver.quit();
    }
}