package Day17_ScreenShot;

import org.openqa.selenium.Dimension;
import utils.BaseStaticDriver;

import java.awt.*;

public class _01_WindowSize extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, AWTException {
        driver.get("https://www.yogaalliance.org/");

        Dimension dimension = driver.manage().window().getSize();
        System.out.println(dimension.getHeight());
        System.out.println(dimension.getWidth());

        Dimension newDimension = new Dimension(1024, 768);
        driver.manage().window().setSize(newDimension);  // driver.manage().window().setSize(new Dimension(1024, 768));


        Thread.sleep(5000);
        driver.quit();
    }
}
