package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import javax.swing.*;

public class C02_Actions extends BaseTest {
    /*
    1- Go to URL : https://demoqa.com/buttons
    2- Run the buttons on the page using the Acions Class.
    3- Verify the texts that appear after the buttons are operated.

     */
    @Test
    public void doubleClick(){
      driver.get("https://demoqa.com/buttons");
        WebElement doubleclickButton=driver.findElement(By.id("doubleClickBtn"));

        Actions actions =new Actions(driver);
        actions.doubleClick(doubleclickButton).perform();

        //doubleclickmessage kullanılıyor mu diye kontrol ediliyor.
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());
    }
    @Test
    public void rightClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickBtn=driver.findElement(By.id("rightClickBtn"));

        Actions actions=new Actions(driver);
        actions.contextClick(rightClickBtn).perform();

        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());


    }
    @Test
    public void click(){

        driver.get("https://demoqa.com/buttons");
        WebElement clickbutton=driver.findElement(By.xpath("//button[.='Click Me']"));

        Actions actions=new Actions(driver);
        actions.click(clickbutton).perform();

        WebElement dynamicClickMessage=driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(dynamicClickMessage.isDisplayed());


    }

}
