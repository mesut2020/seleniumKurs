package Day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.sql.SQLOutput;

public class _02_ElemaninStatusu extends BaseStaticDriver {
    /*
    boolean isSelected();   checkbox, radiobutton
    boolean isEnabled();
    boolean isDisplayed();

    isEnabled
    Monday -> true
    Sunday -> false

    isSelected();
    Tuesday -> true
    Thursday -> false

    isDisplayed();
    Monday -> true
    Sunday -> true
    */
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(1000);
        WebElement sali = driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));
        System.out.println("-----SALI----");
        System.out.println("Displayed :" +sali.isDisplayed());
        System.out.println("Enabled :" +sali.isEnabled());
        System.out.println("Selected :" +sali.isSelected());
        sali.click();
        System.out.println("Selected :" +sali.isSelected());

        System.out.println("-----PAZAR----");
        WebElement pazar = driver.findElement(By.id("gwt-debug-cwCheckBox-Sunday-input"));
        System.out.println("Displayed :" +pazar.isDisplayed());
        System.out.println("Enabled :" +pazar.isEnabled());
        System.out.println("Selected :" +pazar.isSelected());


        Thread.sleep(5000);
        driver.quit();
    }
}
