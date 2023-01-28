package Day6_DropDown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BasicAuthentication {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @After
    public void close(){
        driver.quit();

    }
    @Test
    public void basicauthentication(){
        // çıkan alert'i "https://USERNAME:PASSWORD@URL" ile handle edebiliriz.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement content=driver.findElement(By.id("content"));
        Assert.assertTrue(content.getText().contains("Congratulations"));

    }
}
