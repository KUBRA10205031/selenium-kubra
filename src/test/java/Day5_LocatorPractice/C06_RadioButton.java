package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_RadioButton {
    /*
    1- Go to URL: https://www.facebook.com/
    2- Click on Cretae an Account button.
    3- Then click on the radio buttons.
    4- Click 'kadın'
    5- Click 'erkek'
    6- Validate if 'kadın is not Selected and 'erkek' is selected.

     */

    WebDriver driver;
    @Before

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void RadioButton () throws InterruptedException {

        driver.get("https://www.facebook.com/");

        WebElement createAccount = driver.findElement(By.xpath("//a[contains(@data-testid,'registration-form')]"));
        createAccount.click();
        Thread.sleep(5000);

        WebElement kadınradioButton = driver.findElement(By.xpath("//input[@name='sex'and@value='1']"));
        kadınradioButton.click();
        WebElement erkekradioButton = driver.findElement(By.xpath("//input[@name='sex'and@value='2']"));
        erkekradioButton.click();

        Assert.assertTrue(erkekradioButton.isSelected());
        Assert.assertTrue(!kadınradioButton.isSelected());

    }






    }

