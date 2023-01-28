package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practice {
    /*
    1- Navigate to website https://testpages.herokuapp.com/styled/index.html
    2- Under to ORIGINAL CONTENTS
    3- Click on Alerts
    4- Print the URL
    5- Navigate back
    6- Print the URL
    7- Click on Basic Ajax
    8- Print the URL
    9- Enter value -> 20 and Enter
    10- And then verify Submitted Values is displayed open page.
    11- Close driver.

     */

    WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }
    @After
    public void close(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        WebElement alerts= driver.findElement(By.xpath("//a[@id='alerts']"));
        alerts.click();
        Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);

        WebElement basicajax= driver.findElement(By.xpath("//a[@id='basicajax']"));
        basicajax.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);

        WebElement degergırısı= driver.findElement(By.xpath("//input[@id='lteq30']"));
        degergırısı.sendKeys("20"+Keys.ENTER);
        Thread.sleep(5000);

        //Subbmitted value yazısının görüntülendiğini doğrula.
        WebElement SubmittedValue=driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(SubmittedValue.isDisplayed());
        Thread.sleep(5000);


    }



}
