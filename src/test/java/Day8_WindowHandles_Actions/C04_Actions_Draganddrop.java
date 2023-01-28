package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C04_Actions_Draganddrop extends BaseTest {

    @Test
    public void dragandDropOffset(){
        driver.get("https://rangeslider.js.org/");
        WebElement slider= driver.findElement(By.xpath("(//div[@class='rangeslider__handle'])[1]"));

        Actions actions=new Actions(driver);

        //Sağa taşıma işlemleri için xOffset + olmalı ,sola taşıma işlemleri için xoffset - olmalı
        //Aynı zamanda dikey eksende hareket olmasını engellemek adına y offset 0 olarak belirlenmelidir.
        actions.dragAndDropBy(slider,200,0).perform();
    }
    @Test
    public void dragandDopoffsetVertical(){
        /*
        1- Go to URL : https://www.amazon.com/
        2- Click on "Hello, Sign in Account & Lists" link.
        3- Click on Orders page.
        4- Verify the page title contains "Amazon".
         */

        driver.get("https://www.amazon.com/");
        WebElement hovever= driver.findElement(By.xpath(""));
    }
}
