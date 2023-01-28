package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Task_03 extends BaseTest {
    /*
    1-"https://the-internet.herokuapp.com/javascript_alerts" adresine gidin.
    2- bir method oluşturun :acceptAlert
         -> 1. butona tıklayın,uyarıdaki OK butonuna tıklayın ve results mesajının "You succesfully clicked an alert" olduğunu test edin.
    3-Bir method oluşturdun:dismissAlert
        -> 2.butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "succesfully" içermediğini test edin.
    4-Bir method oluşturun: sendkeysAlert
       -> 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazın, OK butonuna tıklayın ve result mesajında isminizin içerdiğini doğrulayın.

     */
    @Test
    public void acceptalerts() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsalert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsalert.click();
        driver.switchTo().alert().accept();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You successfully clicked an alert");
    }

    @Test
    public void dismissAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsconfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsconfirm.click();
        driver.switchTo().alert().dismiss();

        WebElement result= driver.findElement(By.id("result"));
        Assert.assertFalse(result.getText().contains("succesfully"));

    }

    @Test
    public void sendkeysAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement sendkeysAlert=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        sendkeysAlert.click();
        driver.switchTo().alert().sendKeys("kübra");
        driver.switchTo().alert().accept();

        WebElement result=driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("kübra"));

    }
}
