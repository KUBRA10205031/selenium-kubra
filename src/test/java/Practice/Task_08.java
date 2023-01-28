package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task_08 extends BaseTest {
    /*
    1-https://demoqa.com/droppable adresine gidelim.
    2-"Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım.
    3-"Drop here" yazısı yerine "Dropped!" olduğunu test edin.
     */

    @Test
    public void draganddrop() {
        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);
        WebElement dragme=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drophere= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragme,drophere).perform();
        WebElement dropped=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals(dropped.getText(),"Dropped!");
    }
}
