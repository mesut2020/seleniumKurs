package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class OdevDragDropGetCss_1 extends BaseStaticDriver {
    // http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
    // buradaki ülke ve şehirleri findElements ile topluca bularak bir döngü ile bütün şehirleri doğru ülkere dağıtınız.

    public static void main(String[] args) throws InterruptedException {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
       List<WebElement> countries = driver.findElements(By.cssSelector("div#questionDiv>div.destinationBox"));
        List<WebElement> capitalCities = driver.findElements(By.cssSelector("div#answerDiv>div"));

        Actions builder = new Actions(driver);

        Action build;

        for (WebElement city: capitalCities )
        {
            System.out.println();
            for (WebElement country : countries) {
                if (country.getText().length() != 0) continue;  // dolu olan kutulari atlamak icin
                build = builder.clickAndHold(city).moveToElement(country).release(country).build();
                build.perform();
                System.out.print(city.getCssValue("background-color"));
                if(city.getCssValue("background-color").equals("rgba(0, 128, 0, 1)")) break;
                //Thread.sleep(500);
            }
        }
        System.out.println("\nIslem tamamlandi...");
    }
}
