package Day15_Project_3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Project1 extends BaseStaticDriver {
    /*
        Manuel bir şekilde web sitesine kayıt olun. (Kendi hesabınızı oluşturun)
        Bu siteye gidin ->  https://app.hubspot.com/login

        Email address ve Password girdikten sonra Log in buttonuna tıklayınız.         username     password        loginBtn

        Sales'a tıklayınız.           div.menu         (//a[@id='nav-primary-sales-branch'])[2]
        Deals'a tıklayınız.           (//a[@id='nav-secondary-deals'])[2]

        Create Deal'a tıklayınız. (Note: Otomasyon sırasında Deal'a tıkladığınızda tablo gözükmeyebilir. Browser'ı yenileyin. (refresh) )                     button[data-button-use='primary']
        Deal name giriniz.                               #UIFormControl-31

        Sales Pipeline'a tıklayınız. (İkinci websitesinin URL'inin bu URL olduğunu doğrulayınız. -->https://app.hubspot.com/pricing/7766931/sales?upgradeSource=deals-create-deal-general-create-deal-multiple-pipelines-pql-feature-lock&term=annual&edition=starter )
        Deal Stage dropdown'undan rastgele bir şey seçiniz.
        Deal Type dropdown'undan rastgele bir şey seçiniz.
        Create button'a tıklayınız.

        Sol üstte, Verdiğiniz isimin yanındaki küçük kalem simgesine tklayınız.
        Deal name'i değiştiriniz.
        Save'e tıklayınız.
        Deal Name'in değiştiğini doğrulayınız.

        "Actions" button'una tıklayınız.
        Delete'e tıklayınız.
        Delete deal'a tıklayınız.

        Deal'ın artık görünmediğini doğrulayınız.
     */
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://app.hubspot.com/login");
        String homePageID = driver.getWindowHandle();

//        driver.findElement(By.id("username")).sendKeys("medogan@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("Rudes1234");
//        driver.findElement(By.id("loginBtn")).click();

        driver.findElement(By.className("google-sign-in")).click();
        driver.findElement(By.id("identifierId")).sendKeys("medogan@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        driver.findElement(By.name("password")).sendKeys("Med_12345");
        driver.findElement(By.id("passwordNext")).click();

        driver.findElement(By.xpath("(//a[@id='nav-primary-sales-branch'])[1]")).click();   // Sales'a tıklayınız.
        driver.findElement(By.xpath("(//a[@id='nav-secondary-deals'])[1]")).click();   // Deals'a tıklayınız.

       Thread.sleep(1000);
        //driver.navigate().refresh();
        driver.navigate().to(driver.getCurrentUrl());


        driver.findElement(By.cssSelector(" button[data-button-use='primary']")).click();   // Create Deal'a tıklayınız. (Note: Otomasyon sırasında Deal'a tıkladığınızda tablo gözükmeyebilir. Browser'ı yenileyin. (refresh) )
        driver.findElement(By.id("UIFormControl-31")).sendKeys("Mesut");
        driver.findElement(By.id("uiabstractdropdown-button-61")).click();

        Set<String> windowsIDs = driver.getWindowHandles();

        for (String id : windowsIDs ) {
            if(homePageID.equals(id)) continue;
            driver.switchTo().window(id);
            Assert.assertEquals("HATA: yeni sayfaya ulasilamadi...", "https://app.hubspot.com/pricing/8445712/sales?upgradeSource=deals-create-deal-general-create-deal-multiple-pipelines-pql-feature-lock&term=annual&edition=starter", driver.getCurrentUrl());
            System.out.println("Ikinci WebSayfasinin URL si dogrulandi...");
        }
        driver.close();
        driver.switchTo().window(homePageID); // Ana sayfaya geri geliyor...
        // Deal Stage
        driver.findElement(By.cssSelector("#UIFormControl-35 > span > span.private-dropdown__button-label.uiDropdown__buttonLabel")).click(); // deal stage e tiklamazsak menu deki elementler gorunur olmuyor
        List<WebElement> dealStage = driver.findElements(By.xpath("//li/span/button"));
        dealStage.get((int)(Math.random()*7)).click();
        // Deal Type
        driver.findElement(By.cssSelector("#uiabstractdropdown-button-49 > span > span.private-dropdown__button-label.uiDropdown__buttonLabel")).click();
        List<WebElement> dealType = driver.findElements(By.cssSelector("div.Select-option"));
        dealType.get((int)(Math.random()*2+1)).click();
        driver.findElement(By.cssSelector("li.uiListItem.private-list__item.p-bottom-1>button")).click();  //  Create butona tikla

        driver.findElement(By.cssSelector("div.UIAbstractColumn__ColumnWrapper-vkv1rx-0.ggAAfp.m-top-1.align-self-start.UIColumn-content")).click();   // kaleme tikla

        driver.findElement(By.cssSelector("input[id^='UIFormControl-']")).clear();
        //Thread.sleep(500);
        driver.findElement(By.cssSelector("input[id^='UIFormControl-']")).sendKeys("Fatih");   //        Deal name'i değiştiriniz.

        driver.findElement(By.xpath("//i18n-string[text()='Save'] ")).click();  //   Save'e tıklayınız.

        //Thread.sleep(2000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h3[text() = 'Fatih']")));

        //        Deal Name'in değiştiğini doğrulayınız.
        Assert.assertEquals("HATA: isim yanlis", "Fatih", driver.findElement(By.cssSelector("h3.m-bottom-0")).getText()); //Thread.sleep(500); //        Deal Name'in değiştiğini doğrulayınız.
        System.out.println("Deal Name degistirme islemi dogrulandi...");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id^='uiabstractdropdown-button-']")));
        driver.findElement(By.cssSelector("button[id^='uiabstractdropdown-button-']")).click();   //        "Actions" button'una tıklayınız.

        //Thread.sleep(500);
        driver.findElement(By.xpath("//*[contains(text(),'Delete')]")).click(); //        Delete'e tıklayınız.
        //Thread.sleep(500);
        driver.findElement(By.cssSelector("button[data-selenium-test='delete-dialog-confirm-button']")).click();   //        Delete deal'a tıklayınız.
//
        Thread.sleep(4000); // kac DEAL oldugunu goteren yazi gec ciktigi icin  bekletme...

        WebElement numberOfDeal = driver.findElement(By.cssSelector("div.private-microcopy.IndexPageRedesignHeader__StyledTitleDetails-ljkrr-0.kbeUyE>i18n-string"));//        Deal'ın artık görünmediğini doğrulayınız.
        System.out.println(numberOfDeal.getText());
        int numDeal = Integer.parseInt(numberOfDeal.getText().replaceAll("[^0-9]", ""));
        System.out.println("Number of Deal(s) : " + numDeal);

        if(numDeal>0) {
            driver.findElement(By.cssSelector("span.private-checkbox__indicator")).click();
            driver.findElement(By.cssSelector("span[data-icon-name='delete']")).click();
            WebElement numberOfDealsToDelete = driver.findElement(By.cssSelector("textarea[data-selenium-test='delete-dialog-match']"));
            System.out.println(numberOfDealsToDelete.getAttribute("data-match-value"));Thread.sleep(2000);
            numberOfDealsToDelete.click();Thread.sleep(2000);
            numberOfDealsToDelete.sendKeys(numberOfDealsToDelete.getAttribute("data-match-value"));Thread.sleep(2000);  // silinecek DEAL sayisini giriyoruz
            driver.findElement(By.cssSelector("button[data-selenium-test='delete-dialog-confirm-button']")).click(); //Delete
            driver.navigate().refresh();
            Thread.sleep(4000); // Kac Deals oldugunu gostermesi zaman aliyor....
        }
        //Asagida Deal sayisini tekrar buldum. yoksa hata veriyor...
        Assert.assertEquals("HATA: Dealler hala gorunuyor :)", 0, Integer.parseInt(driver.findElement(By.cssSelector("div.private-microcopy.IndexPageRedesignHeader__StyledTitleDetails-ljkrr-0.kbeUyE>i18n-string")).getText().replaceAll("[^0-9]", "")));

        Thread.sleep(5000);
        driver.quit();

    }
}
