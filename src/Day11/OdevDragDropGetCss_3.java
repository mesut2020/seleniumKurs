package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class OdevDragDropGetCss_3 extends BaseStaticDriver {
    //http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html
    // buradaki bütün şehirleri bütün ülkere doğru şekilde topluca dağıtınız.
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");

        List<WebElement> cities = driver.findElements(By.cssSelector("#allItems>li"));
        List<WebElement> countries = driver.findElements(By.cssSelector("#dhtmlgoodies_mainContainer>div>ul"));

        Actions builder = new Actions(driver);

        Action build;
        Thread.sleep(500);

//        for (int i = cities.size()-1; i >= 0 ; i--) {
//            for (int j=0; j<countries.size();j++) {
//                build = builder.clickAndHold(cities.get(i)).moveToElement(countries.get(j)).release(countries.get(j)).build();
//                build.perform();
//                //Thread.sleep(500);
//                if (i+1==cities.size()) break;
//                if(cities.get(i).getCssValue("background-color").equals("rgba(0, 128, 0, 1)")) break;
//            }
//        }


        for (WebElement city : cities) {
            for (WebElement country : countries) {
                build = builder.clickAndHold(city).moveToElement(country).release(country).build();
                build.perform();

                    if (cities.get(cities.size() - 1) == city) {
                        System.out.println("The last action...");
                        Thread.sleep(3000);
                        driver.switchTo().alert().accept();   // acilan JavaScript penceresini kapatmak icin
                        Thread.sleep(3000);
                    }
                    if (city.getCssValue("background-color").equals("rgba(0, 128, 0, 1)")) break;

            }
        }

    }
}
