package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Set;

public class Task_05 extends BaseTest {
    /*
    1-https://the-internet.herokuapp.com/windows adresine gidin.
    2-sayfadaki textin "Opening a new window" olduğunu doğrulayın
    3-sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
    4-Click Here butonuna basın.
    5-açılan yeni pencerenin sayfa başlığının (title) "New Window olduğunu doğrulayın.
    6-Syafdaki textin "New Window" olduğunu doğrulayın.
    7-Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.

     */
    @Test
    public void task() {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement text= driver.findElement(By.tagName("h3"));
        Assert.assertEquals("Text istediğin gibi değil.",text.getText(),"Opening a new window");
        Assert.assertTrue("1.sayfadaki title istenen değerden farklı", driver.getTitle().contains("The Internet"));

        String firstPageHandle=driver.getWindowHandle();
        WebElement clickhere= driver.findElement(By.linkText("Click Here"));
        clickhere.click();

        Set<String>allWindowHandles=driver.getWindowHandles();
        String secondwindowhandle="";
        for (String each:allWindowHandles) {
            if(!each.equals(firstPageHandle)){
                secondwindowhandle=each;
            }
        }
        driver.switchTo().window(secondwindowhandle);
        Assert.assertEquals("2.sayfadaki title istenen değerden farklı",driver.getTitle(),"New Window");

        Assert.assertEquals("New Window",driver.findElement(By.tagName("h3")).getText());
        driver.switchTo().window(firstPageHandle);
        Assert.assertTrue("1.sayfadaki title istedenen değerden bambaşka",driver.getTitle().contains("The Internet"));





    }
}
