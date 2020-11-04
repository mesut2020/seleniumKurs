package Day05AndProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _03_FindingElements_tag extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.navigate().to("http://www.practiceselenium.com/");

        List<WebElement> liste = driver.findElements(By.tagName("li"));
        for (WebElement e:liste      ) {
            System.out.println(e.getText());
        }


        liste = driver.findElements(By.tagName("a"));

        for (WebElement e:liste      ) {
            System.out.println(e.getText());
        }

        driver.quit();
    }
}
