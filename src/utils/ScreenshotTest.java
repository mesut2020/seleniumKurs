package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends BaseStaticDriver {
    public static void main(String[] args) throws IOException {

        driver.navigate().to("http:/www.google.com");

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // ekran goruntusunu dosya oalrak kaydeder
        // jar dosyalari burdan indirilecek... https://commons.apache.org/proper/commons-io/download_io.cgi
        FileUtils.copyFile(src,new File("C:\\Work\\screenshot.txt"));  // screen shot un kaydedilecegi yer. Bundan once jar dosyalarini eklemek gerekiyor.
        // File > Project structure > Modules > Dependencies > + 'a tikla Jars or Directories i secip jar dosyalarini yukle.
        System.out.println(src); // C:\Users\medog\AppData\Local\Temp\screenshot10674979569731454927.png

        driver.quit();
    }
}
