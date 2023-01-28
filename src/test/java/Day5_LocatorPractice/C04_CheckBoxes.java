package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C04_CheckBoxes {
    /*
    1- Go to http://the-internet.herokuapp.com/checkboxes.
    2- Locate the elements of checkboxes.
    3- Then click on checkbox 1 if box is not selected.
    4- Then click on checkbox 2 if box is not selected.
    5- Then verify that checkbox 1 is checked.

     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void checkbox(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");

      //checkbox locate edildi.
       List<WebElement> checkboxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
       WebElement checkbox1=checkboxes.get(0);
       WebElement checkbox2=checkboxes.get(1);

       //Checkbox1 seçili değilse tıklıyoruz.
       if(!checkbox1.isSelected()){
           checkbox1.click();
       }
        //Checkbox2 seçili değilse tıklıyoruz.
       if(!checkbox2.isSelected()){
           checkbox2.click();
       }

       //checkboxların seçili olup olduğunun kontrolü gerçekleştirildi.
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());


    }
}
