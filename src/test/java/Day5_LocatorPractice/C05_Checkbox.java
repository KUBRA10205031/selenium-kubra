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

public class C05_Checkbox {
    /*
    1- Go to URL: https://demoqa.com
    2- Click on Elements.
    3- Click on Checkbox.
    4- Verify if home checkbox is selected.
    5- Verify that "You have selected." is visible.
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
        driver.get("https://demoqa.com");

        WebElement element= driver.findElement(By.xpath("//div[@class='card-up']"));
        element.click();

        WebElement checkbox= driver.findElement(By.id("item-1"));
        checkbox.click();

        WebElement home=driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        if(!home.isSelected()){
            home.click();
        }

        Assert.assertTrue(home.isDisplayed());

        WebElement selected= driver.findElement(By.xpath("//span[text()='You have selected :']"));
        Assert.assertTrue(selected.isDisplayed());

    }
}
