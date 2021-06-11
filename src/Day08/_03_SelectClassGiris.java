package Day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

public class _03_SelectClassGiris extends BaseStaticDriver {
     /*
            select  class ı
            görünen text ile seçim:  selectByVisibleText
            value si ile seçim    :  selectByValue
            indexi ile seçim      :  selectByIndex

            seçim yaptırılabilir.

            WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

            Select menu = new Select(dropDownMenu);

            menu.selectByVisibleText("Automotive");
            menu.selectByValue("search-alias=automotive-intl-ship");
            menu.selectByIndex(2);
     */


    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.amazon.com");
        WebElement dropDownMenu=driver.findElement(By.cssSelector("select[id='searchDropdownBox']"));

        Select menu = new Select(dropDownMenu);
        menu.selectByVisibleText("Bücher"); // According to language it can be changed. (Bücher, Books, ...)

       driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Harry Potter");Thread.sleep(1000);

        driver.findElement(By.cssSelector("div.nav-search-submit.nav-sprite")).click();

        Thread.sleep(5000);
        driver.quit();


    }
}
