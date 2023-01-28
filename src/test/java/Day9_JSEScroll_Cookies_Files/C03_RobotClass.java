package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C03_RobotClass extends BaseTest {
    @Test
    public void robotClass() throws AWTException, InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement input= driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        input.sendKeys("C:\\Users\\serha\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\robot.txt");

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL); //keypress tuşa basılı tutar. ctrl'ye bastık.
        robot.keyPress(KeyEvent.VK_S); // s tuşuna bastık.
        //Thread.sleep(5000);
        robot.keyRelease(KeyEvent.VK_CONTROL); // control tuşunu serbest bırakıyorum.
        robot.keyRelease(KeyEvent.VK_S); // s tuşundan elimi kaldırıyorum.
        //Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_ENTER); // enter tuşuna bastık.
        robot.keyRelease(KeyEvent.VK_ENTER); //enter tuşundan elimizi çekiyoruz.
        //Thread.sleep(5000);




    }
}
