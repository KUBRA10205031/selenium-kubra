package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.awt.*;

public class Task_06 extends BaseTest {
    /*
    1-https://html.com/tags/iframe/ sayfasına gidelim.
    2-Video'yu görecek kadar aşağı in
    3-Video'yu izlemek için Play tuşuna basın
    4-Video'yu çalıştırdığınızı test edin.
 */

    @Test
    public void task() {
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement videoiframe= driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));
        driver.switchTo().frame(videoiframe);

       WebElement play=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
       actions.click(play).perform();

        Assert.assertFalse(play.isDisplayed());





    }
}
