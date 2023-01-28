package Day6_DropDown_SeleniumWaits;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C06_AmazonPractice {

    /*
    1- Go to URL : "https://amazon.com"
    2- All butonuna tıkla "Electronic" seç.
    3- Arama butonundan "TV" arattır, ENTER 'e tıkla.
    4- 2.sayfaya git.,Sonuçlardan ilkini seç sepete ekle.
    5-
    6- Proceed checkout ' a tıkla.
    7- Email or mobile phone number" 'a gir.
    8- "continue" butonuna tıkla
    9- "There was a problem " yazsının görüntülendiğini kontrol et.
    10- Tarayıcıyı kapat.
     */


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void amazontest() throws InterruptedException {
        //1- Go to URL : "https://amazon.com"
        driver.get("https://amazon.com");

       //All butonundan "Electronic" seç. seç kelimesini gördüğümüzde select aklımıza gelecek.
        Select select=new Select(driver.findElement(By.id("searchDropdownBox")));
        select.selectByValue("search-alias=electronics-intl-ship");

        //Arama butonundan "TV" arattır, ENTER 'e tıkla.
        WebElement searchbutton= driver.findElement(By.id("twotabsearchtextbox"));
        searchbutton.sendKeys("TV"+ Keys.ENTER);

        //2.sayfaya git,
        WebElement secondpage= driver.findElement(By.xpath("//a[@aria-label=\"Go to page 2\"]"));
        secondpage.click();
        //Sonuçlardan ilkini seç
        WebElement tvselect=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        tvselect.click();
        //sepete ekle.
        WebElement AddtoCart=driver.findElement(By.id("add-to-cart-button"));
        AddtoCart.click();

        //Proceed checkout ' a tıkla.
        WebElement proceedcheckout=driver.findElement(By.name("proceedToRetailCheckout"));
        proceedcheckout.click();

        //Email or mobile phone number" 'a gir
        WebElement phonenumber=driver.findElement(By.id("ap_email"));
        Faker faker=new Faker();
        phonenumber.sendKeys(faker.phoneNumber().cellPhone());

        //"continue" butonuna tıkla
        WebElement contınuetıkla = driver.findElement(By.id("continue"));
        contınuetıkla.click();

        //"Incorrect phone number " yazsının görüntülendiğini kontrol et.
        WebElement problem=driver.findElement(By.xpath("//h4[@class='a-alert-heading']"));
        Assert.assertTrue(problem.isDisplayed());















    }
}
