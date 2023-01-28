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
import org.openqa.selenium.support.locators.RelativeLocator;

public class C01_RelativeLocator {
    /*
    1- Go to http://www.bestbuy.com
    2- Verify that the page title contains "Best" Also , using Relative Locator.
    3- LogoTest -> Verify if the BestBuy logo is displayed.
    4- mexicoLinkTest -> Verify if the Link is displayed.
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
    public void RelativeLocatorPractice(){

        driver.get("http://www.bestbuy.com");

       String baslık= driver.getTitle();
       baslık.contains("Best");
       Assert.assertTrue("baslık içermiyor.",baslık.contains("Best"));

        WebElement BestBuylogo= driver.findElement(By.xpath("//img[@class='logo']"));
        BestBuylogo.isDisplayed();
        Assert.assertTrue("hayır logo görünmüyor.",BestBuylogo.isDisplayed());

        WebElement Mexicologo= driver.findElement(By.xpath("//img[@alt='Mexico']"));
        Mexicologo.isDisplayed();
        Assert.assertTrue("hayır logo görünmüyor.",Mexicologo.isDisplayed());

       // driver.getTitle().contains("Best");
        //Assert.assertTrue("hayır içermiyor.",driver.getTitle().contains("Best"));

        /* -->> Relative Locator -->> (altında,üstünde methodlarını kullanarak çözümü ) ------>>> */

        driver.get("http://www.bestbuy.com");

        Assert.assertTrue("Title Best kelimesini içermiyor.",driver.getTitle().contains("Best"));

        //Logo locate ediliyor.

        By logoLocator= RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[text()='Hello!'"));
        WebElement logo= driver.findElement(logoLocator);
        Assert.assertTrue(logo.isDisplayed());

        //Mexico link locate edilip kontrol ediliyor.
        By mexicoLinkLocator = RelativeLocator.with(By.tagName("a")).toRightOf(By.xpath("//div[@lang='en']//a[@class='us-link']"));
        WebElement mexicolink=driver.findElement(mexicoLinkLocator);
        Assert.assertTrue(mexicolink.isDisplayed());

    }





























}
