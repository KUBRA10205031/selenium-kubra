package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Task {
    /*
    1-https://www.teknosa.com/ adresine gidiniz.
    2- Arama çubuğuna "oppo" yazıp ENTER tıklayınız.
    3- sonuç sayısını yazdırınız.
    4- çıkan ilk ürüne tıklayınız.
    5- Sepete ekleyiniz.
    6- Sepetime git e tıklayınız.
    7- Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
    8- Alışverişi tamamlayınız.
    9- Son olarak "Tekanosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
    10- Driver'ı kapatınız.
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
    public void task()  {

        driver.get("https://www.teknosa.com/");
        WebElement arama= driver.findElement(By.name("s"));

        //oppo araması yapıldı.
        arama.sendKeys("oppo"+ Keys.ENTER);
        WebElement sonuc= driver.findElement(By.className("plp-info"));
        System.out.println(sonuc.getText());

        //ilk ürüne tıklanıp sepete eklendi.
        WebElement tıkla=driver.findElement(By.className("prd-link"));
        tıkla.click();
        WebElement sepeteekle=driver.findElement(By.id("addToCartButton"));
        sepeteekle.click();

        //sepete git butonuna tıklandı.
        WebElement sepetegitetıkla= driver.findElement(By.className("btn btn-secondary"));
        sepetegitetıkla.click();

        //sipariş özeti texti yazdırıldı.
        WebElement siparişözeti= driver.findElement(By.xpath("//div[@class='cart-sum-title']"));
        System.out.println(siparişözeti.getText());

        //alışverişi tamamla butonuna basıldı.
        WebElement alışverişitamamla= driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']"));
        alışverişitamamla.click();

        //teknosaya hoş geldiniz texti yazdırıldı.
        WebElement teknosayahoşgeldiniz= driver.findElement(By.xpath("//div[@class='lrp-title']"));
        System.out.println(teknosayahoşgeldiniz.getText());
    }
}
