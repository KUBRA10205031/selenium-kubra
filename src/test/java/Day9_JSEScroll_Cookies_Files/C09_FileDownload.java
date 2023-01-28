package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C09_FileDownload extends BaseTest {

    /*
    1-Go to URL: https://opensource-demo.orangehrmlive.com/
    2-Login page valid credentials.
    3-Download sample CSV file.
    4-Verify if the file downloaded successfully.
     */

    @Test
    public void fileDownload() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //sisteme giriş yapıyoruz.

        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();


        // İndirilecek doyaya gitmek için gerekli adımlar

        WebElement pim=driver.findElement(By.xpath("//a[contains(@href,'viewPimModule')]"));
        pim.click();

        WebElement confıguratıondropdown=driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']"));
        confıguratıondropdown.click();

        WebElement dataimp=driver.findElement(By.linkText("Data Import"));
        dataimp.click();

        WebElement download=driver.findElement(By.linkText("Download"));
        download.click();


        //C:\Users\serha\Downloads ---indirilen doyamızın path'i

        String downloadpath="C:\\Users\\serha\\Downloads";

       //Dosyanın indirildiğini kontrol ediyoruz

        Assert.assertTrue("indirilen dosya bulunamadı",Files.exists(Paths.get(downloadpath)));




    }
}
