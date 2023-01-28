package Day7_iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_İframeExample {
    /*
    1- Go To URL :
       "https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/"
    2- Web sitesini maximize yapınız.
    3- İkinci emojiye tıklayınız.
    4- ikinci emojideki tüm emojilere tıklayınız öğelerine tıklayınız.
    5- Parent iframe geri dönünüz.
    6- Formu doldurun (Formu istediğiniz metinlerde doldurun) apply button'a basınız.
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void iframeTest(){
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.switchTo().frame("emoojis");
        WebElement secondemojı= driver.findElement(By.xpath("//a[contains(@href,'nature')]"));//contains methodu ile locator bulduk.
        secondemojı.click();

        List<WebElement> emojilist= driver.findElements(By.xpath("//div[@id='nature']//img"));

        emojilist.forEach(WebElement::click); // her bir img elementine tıklanıyor lambda kullandıldı.

        driver.switchTo().defaultContent();//ana frame' e dönüldü.


        // form dolduruluyor.// faker ile de yapılabilirdi.
        WebElement text=driver.findElement(By.id("text"));
        text.sendKeys("Text");

        WebElement smiles=driver.findElement(By.id("smiles"));
        text.sendKeys("Smiles");

        WebElement nature=driver.findElement(By.id("nature"));
        text.sendKeys("Nature");

        WebElement food=driver.findElement(By.id("food"));
        text.sendKeys("Food");

        WebElement activities=driver.findElement(By.id("activities"));
        text.sendKeys("Activities");

        WebElement places=driver.findElement(By.id("places"));
        text.sendKeys("Places");

        WebElement objects=driver.findElement(By.id("objects"));
        text.sendKeys("Objects");

        //apply butonuna basılıyor.
        WebElement apply=driver.findElement(By.id("send"));
        apply.click();





    }

}
