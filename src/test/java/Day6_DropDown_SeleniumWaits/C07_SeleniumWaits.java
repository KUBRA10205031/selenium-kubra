package Day6_DropDown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.time.Duration;

public class C07_SeleniumWaits extends BaseTest {
    //Explicit Wait ----->>> local bekleme belirli bir elemet için bekleme
    @Test
    public void webDriverWait(){

        driver.get(" https://demoqa.com/interaction ");

        //Adım1: -> WEbdriverwait objemiz oluşturuldu.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement category= driver.findElement(By.xpath("(//div[@class='icon'])[2]"));

        // elementToBeClickable(WEBelement)
        wait.until(ExpectedConditions.elementToBeClickable(category)).click();

        //elementToBeClickable(By)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//li[contains(.,'Practice Form')]")))).click();


    }

}
