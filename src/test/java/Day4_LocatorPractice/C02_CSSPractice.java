package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C02_CSSPractice {

    /*
    1- http://the-internet.herokuapp.com//add_remove_elements/
    2- Click on the "Add Element" button 100 times.
    3- Write a funtion that takes a number, and clicks the "Delete" button.
    4- Given number of times, and then validates that given number of buttons was deleted.

    1.Method :createButtons(100)
    2.Method :DeleteButtonsAndValidate()
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();


        }
        @After
    public void close (){
        driver.quit();


    }

    @Test
    public void testCssPractice(){
        driver.get("http://the-internet.herokuapp.com//add_remove_elements/");

    createElements(100);
    deleteButtonsAndValidate(40);

    }
    public void createElements(int amount){


        WebElement addElementButton=driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i <amount ; i++) {
            addElementButton.click();
        }

    }
    public void deleteButtonsAndValidate(int amount){
      //sayfadaki delete button sayısını saklarız.
        List<WebElement> deleteButtonList= driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenonceDeleteButtonsayısı=deleteButtonList.size();//100

       //bizden istenen kadar button sileriz.
        for (int i = 0; i <amount ; i++) {
            deleteButtonList.get(i).click();
        }

        //silindikten sonraki buton sayısını bulunuz.
            List<WebElement> deleteButtonListAfter= driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
            int silinmedensonraDeleteButtonsayısı=deleteButtonListAfter.size();//60


        //ilk sayı ile son sayı arasındaki farkı bulunuz.
            Assert.assertEquals(silinmedenonceDeleteButtonsayısı- amount , silinmedensonraDeleteButtonsayısı);

    }


























}
