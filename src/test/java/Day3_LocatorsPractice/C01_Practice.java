package Day3_LocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Practice {

    /*
    1- Go to https://www.linkedin.com/
    2- When we write an e-mail without the @sign in the e-mail box and press enter.
    3- Let's test the "Invalid e-mail adress" warning.
     */

     WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void XpathPractice() throws InterruptedException {
        //1.Adım --> Lınkedin sitesine git.
        driver.get("https://www.linkedin.com/");

        //2.Adım --> email alanına @ sembolü bulunmayan bir email adresi gir.
       WebElement email= driver.findElement(By.xpath("//input[@id='session_key']"));
       email.sendKeys("ıttesterkubra"+ Keys.ENTER);
       email.getText();

        // 3.Adım --> Hata mesajının görüntülendiğini doğrula.
       WebElement alertMessage=driver.findElement(By.xpath("//p[@class='alert-content']"));
       Assert.assertTrue(alertMessage.isDisplayed());
       //Assert.assertEquals(true,alertMessage.isDisplayed()); diğer yollar.
        //Assert.assertFalse(!alertMessage.isDisplayed());
    }








}
