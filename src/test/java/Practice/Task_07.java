package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.util.Set;

public class Task_07 extends BaseTest {
    /*
    1-https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    2-Çİzili alan üzerinde sağ click yapalım
    3-Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    4-Tamam diyerek Alert'i kapatalım.
    5-Elemental Selenium linkine tıklayalım.
    6-Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.

     */

    @Test
    public void task() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement çizilialan= driver.findElement(By.id("hot-spot"));

        Actions action=new Actions(driver);
        action.contextClick(çizilialan).perform();

       Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");

        driver.switchTo().alert().accept();

        WebElement elementselenium= driver.findElement(By.xpath("//a[@target='_blank']"));
        elementselenium.click();

        String firstpage=driver.getWindowHandle();
        Set<String> allWindowPageHandle=driver.getWindowHandles();
        String secondpage="";

        for (String each:allWindowPageHandle){
          if (!each.equals(firstpage)){
              secondpage=each;
          }

        }
        driver.switchTo().window(secondpage);

        WebElement element= driver.findElement(By.tagName("h1"));

        Assert.assertEquals("yazmıyor.",element.getText(),("Elemental Selenium"));


    }

}
