package Day6_DropDown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Alerts {

    /*
    1- Go to URL: hettp://demo.guru99.com/test/delete_customer.php
    2- Delete customer ID  :123
    3- Delete 2 alerts that appear.
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void alerts(){
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        WebElement idInput= driver.findElement(By.name("cusid"));
        idInput.sendKeys("123");
        WebElement submit=driver.findElement(By.name("submit"));
        submit.click();
        driver.switchTo().alert().accept();//çıkan uyarıyı switch to methodu ile o sayfaya geçtik
                                           // alert.accept ile de  tamam 'a tıklayarak handle ettik.

        driver.switchTo().alert().accept();// çıkan ikinci uyarıyı da tamam ' a tıklayarak kabul ettik.
    }














}
