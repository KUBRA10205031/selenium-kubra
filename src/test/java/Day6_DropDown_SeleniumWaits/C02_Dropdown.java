package Day6_DropDown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();


    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void selectByIndex(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //Dropdown locate edildi.
        WebElement dropDown= driver.findElement(By.xpath("//select[@name='country']"));


        // Locate edilen dropdown select objesine dönüştürüldü.
        Select select=new Select(dropDown);

        select.selectByIndex(1); //ALGERIA
        //selectByIndex() methodu " 0 " ile başlar.


    }
    @Test
    public void selectByValue(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //Dropdown locate edildi.
        WebElement dropDown= driver.findElement(By.xpath("//select[@name='country']"));


        // Locate edilen dropdown select objesine dönüştürüldü.
        Select select=new Select(dropDown);
        select.selectByValue("TURKEY");
        //selectByValue() methodu option elementşlerinin value attribute unun değerine göre seçim yapar.



    }

    @Test
    public void selectByVisibleText(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //Dropdown locate edildi.
        WebElement dropDown= driver.findElement(By.xpath("//select[@name='country']"));


        // Locate edilen dropdown select objesine dönüştürüldü.
        Select select=new Select(dropDown);
        select.selectByVisibleText("FINLAND");

    }

    @Test
    public void multipleSelect(){
        driver.get("https://output.jsbin.com/osebed/2");

        //Dropdown locate ediliyor.
        Select select =new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());// birden fazla seçime izin veriyor mu diye kontrol ediyoruz.

        select.selectByValue("apple");

        select.selectByIndex(3);//Grape

    }
    @Test
    public void getOptions(){

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        Select select = new Select(driver.findElement(By.name("country")));
        List<WebElement> options =select.getOptions();

        for(WebElement option : options){
            System.out.println(option.getText());
        }
    }
    @Test
    public void getFirstSelectedOption() throws InterruptedException {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
         select.selectByIndex(3);      //  grape
         select.selectByIndex(2);       //orange
        WebElement selectoption=select.getFirstSelectedOption();
        System.out.println(selectoption.getText());
        Thread.sleep(5000);
        //getFirstSelectedOption(); methodu seçili olan ilk option elementini bize verir.(seçtiğimiz ilk option değil),
        //seçilmişlerin ilkini getirir.yani listede 1- banana      index sırasında göre listede ilk orange var onu getirir.
                                                  // 2-apple
                                                  // 3-orange +
                                                  // 4- grape  +
    }
    @Test
    public void getAllSelectedoptions(){
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByValue("banana");
        select.selectByValue("apple");

        List<WebElement> selectoptions= select.getAllSelectedOptions();

        selectoptions.forEach(x-> System.out.println(x.getText()));



    }

}
