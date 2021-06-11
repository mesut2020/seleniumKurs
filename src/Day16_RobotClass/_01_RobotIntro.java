package Day16_RobotClass;

import utils.BaseStaticDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Interview Sorulari
 * Windows popuplari nasil kontrol edersiniz? Robot class ile...
 * Dosya yukleme islemini ne ile yaparsiniz.? Robot class ile...
 */

public class _01_RobotIntro  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, AWTException {
        driver.get("http://www.clC:\\Users\\medog\\Desktop" +
                "ornek.txt" +
                "eartrip.com/");

        Robot robot = new Robot();

        Thread.sleep(5000);

        robot.keyPress(KeyEvent.VK_TAB); //  TAB a bastik
        robot.keyRelease(KeyEvent.VK_TAB); //  biraktik...
        Thread.sleep(1000);


        robot.keyPress(KeyEvent.VK_TAB); //  TAB a bastik
        robot.keyRelease(KeyEvent.VK_TAB); //  biraktik...
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB); //  TAB a bastik
        robot.keyRelease(KeyEvent.VK_TAB); //  biraktik...
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_ENTER); //  TAB tusu ile secilen butona ENTER ile onayladik...
        robot.keyRelease(KeyEvent.VK_ENTER); //  biraktik...
        Thread.sleep(1000);





        Thread.sleep(5000);
        driver.quit();

    }
}
