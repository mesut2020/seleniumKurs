package Day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
/*
    Senaryo
    1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
    2- random 100 e kadar 2 sayı üretiniz.
    3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
    4- Sonuçları Assert ile kontrol ediniz.
    5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.
 */

public class _04_Calculator extends BaseStaticDriver {

    public static String ekrandaIslemYap(int num1, int num2, WebElement option){
        driver.findElement(By.id("number1Field")).sendKeys("" + num1);
        driver.findElement(By.id("number2Field")).sendKeys("" + num2);

        option.click(); // Operations seciliyor...

        driver.findElement(By.id("calculateButton")).click();  // Calculate button

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#numberAnswerField.element.text.medium")));  //By.id("answerForm"))
        String actualAnswer =driver.findElement(By.cssSelector("input#numberAnswerField.element.text.medium")).getAttribute("value");
        return actualAnswer;
    }

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        Select operations = new Select(driver.findElement(By.id("selectOperationDropdown")));
        String expectedResult="";
        String op;
        WebElement answer;
        System.out.println("num1 num2 = exp : actual");

        // driver.findElement(By.id("integerSelect")).click();  // bolme isleminin sonucunun integer cikmasi icin "integers only" i check yapiyoruz.

        for (WebElement option: operations.getOptions()) {
            for (int j = 0; j <5; j++) {

                int num1 = (int)(Math.random() * 100);
                int num2 = (int)(Math.random() * 100);
                if(option.getText().equalsIgnoreCase("Add")) { expectedResult = String.valueOf(num1 + num2);op=" + ";}     // Integer.toString(int);
                else if(option.getText().equalsIgnoreCase("Subtract")) { expectedResult = String.valueOf(num1 - num2);op=" - ";}
                else if(option.getText().equalsIgnoreCase("Multiply")) { expectedResult = String.valueOf(num1  * num2);op=" x ";}
                else if(option.getText().equalsIgnoreCase("Divide")) { expectedResult = String.valueOf(Double.valueOf(num1) / num2);op=" / ";}  // bolme islemi sonucu double
                else  { expectedResult = Integer.toString(num1).concat(Integer.toString(num2));op=" & ";}

               String actualAnswer = ekrandaIslemYap(num1, num2, option);

                System.out.println(num1 + op + num2 + " = "+expectedResult + " : "+ actualAnswer);

                Assert.assertEquals("Hata: Sonuc "+expectedResult+" olmasi gerekirken, sitenin sonucu "+ actualAnswer+" cikiyor.", expectedResult, actualAnswer);

                driver.findElement(By.id("number1Field")).clear();
                driver.findElement(By.id("number2Field")).clear();
            }
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
