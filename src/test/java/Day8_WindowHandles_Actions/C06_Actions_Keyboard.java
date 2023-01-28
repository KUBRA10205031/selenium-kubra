package Day8_WindowHandles_Actions;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C06_Actions_Keyboard extends BaseTest {
/*
1- Go to URL :"https://demoqa.com/auto-complete
2- In the Type single color name section, print "You are Exceptinal"by using the action methods.

 */
    @Test
    public void keyboardActions(){
        driver.get("https://demoqa.com/auto-complete");
        WebElement input= driver.findElement(By.id("autoCompleteSingle"));
        Actions actions=new Actions(driver);
        actions
                .click(input)
                .keyDown(Keys.SHIFT)   // shift tuşuna basılı tut.
                .sendKeys("y")         // y harfine bas (büyük yazmak için)
                .keyUp(Keys.SHIFT)     // shift tuşundan elini kaldır.
                .sendKeys("ou are")    // ou are  (küçük yazmak için)
                .keyDown(Keys.SHIFT)   // shift tuşuna tekrar bas.
                .sendKeys("e")         // e yazdır
                .keyUp(Keys.SHIFT)     // shift tuşundan kaldır.
                .sendKeys("xceptional")
                .perform();



    }
}
