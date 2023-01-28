package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C02_ScrollWithExecutor extends BaseTest {

    /*
     executeScript("window.scrollBy(x-piksel,y-piksel)"); ya da js.executeScript(scroll(x,y);");
     x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse sağa hareket eder.
     y-piksel y eksenindeki sayıdır, sayı pozitifse aşağı doğru, sayı negatifse yukarı doğru hareket eder.

     js.executeScript("window.scrollBywindow.scrollBy(0,1000)"); // Dikey olarak 1000 piksel aşağı kaydır.

     js.executeScript("window.scrollTo(0,0)"); // en aşağıya gider.
     js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //en aşağıya gider.

     //scrollTo : Verilen pixele gider.
     //scrollBy : Verilen kadar daha ileri gider.

     scrollIntoView () web sayfasındaki bir ögenin görünürlülüğüne göre kaydırır.
     js.executeScript("arguments[0].scrollIntoView();" , webelement);

     */

    /*
    go to URL : https://api.jquery.com/dblclick/
    double click on the blue square at the bottom of the page and then write the changed color.

     */

    @Test
    public void doubleclickbutton() {
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);

        WebElement bluebox= driver.findElement(By.cssSelector("body>div"));
        JavascriptExecutor jse=(JavascriptExecutor)driver;

        jse.executeScript("arguments[0].scrollIntoView();" ,bluebox);
        System.out.println("color before:"+bluebox.getCssValue("background-color"));

        Actions actions=new Actions(driver);
        actions.doubleClick(bluebox).perform();
        System.out.println("color after:"+bluebox.getCssValue("background-color"));
}
}


