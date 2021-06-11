package Day08;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _02_AlisverisListeKontrol extends BaseStaticDriver {
   /*     Senaryo:
            1- https://www.saucedemo.com/ sitesine gidiniz.
            2- Login olunuz.
            3- Bütün ürünlerin isimlerini bir yerde tutunuz.
            4- Bütün ürünleri sepete atınız.
            5- Sepete tıklayınız.
            6- Sepetteki ürünlerle , ilk başta aldığını ürünlerin listesi
    birebir aynı olup olmadığını kontrol ediniz.
*/
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.xpath("//input[@id='user-name'] ")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password'] ")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button'] ")).click();

        List<WebElement> elementsList1 = driver.findElements(By.cssSelector("div.inventory_item_name"));
        ArrayList<String> list1 =new ArrayList<>();
        for (WebElement e:elementsList1 ) {
            list1.add(e.getText());
        }

        List<WebElement> addButton = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        for (WebElement e: addButton) {
            e.click();
        }
        driver.findElement(By.cssSelector("div#shopping_cart_container")).click();

        List<WebElement> elementsList2 = driver.findElements(By.cssSelector("div.inventory_item_name"));
        ArrayList<String> list2 =new ArrayList<>();
        for (WebElement e:elementsList2 ) {
            list2.add(e.getText());
        }
//        list2.remove(2); // hata gormek iicn
//        list2.add(2 , "Blue Jeans");

        int i=0;
        for (String s:list1  ) {
            if(!list1.get(i).equals(list2.get(i)))
            Assert.fail("Urun adlari esit degil = "+ list1.get(i) + " "+list2.get(i)); // hard assert ve soft assert (TestNG)...
            i++;
        }

        System.out.println(list1.get(2));
        System.out.println(list1);
        System.out.println(list2);

        driver.quit();

    }

}
